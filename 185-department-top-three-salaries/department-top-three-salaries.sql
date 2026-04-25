/* Write your PL/SQL query statement below */

select 
    Department, 
    Employee, 
    Salary 
    from (
        select 
            d.name as Department, 
            e.name as Employee,
            e.salary,
            dense_rank() over(partition by e.departmentId order by e.salary desc) rank 
        from Employee e JOIN Department d on e.departmentId = d.id
    ) 
where rank <= 3
