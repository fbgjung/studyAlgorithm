select id, 
    case 
        when size_of_colony <= 100 then 'LOW'
        when 100 < size_of_colony and size_of_colony <=1000 then 'MEDIUM'
        when 1000 < size_of_colony then 'HIGH'
    end as SIZE
from ecoli_data;


select id, 
    case 
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony <=1000 then 'MEDIUM'
        else 'HIGH'
    end as SIZE
from ecoli_data;