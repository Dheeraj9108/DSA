-- /* Write your PL/SQL query statement below */

(
    select name as results 
    from (
        select u.name
        from MovieRating r JOIN Users u on u.user_id = r.user_id 
        group by r.user_id, u.name
        order by count(*) DESC, u.name ASC
    ) 
    where rownum = 1 
)
union ALL
(   
    select title results 
    from (
        Select mr.movie_id, m.title, avg(mr.rating) rating
        from MovieRating mr JOIN Movies m on mr.movie_id = m.movie_id
        where to_char(created_at, 'YYYY-MM') = '2020-02'
        group by mr.movie_id, m.title
        order by rating DESC, m.title ASC
    ) 
    where rownum = 1
)



-- (
--     SELECT name AS result 
--     FROM (
--         SELECT u.name
--         FROM MovieRating r JOIN Users u ON u.user_id = r.user_id 
--         GROUP BY r.user_id, u.name
--         ORDER BY count(*) DESC, u.name ASC
--     )
--     WHERE rownum = 1
-- )
-- UNION ALL
-- (   
--     SELECT title AS result 
--     FROM (
--         SELECT m.title, avg(mr.rating) AS rating
--         FROM MovieRating mr JOIN Movies m ON mr.movie_id = m.movie_id
--         WHERE to_char(mr.created_at, 'YYYY-MM') = '2020-02'
--         GROUP BY mr.movie_id, m.title
--         ORDER BY rating DESC, m.title ASC
--     ) 
--     WHERE rownum = 1
-- )