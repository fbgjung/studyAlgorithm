select o.animal_id, o.animal_type, o.name
from animal_outs as o, animal_ins as i
where o.animal_id = i.animal_id
AND (o.SEX_UPON_OUTCOME like "Spayed%" OR o.SEX_UPON_OUTCOME like "Neutered%") 
AND i.SEX_UPON_INTAKE like "Intact%"
order by animal_id