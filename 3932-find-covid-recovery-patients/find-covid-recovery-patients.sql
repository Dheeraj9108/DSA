/* Write your PL/SQL query statement below */

-- select p.patient_id, p.patient_name, p.age, (neg.first_neg - pos.first_pos) recovery_time from patients p
-- select * from patients p
-- JOIN (
 with cte as 
(select pos.patient_id, first_pos, neg from 
    (
        select c.patient_id, min(c.test_date) first_pos 
        from covid_tests c
        where c.result = 'Positive'
        group by c.patient_id
    ) pos
    JOIN
    (
        select c.patient_id, c.test_date neg 
        from covid_tests c
        where c.result = 'Negative' 
    ) neg on pos.patient_id = neg.patient_id AND pos.first_pos <= neg.neg
)

select p.patient_id, p.patient_name, p.age, (first_neg - first_pos) recovery_time 
from patients p JOIN 
(
    select PATIENT_ID, min(neg) first_neg, first_pos 
    from cte
    group by PATIENT_ID, first_pos 
) temp on temp.patient_id = p.patient_id
order by recovery_time ASC, p.patient_name ASC
