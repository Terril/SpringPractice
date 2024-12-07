CREATE TABLE IF NOT EXISTS Banner (
id       VARCHAR(60)  PRIMARY KEY,
title     VARCHAR      NULL,
imageUrl     VARCHAR      NULL,
descr     VARCHAR       NULL,
upload   DATETIME  NULL,
expiry   DATETIME  NULL
);


CREATE TABLE IF NOT EXISTS Category (
id       VARCHAR(60)  PRIMARY KEY,
title     VARCHAR      NULL,
imageUrl     VARCHAR      NULL,
descr     VARCHAR       NULL
);

CREATE TABLE IF NOT EXISTS Products (
    id VARCHAR(60) PRIMARY KEY, -- Assuming ID is a unique identifier (UUID or similar)
    product_name VARCHAR(255) NOT NULL,
    product_title VARCHAR(255) NOT NULL,
    product_sku VARCHAR(255) NOT NULL,
    quantity INT NULL,
    product_expiry DATE NULL,
    product_discount INT NULL,
    product_price INT NOT NULL,
    product_price_after_discount INT NULL,
    product_weight INT NULL,
    product_info TEXT NULL,
    product_serving_number INT NULL,
    -- Add other product attributes like price, description, etc.
    category_id VARCHAR(255), -- Foreign key referencing Categories.id
    FOREIGN KEY (category_id) REFERENCES Category(id)
);


CREATE TABLE IF NOT EXISTS product_images (
    id VARCHAR(60) PRIMARY KEY,
    product_id VARCHAR(255),
    image_url TEXT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Products(id)
);
