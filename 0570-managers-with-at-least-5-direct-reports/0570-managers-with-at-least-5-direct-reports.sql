# Write your MySQL query statement below
select e.name from Employee e 
join Employee em 
on e.id = em.managerId
GROUP BY e.id, e.name
HAVING COUNT(em.managerId) >= 5;