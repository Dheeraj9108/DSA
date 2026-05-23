/* Write your PL/SQL query statement below */

select contest_id, Round((count(*)/(select count(*) from users))*100, 2) as percentage 
from Register
group by contest_id 
order by percentage DESC, contest_id ASC