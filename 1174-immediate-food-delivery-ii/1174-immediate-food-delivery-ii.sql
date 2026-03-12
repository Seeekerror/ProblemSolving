# Write your MySQL query statement below
SELECT 
    ROUND(
        100 * AVG(order_date = customer_pref_delivery_date),
        2
    ) AS immediate_percentage
FROM Delivery d
JOIN (
    SELECT customer_id, MIN(order_date) AS first_date
    FROM Delivery
    GROUP BY customer_id
) f
ON d.customer_id = f.customer_id
AND d.order_date = f.first_date;