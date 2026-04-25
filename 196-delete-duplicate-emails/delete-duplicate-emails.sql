/* Write your PL/SQL query statement below */
-- delete from person where id in ( 
--     select id from ( 
--         select id, row_number() over(partition by email order by id) r from person
--     ) where r > 1
-- )

delete from Person where id not in (select min(id) from Person group by email)