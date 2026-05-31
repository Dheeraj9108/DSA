/* Write your PL/SQL query statement below */

with cte as (
    select student_id, subject, score, exam_date, row_number() over(partition by student_id,subject order by exam_date ASC, score ASC) rnk_asc,
    row_number() over(partition by student_id, subject order by exam_date desc, score desc) rnk_desc 
    from Scores
), fst as(
    select * from cte where rnk_asc = 1
), lst as (
    select * from cte where rnk_desc = 1
)

select f.student_id, f.subject, f.score as first_score, l.score as latest_score from fst f JOIN lst l on f.student_id = l.student_id  and f.subject = l.subject
where l.exam_date > f.exam_date AND l.score > f.score
order by f.student_id, f.subject   
