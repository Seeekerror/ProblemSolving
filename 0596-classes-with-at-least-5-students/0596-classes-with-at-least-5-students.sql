# Write your MySQL query statement below
select class from Courses 
GROUP BY class
HAVING COUNT(student) >= 5;