-- # Write your MySQL query statement below
-- select name from(
--     select a.*, count(b.managerId)as countt 
--     from Employee a left join Employee b 
--     on a.id = b.managerId 
--     group by
--     a.id
-- )sub where countt >= 5;

SELECT a.name
FROM Employee a
LEFT JOIN Employee b
    ON a.id = b.managerId
GROUP BY a.id
HAVING COUNT(b.managerId) >= 5;