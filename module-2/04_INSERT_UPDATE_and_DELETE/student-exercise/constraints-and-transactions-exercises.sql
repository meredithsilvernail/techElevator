-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

INSERT INTO actor(first_name, last_name)
VALUES('Hampton', 'Avenue');

INSERT INTO actor(first_name, last_name)
VALUES('Lisa', 'Byway');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

INSERT INTO film(title, description, release_year, language_id, length)
VALUES('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in
 ancient Greece', 2008, 1, 198);


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

SELECT * FROM actor WHERE first_name = 'Lisa' AND last_name = 'Byway';
SELECT * FROM actor WHERE first_name = 'Hampton' AND last_name = 'Avenue';
SELECT * FROM film WHERE title = 'Euclidian PI';

INSERT INTO film_actor(actor_id, film_id)
VALUES(201, 1001);

INSERT INTO film_actor(actor_id, film_id)
VALUES(202, 1001);

-- 4. Add Mathmagical to the category table.

INSERT INTO category(name)
VALUES('Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
SELECT * FROM category WHERE name = 'Mathmagical';
SELECT * FROM film WHERE title IN('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE');

INSERT INTO film_category(film_id, category_id)
VALUES(274, 17);
INSERT INTO film_category(film_id, category_id)
VALUES(494, 17);
INSERT INTO film_category(film_id, category_id)
VALUES(714, 17);
INSERT INTO film_category(film_id, category_id)
VALUES(996, 17);
INSERT INTO film_category(film_id, category_id)
VALUES(1001, 17);

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

UPDATE film SET rating = 'G'
WHERE film_id IN
(
SELECT film_id
FROM film_category
WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical')

);

-- 7. Add a copy of "Euclidean PI" to all the stores.

--SELECT * FROM store;
--SELECT * FROM film WHERE title = 'Euclidean PI';

--INSERT INTO inventory(film_id, store_id)
--VALUES(1001, 1);

--INSERT INTO inventory(film_id, store_id)
--VALUES(1001, 2);

INSERT INTO inventory(film_id, inventory_id)
VALUES (SELECT film_id FROM film WHERE title='Euclidean PI');

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)

--DELETE FROM film
--WHERE title = 'Euclidean PI';
--Unable to delete - this film is referenced as a foreign key in other tables, so it cannot be removed while those links exist



-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
--DELETE FROM category
--WHERE name = 'Mathmagical';

-- Unable to delete - category is being referenced as a foreign key in other tables (like previous question)

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- It did succeed - this is where the link was established to add to a film, so this is where we can remove it

DELETE FROM film_category 
WHERE category_id IN

(SELECT category_id
FROM category
WHERE name = 'Mathmagical'
);

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- Mathmagical was deleted per the film-category table no longer has it linked. Can't delete the film yet per it is still 
--linked in the film-actor table

DELETE FROM category
WHERE name = 'Mathmagical';

--DELETE FROM film
--WHERE title = 'Euclidean PI';

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
--It would need to be removed from the film-actor table so the film id is not being used as a foreign key anywhere else
