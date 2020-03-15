-- TASK: SELECT * that pulls from main table and where is simple

-- Select all the columns in customers where the name is your name for example'ANTHONY'

SELECT * FROM customers WHERE name = 'ANTHONY';

-- TASK: SELECT certain column on sub table and complex where, dates, null, etc.

-- Select the customer name, account name, and balance where the account was 
-- created on or after Jan. 15, 2019 and the balance is greater than zero

SELECT c.name, a.name, a.balance 
FROM customers AS c
JOIN accounts AS a ON c.id = a.customer_id
WHERE a.created >= '2019-01-15' AND a.balance > 0
ORDER BY c.name;

-- TASK: Know and have available examples of GROUP BY, ORDER BY, basic functions like COUNT or MAX

