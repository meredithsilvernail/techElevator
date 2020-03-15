-- Select all columns from posts that are published
SELECT *
FROM posts
WHERE published = 'true';

-- Select posted_by and body from comments that have a body and were created after Oct. 15, 2019
SELECT posted_by, body
FROM comments
WHERE created > '2019-10-15';

-- Select the name and published states from posts ordered by when they were created, earliest first
SELECT name, published
FROM posts
ORDER BY created ASC;

-- Select the created date and the count of all the comments created on that date
SELECT created, COUNT(comments)
FROM comments
GROUP by created;

-- Select the post name, comment posted_by and comment body for all posts created after Oct. 1st, 2019
SELECT posts.name, comments.posted_by, comments.body
FROM posts
JOIN comments ON posts.id = comments.post_id
WHERE posts.created > '2019-10-01';

