/* Write your PL/SQL query statement below */


with cte as (select employee_id from meetings
group by employee_id, trunc(meeting_date, 'IW')
having sum(duration_hours) > 20)

select e.employee_id, e.employee_name, e.department, meeting_heavy_weeks 
from Employees e JOIN (  select employee_id, count(*) as meeting_heavy_weeks 
        from cte 
        group by employee_id 
        having count(*) >= 2
    ) c on e.employee_id = c.employee_id
order by meeting_heavy_weeks DESC , e.employee_name ASC 
