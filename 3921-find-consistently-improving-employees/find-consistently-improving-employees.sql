/* Write your PL/SQL query statement below */

with cte as (
    select * from ( 
        select employee_Id, rating, row_number() over(partition by employee_id order by review_date DESC) rank from performance_reviews 
    ) where rank <= 3
)
select temp.employee_id, e.name, (temp.f - temp.t) improvement_score 
from (
    select 
        employee_id,
        sum(case when rank = 1 then rating end) f,
        sum(case when rank = 2 then rating end) s,
        sum(case when rank = 3 then rating end) t
    from cte
    group by employee_id
) temp JOIN Employees e on e.employee_id = temp.employee_id 
where f > s AND s > t
order by improvement_score DESC, e.name ASC 

-- select employee_id, sum(case when rank = 1 then rating when rank = 3 then -rating end ) improvement_score, count(*) rcnt from cte
-- group by employee_id
