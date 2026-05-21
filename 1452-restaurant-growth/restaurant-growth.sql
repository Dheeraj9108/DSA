/* Write your PL/SQL query statement below */

select visited_on, ag amount, average_amount from (
    select
        rownum rn, a.* 
    from (
        select 
            to_char(visited_on,'YYYY-MM-DD') as visited_on, 
            ag, 
            ROUND((ag/7),2) as average_amount 
        from (
            select 
                visited_on, amount, 
                    SUM(amount) over(order by visited_on range between INTERVAL '6' DAY PRECEDING AND CURRENT ROW ) as ag 
            from 
                Customer
        )
        group by 
            to_char(visited_on,'YYYY-MM-DD'), ag
        order by 
            visited_on
    ) a
)
where rn >= 7