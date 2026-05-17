/* Write your PL/SQL query statement below */
 
with cte as (select p_id from Tree)

select id, 
    case 
        when p_id IS null then 'Root' 
        when id in (select * from cte) then 'Inner' 
        ELSE 'Leaf'
    END as type 
from Tree