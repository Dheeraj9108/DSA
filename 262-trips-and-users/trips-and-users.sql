/* Write your PL/SQL query statement below */

select 
    t.request_at as Day,
    ROUND(SUM(CASE when t.status <> 'completed' THEN 1 ELSE 0 END) / COUNT(*), 2) as "Cancellation Rate" 
from Trips t
JOIN users u1 on u1.users_id = t.client_id
JOIN users u2 on u2.users_id = t.driver_id
where u1.banned <> 'Yes' AND
u2.banned <> 'Yes' AND
TO_DATE(t.request_at, 'YYYY-MM-DD')  between TO_DATE('2013-10-01', 'YYYY-MM-DD') AND TO_DATE('2013-10-03', 'YYYY-MM-DD') group by t.request_at