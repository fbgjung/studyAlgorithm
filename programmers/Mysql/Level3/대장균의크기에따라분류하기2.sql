with temp as (select id, percent_rank() over (order by size_of_colony desc) as p from ecoli_data)

select id,
    case
        when p <= 0.25 then 'CRITICAL'
        when p <= 0.50 then 'HIGH'
        when p <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as colony_name
  from temp
 order by id;