/* Write your PL/SQL query statement below */

select * from Cinema where MOD(id,2) <> 0 AND description <> 'boring' order by rating DESC