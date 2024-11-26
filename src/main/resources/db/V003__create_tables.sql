-- Set the correct Schema
SET search_path TO bytebites;

CREATE TABLE address (
	address_id SERIAL PRIMARY KEY,
	postal_code VARCHAR(10) NOT NULL,
	city VARCHAR(100) NOT NULL,
	street_name VARCHAR(100) NOT NULL,
	public_place_name VARCHAR(100),
	house_number VARCHAR(10),
	building VARCHAR(50),
	staircase VARCHAR(10),
	floor VARCHAR(10),
	door VARCHAR(10)
);
CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    status VARCHAR(50),
    registration_date DATE NOT NULL,
    user_type VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15),
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
	address_id INT,
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);
CREATE TABLE allergens (
	allergen_id SERIAL PRIMARY KEY,
	allergen_name VARCHAR(100) NOT NULL UNIQUE
);
CREATE TABLE cart (
	cart_id SERIAL PRIMARY KEY,
	total_price DECIMAL(10, 2) NOT NULL,

	user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE category (
	category_id SERIAL PRIMARY KEY,
	category_name VARCHAR(100) NOT NULL,
	picture_url VARCHAR(255)
);
CREATE TABLE restaurant (
	restaurant_id SERIAL PRIMARY KEY,
    restaurant_name VARCHAR(100) NOT NULL,
    picture_url VARCHAR(255),
    description TEXT,
    delivery_fee DECIMAL(10, 2),
    website VARCHAR(255),
    phone_number VARCHAR(15),
	address_id INT,
    category_id INT,
    FOREIGN KEY (address_id) REFERENCES address(address_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);
CREATE TABLE city (
	city_id SERIAL PRIMARY KEY,
    city_name VARCHAR(100) NOT NULL,
	category_id INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);
CREATE TABLE menu (
	menu_id SERIAL PRIMARY KEY,
    menu_name VARCHAR(100) NOT NULL,
	 restaurant_id INT NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id)
);
CREATE TABLE dish (
	dish_id SERIAL PRIMARY KEY,
    dish_name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    picture_url VARCHAR(255),
	menu_id INT,
    FOREIGN KEY (menu_id) REFERENCES menu(menu_id)
);
CREATE TABLE favourites (
    favourite_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    restaurant_id INT,
    dish_id INT,
    favourite_type VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurant_id),
    FOREIGN KEY (dish_id) REFERENCES dish(dish_id)
);

CREATE TABLE orders (
	order_id SERIAL PRIMARY KEY,
    delivery_time TIME,
    system_usage_fee DECIMAL(10, 2),
    order_status VARCHAR(50),
    order_date DATE NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
	user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE order_items (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    dish_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (dish_id) REFERENCES dish(dish_id)
);
CREATE TABLE payment (
	payment_id SERIAL PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50),
    payment_method VARCHAR(50) NOT NULL,
    payment_date DATE NOT NULL,
	order_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);


-- Junction tables for relationships
CREATE TABLE user_address (
    user_id INT NOT NULL,
    address_id INT NOT NULL,
    PRIMARY KEY (user_id, address_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE dish_allergen (
    dish_id INT NOT NULL,
    allergen_id INT NOT NULL,
    PRIMARY KEY (dish_id, allergen_id),
    FOREIGN KEY (dish_id) REFERENCES dish(dish_id),
    FOREIGN KEY (allergen_id) REFERENCES allergens(allergen_id)
);

--INDEXES:
-- Index for quick lookup of users by email
CREATE INDEX idx_user_email ON users(email);

-- Indexes on foreign key columns
CREATE INDEX idx_favourites_user_id ON favourites(user_id);
CREATE INDEX idx_favourites_restaurant_id ON favourites(restaurant_id);
CREATE INDEX idx_favourites_dish_id ON favourites(dish_id);

CREATE INDEX idx_orders_user_id ON orders(user_id);
CREATE INDEX idx_order_items_order_id ON order_items(order_id);
CREATE INDEX idx_order_items_dish_id ON order_items(dish_id);

CREATE INDEX idx_payment_order_id ON payment(order_id);

CREATE INDEX idx_dish_menu_id ON dish(menu_id);
CREATE INDEX idx_restaurant_address_id ON restaurant(address_id);
CREATE INDEX idx_restaurant_category_id ON restaurant(category_id);
