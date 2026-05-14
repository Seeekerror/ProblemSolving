# Write your MySQL query statement below
select contest_id, 
ROUND(COUNT(user_id) * 100.00 / (SELECT COUNT(*) FROM Users), 2) 
as percentage from Register
group by contest_id 
order by percentage desc , contest_id asc;