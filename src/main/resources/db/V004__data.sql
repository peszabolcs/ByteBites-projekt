-- Set the correct Schema
SET search_path TO bytebites;

-- Insert sample data into address table
INSERT INTO address (address_id, postal_code, city, street_name, public_place_name, house_number)
VALUES 
(nextval('address_address_id_seq'), '1011', 'Budapest', 'Fő utca', 'Building', '1'),
(nextval('address_address_id_seq'), '1052', 'Budapest', 'Kossuth Lajos utca', NULL, '2A');

-- Insert sample data into users table
INSERT INTO users (user_id, first_name, last_name, status, registration_date, user_type, phone_number, password, email, address_id)
VALUES 
(nextval('users_user_id_seq'),'John', 'Doe', 'active', CURRENT_DATE, 'customer', '+36123456789', 'password123',
 'johndoe@example.com', (select address_id from address where postal_code = '1011')),
(nextval('users_user_id_seq'),'Jane', 'Smith', 'active', CURRENT_DATE, 'customer', '+36123456788', 'password456',
 'janesmith@example.com', (select address_id from address where postal_code = '1052'));

-- Insert sample data into allergens table
INSERT INTO allergens (allergen_id, allergen_name)
VALUES 
(nextval('allergens_allergen_id_seq'),'Peanuts'),
(nextval('allergens_allergen_id_seq'),'Dairy'),
(nextval('allergens_allergen_id_seq'),'Gluten');

-- Insert sample data into category table
INSERT INTO category (category_id, category_name, picture_url)
VALUES 
(nextval('category_category_id_seq'),'Italian', 'https://example.com/italian.jpg'),
(nextval('category_category_id_seq'),'Mexican', 'https://example.com/mexican.jpg');

-- Insert sample data into restaurant table
INSERT INTO restaurant (restaurant_id, restaurant_name, picture_url, description, delivery_fee, website, phone_number, address_id, category_id)
VALUES 
(nextval('restaurant_restaurant_id_seq'),'Pasta Palace', 'https://example.com/pasta.jpg', 'Authentic Italian Cuisine', 5.99,
 'https://pastapalace.com', '+3612341234', (select address_id from address where postal_code = '1052'), (select category_id from category where category_name = 'Italian')),
(nextval('restaurant_restaurant_id_seq'),'Taco Town', 'https://example.com/taco.jpg', 'Best Tacos in Town', 4.99,
 'https://tacotown.com', '+3612345678', (select address_id from address where postal_code = '1052'), (select category_id from category where category_name = 'Mexican'));

-- Insert sample data into dish table
INSERT INTO dish (dish_id, dish_name, description, price, picture_url, restaurant_id)
VALUES 
(nextval('dish_dish_id_seq'),'Spaghetti Carbonara', 'Classic Italian pasta with pancetta', 12.99, 'https://example' ||
                                                                                                  '.com/spaghetti' ||
                                                                                                  '.jpg', (select restaurant_id from restaurant where restaurant_name = 'Pasta Palace')),
(nextval('dish_dish_id_seq'),'Taco Supreme', 'Loaded taco with all the toppings', 8.99, 'https://example.com/taco' ||
                                                                                        '.jpg', (select restaurant_id from restaurant where restaurant_name = 'Taco Town'));

-- Insert sample data into favourites table
INSERT INTO favourites (user_id, restaurant_id, dish_id, favourite_type)
VALUES 
((select user_id from users where first_name = 'John'), (select restaurant_id from restaurant where restaurant_name =
                                                                                              'Pasta Palace'), (select dish_id from dish where dish_name = 'Spaghetti Carbonara'), 'dish'),
((select user_id from users where first_name = 'Jane'), (select restaurant_id from restaurant where restaurant_name =
                                                                                               'Taco Town'), (select
                                                                                                                  dish_id from dish where dish_name = 'Taco Supreme'),
 'dish');

-- Insert sample data into orders table
INSERT INTO orders (order_id, delivery_time, system_usage_fee, order_status, order_date, total_amount, user_id)
VALUES 
(nextval('orders_order_id_seq'), '12:30', 1.50, 'delivered', CURRENT_DATE, 15.49, (select user_id from users where
                                                                                                                 first_name = 'John')),
(nextval('orders_order_id_seq'), '18:45', 1.50, 'in transit', CURRENT_DATE, 20.99, (select user_id from users where
                                                                                                                  first_name = 'Jane'));

-- Insert sample data into cart_items table
-- INSERT INTO cart_items (cart_item_id, order_id, dish_id, quantity, price)
-- VALUES
-- (nextval('cart_items_order_item_id_seq'), (select order_id from orders where user_id = (select user_id from users
--                                                                                                         where
--                                                                                                             first_name = 'John')), (select dish_id from dish where dish_name = 'Spaghetti Carbonara'), 2, 12.99),
-- (nextval('cart_items_order_item_id_seq'), (select order_id from orders where user_id = (select user_id from users
--                                                                                                         where first_name = 'Jane')), (select dish_id from dish where dish_name = 'Taco Supreme'), 1, 8.99);

-- Insert sample data into payment table
INSERT INTO payment (payment_id, amount, status, payment_method, payment_date, order_id)
VALUES 
(nextval('payment_payment_id_seq'),15.49, 'completed', 'credit card', CURRENT_DATE, (select order_id from orders
                                                                                                     where user_id =
                                                                                                           (select
                                                                                                                user_id from users where first_name = 'John'))),
(nextval('payment_payment_id_seq'),20.99, 'pending', 'paypal', CURRENT_DATE, (select order_id from orders where
                                                                                                              user_id = (select user_id from users where first_name = 'Jane')));

-- Insert sample data into user_address table (junction table for multiple addresses per user)
INSERT INTO user_address (user_id, address_id)
VALUES 
((select user_id from users where first_name = 'John'), (select address_id from address where postal_code = '1011')),
((select user_id from users where first_name = 'Jane'), (select address_id from address where postal_code = '1052'));

-- Insert sample data into dish_allergen table (junction table for allergens in dishes)
INSERT INTO dish_allergen (dish_id, allergen_id)
VALUES 
((select dish_id from dish where dish_name = 'Spaghetti Carbonara'), (select allergen_id from allergens where
                                                                                   allergen_name = 'Dairy')),
((select dish_id from dish where dish_name = 'Taco Supreme'), (select allergen_id from allergens where allergen_name =
                                                                                   'Gluten'));
