# Write your MySQL query statement below
Select w.id from Weather w
 join Weather h 
 on DATEDIFF(w.recordDate , h.recordDate) = 1 
 where w.temperature > h.temperature;