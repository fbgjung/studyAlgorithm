SELECT p.PRODUCT_ID, p.PRODUCT_NAME, p.price * sum(o.amount) as total_sales
from FOOD_PRODUCT as p
join FOOD_ORDER as o on p.PRODUCT_ID = o.PRODUCT_ID
where produce_date like "2022-05%"
group by p.product_id
order by total_sales desc, p.product_id 