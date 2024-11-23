-- Set the correct Schema
SET search_path TO bytebites;

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
