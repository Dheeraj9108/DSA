/* Write your PL/SQL query statement below */
select
ROUND(SUM(tiv_2016),2) as tiv_2016 from insurance
where (lat, lon) IN (
    SELECT lat, lon from Insurance group by lat,lon having count(*) = 1
) and tiv_2015 in (
    Select tiv_2015 from Insurance group by tiv_2015 having count(*) > 1  
)