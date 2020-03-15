-- Select all columns from users where the user's role is admin
SELECT * 
FROM users
WHERE role = 'admin';

-- Select name and description from items that were created after Sept. 20, 2019 and the description isn't null
SELECT name, description
FROM items
WHERE created > '2019-09-20' AND description IS NOT NULL;

-- Select first_name and last_name from users and order by when they were created, latest first
SELECT first_name, last_name
FROM users
ORDER BY created DESC;


-- Select finished and a count all the items that are finished/not finished
SELECT finished, COUNT(*)
FROM items
GROUP BY finished;


-- Select a user's first_name and last_name and the item's name for every finished item
SELECT users.first_name, users.last_name, items.name, items.finished
FROM users
JOIN items ON users.id = items.user_id
WHERE items.finished = 'true';
