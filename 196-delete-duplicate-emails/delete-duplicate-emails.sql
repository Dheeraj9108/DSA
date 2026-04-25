/* Write your PL/SQL query statement below */
delete from person where id in ( 
    select id from ( 
        select id, row_number() over(partition by email order by id) r from person
    ) where r > 1
)