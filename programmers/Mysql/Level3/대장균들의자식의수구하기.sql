/*
ecoli_data 테이블에서 id와 함께 서브쿼리를 사용하면 되는데,
ecoli_data 테이블에서 parent_id가 id인 개수를 넣으면 된다.
*/

select id, ifnull(
    ( 
        select count(*) 
          from ecoli_data 
          group by parent_id 
          having parent_id = id 
    ), 0
) as child_count
          
from ecoli_data
order by id

-- other solution
select id ,(select count(*)  from ecoli_data b where b.parent_id = a. id) as child_count
from ecoli_data a;