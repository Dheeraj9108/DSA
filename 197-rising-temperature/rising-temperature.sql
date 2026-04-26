/* Write your PL/SQL query statement below */

select id from (
    select w.*, 
    lag(temperature,1) over (order by recordDate) as prevTemp, 
    lag(recordDate,1) over (order by recordDate) as prevDate
    from Weather w) t 
where t.temperature > prevTemp AND t.recordDate - prevDate = 1

-- select w.*, lag(temperature) over (order by recordDate) as prev from Weather w