/* Write your PL/SQL query statement below */

select x,y,z, case when( x+y > z AND y+z > x AND x+z > y) then 'Yes' ELSE 'No' END as triangle from Triangle 