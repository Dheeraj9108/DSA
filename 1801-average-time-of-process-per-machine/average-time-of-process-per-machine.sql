/* Write your PL/SQL query statement below */

select 
    machine_id, 
    Round(sum(case when activity_type = 'start' then -timestamp else timestamp end)/count(DISTINCT process_id),3) processing_time 
from Activity
group by machine_id