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
(nextval('users_user_id_seq'),'John', 'Doe', 'active', CURRENT_DATE, 'customer', '+36123456789', 'password123', 'johndoe@example.com', 1),
(nextval('users_user_id_seq'),'Jane', 'Smith', 'active', CURRENT_DATE, 'customer', '+36123456788', 'password456', 'janesmith@example.com', 2);

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
(nextval('restaurant_restaurant_id_seq'),'Pasta Palace', 'https://example.com/pasta.jpg', 'Authentic Italian Cuisine', 5.99, 'https://pastapalace.com', '+3612341234', 1, 1),
(nextval('restaurant_restaurant_id_seq'),'Taco Town', 'https://example.com/taco.jpg', 'Best Tacos in Town', 4.99, 'https://tacotown.com', '+3612345678', 2, 2);

-- Insert sample data into menu table
INSERT INTO menu (menu_id, menu_name, restaurant_id)
VALUES 
(nextval('menu_menu_id_seq'),'Lunch Specials', 1),
(nextval('menu_menu_id_seq'),'Dinner Specials', 2);

-- Insert sample data into dish table
INSERT INTO dish (dish_id, dish_name, description, price, picture_url, menu_id)
VALUES 
(nextval('dish_dish_id_seq'),'Spaghetti Carbonara', 'Classic Italian pasta with pancetta', 12.99, 'https://example.com/spaghetti.jpg', 1),
(nextval('dish_dish_id_seq'),'Taco Supreme', 'Loaded taco with all the toppings', 8.99, 'https://example.com/taco.jpg', 2);

-- Insert sample data into favourites table
INSERT INTO favourites (user_id, restaurant_id, dish_id, favourite_type)
VALUES 
(1, 1, NULL, 'restaurant'),
(1, NULL, 1, 'dish');

-- Insert sample data into orders table
INSERT INTO orders (order_id, delivery_time, system_usage_fee, order_status, order_date, total_amount, user_id)
VALUES 
(1,'12:30', 1.50, 'delivered', CURRENT_DATE, 15.49, 1),
(2,'18:45', 1.50, 'in transit', CURRENT_DATE, 20.99, 2);

-- Insert sample data into order_items table
INSERT INTO order_items (order_item_id, order_id, dish_id, quantity, price)
VALUES 
(1,1, 1, 2, 12.99),
(2,2, 2, 1, 8.99);

-- Insert sample data into payment table
INSERT INTO payment (payment_id, amount, status, payment_method, payment_date, order_id)
VALUES 
(1,15.49, 'completed', 'credit card', CURRENT_DATE, 1),
(2,20.99, 'pending', 'paypal', CURRENT_DATE, 2);

-- Insert sample data into user_address table (junction table for multiple addresses per user)
INSERT INTO user_address (user_id, address_id)
VALUES 
(1, 1),
(2, 2);

-- Insert sample data into dish_allergen table (junction table for allergens in dishes)
INSERT INTO dish_allergen (dish_id, allergen_id)
VALUES 
(1, 1),  -- Spaghetti Carbonara has Peanuts allergen
(2, 3);  -- Taco Supreme has Gluten allergen
