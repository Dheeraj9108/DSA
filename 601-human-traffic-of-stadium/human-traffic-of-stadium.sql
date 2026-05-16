/* Write your PL/SQL query statement below */

select distinct s.id, TO_CHAR(s.visit_date, 'YYYY-MM-DD') as visit_date, s.people from Stadium s JOIN 
(
    select 
    lead(id,1) over (order by visit_date) next1, 
    lead(id,2) over (order by visit_date) next2, 
    id 
    from Stadium where people >= 100
) t on s.id = t.id OR s.id = t.next1 OR s.id = t.next2 
where t.id = t.next1 - 1 AND t.id = t.next2 - 2 order by visit_date