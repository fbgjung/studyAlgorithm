select r.car_id, r.car_type, 
    round(r.daily_fee * 30 * (100 - p.discount_rate) / 100) as fee
from car_rental_company_car r 
    join car_rental_company_rental_history h on r.car_id = h.car_id
    join car_rental_company_discount_plan p on r.car_type = p.car_type
    
where p.duration_type like '30%' 
    and r.car_id not in (
        select car_id
        from car_rental_company_rental_history
        where end_date >= '2022-11-01' and start_date <= '2022-12-01'
    )
    
group by r.car_id
having r.car_type in ('세단','SUV') and (fee >= 500000 and fee <= 2000000)
order by fee desc, car_type, car_id desc