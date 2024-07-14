with temp as (
    select cart_id, name
    from cart_products
    where name in ('yogurt','milk')
    )

select cart_id
from temp
group by cart_id
having count(distinct name) = 2
order by cart_id;