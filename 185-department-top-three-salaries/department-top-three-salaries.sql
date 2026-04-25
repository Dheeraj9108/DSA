/* Write your PL/SQL query statement below */

-- select salary, dense_rank() over ()

-- select distinct e.salary,e.departmentId,dense_rank() over(partition by departmentId order by salary) rank from employee e order by e.departmentId;

select Department, Employee, Salary from (select d.name as Department, e.name as Employee,e.salary, dense_rank() over(partition by e.departmentId order by e.salary desc) rank from Employee e JOIN Department d on e.departmentId = d.id) where rank <= 3
