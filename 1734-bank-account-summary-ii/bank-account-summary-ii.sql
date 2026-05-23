/* Write your PL/SQL query statement below */

select u.name, sum(amount) balance 
from Transactions t JOIN Users u on u.account = t.account
group by u.name
having sum(amount) > 10000