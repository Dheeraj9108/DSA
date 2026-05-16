/* Write your PL/SQL query statement below */
with cte as (select customer_number, count(*) as cnt from Orders group by customer_number)
select customer_number from cte where cnt = (select max(cnt) from cte)