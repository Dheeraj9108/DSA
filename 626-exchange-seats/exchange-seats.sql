/* Write your PL/SQL query statement below */

with cte as (select id, student, lag(student, 1) over (order by id) as prev, lead(student,1) over (order by id) as next from Seat)

select id, 
case 
    when MOD(id,2) <> 0 AND next IS NULL then student
    when MOD(id,2) <> 0 then next
    ELSE prev
END as student
from cte

