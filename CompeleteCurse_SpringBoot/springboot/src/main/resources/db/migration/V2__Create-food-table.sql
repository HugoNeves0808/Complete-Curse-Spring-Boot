CREATE TABLE food (
    id_food UUID PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE PRECISION NOT NULL
);