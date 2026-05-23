/* Write your PL/SQL query statement below */

with cte as (select driver_id, trip_date, distance_km/fuel_consumed fe from trips),
cte2 as (select c.driver_id, d.driver_name, AVG(case when to_char(trip_date, 'MM') BETWEEN 1 AND 6 then fe else NULL end) as first_half_avg, 
 AVG(case when to_char(trip_date, 'MM') BETWEEN 7 AND 12 then fe else NULL end) as second_half_avg 
from cte c JOIN drivers d on c.driver_id = d.driver_id 
group by c.driver_id, d.driver_name
)

select c.driver_id, c.driver_name, ROUND(c.first_half_avg, 2) as first_half_avg, ROUND(c.second_half_avg, 2) as second_half_avg, ROUND(c.second_half_avg - c.first_half_avg, 2) efficiency_improvement  from cte2 c  
where c.second_half_avg IS NOT null AND c.first_half_avg IS NOT null AND c.second_half_avg > c.first_half_avg
order by efficiency_improvement DESC, c.driver_name ASC