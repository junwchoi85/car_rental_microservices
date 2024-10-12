-- H2 Database Schema Script

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mydb;
SET SCHEMA mydb;

-- -----------------------------------------------------
-- Table app_users
-- -----------------------------------------------------
DROP TABLE IF EXISTS app_users;

CREATE TABLE IF NOT EXISTS app_users (
  ausr_id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(90) NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by VARCHAR(45)  NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by VARCHAR(45),
  UNIQUE (username),
  UNIQUE (email)
);

-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  user_code VARCHAR(7) NOT NULL,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  UNIQUE (user_code),
  UNIQUE (username)
);

-- -----------------------------------------------------
-- Table roles
-- -----------------------------------------------------
DROP TABLE IF EXISTS roles;

CREATE TABLE IF NOT EXISTS roles (
  role_id INT AUTO_INCREMENT PRIMARY KEY,
  role_code VARCHAR(7) NOT NULL,
  description TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  UNIQUE (role_code)
);

-- -----------------------------------------------------
-- Table cars
-- -----------------------------------------------------
DROP TABLE IF EXISTS cars;

CREATE TABLE IF NOT EXISTS cars (
  car_id INT AUTO_INCREMENT PRIMARY KEY,
  car_code VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  model_year VARCHAR(45) NOT NULL,
  passenger INT NOT NULL,
  transmission VARCHAR(6) NOT NULL,
  luggage_large INT NOT NULL,
  luggage_small INT NOT NULL,
  engine VARCHAR(45) NOT NULL,
  fuel VARCHAR(45) NOT NULL,
  status VARCHAR(45) CHECK (status IN ('active', 'inactive', 'deleted')),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  UNIQUE (car_code)
);

-- -----------------------------------------------------
-- Table car_details
-- -----------------------------------------------------
DROP TABLE IF EXISTS car_details;

CREATE TABLE IF NOT EXISTS car_details (
  car_detail_id INT AUTO_INCREMENT PRIMARY KEY,
  car_id INT NOT NULL,
  mileage VARCHAR(45),
  color VARCHAR(45),
  vin VARCHAR(45),
  status VARCHAR(45),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (car_id) REFERENCES cars(car_id)
);

-- -----------------------------------------------------
-- Table car_rental_terms
-- -----------------------------------------------------
DROP TABLE IF EXISTS car_rental_terms;

CREATE TABLE IF NOT EXISTS car_rental_terms (
  car_rental_term_id INT AUTO_INCREMENT PRIMARY KEY,
  car_id INT,
  min_rent_period INT,
  max_rent_period INT,
  price_per_day DECIMAL(10,2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (car_id) REFERENCES cars(car_id)
);

-- -----------------------------------------------------
-- Table bookings
-- -----------------------------------------------------
DROP TABLE IF EXISTS bookings;

CREATE TABLE IF NOT EXISTS bookings (
  booking_id INT AUTO_INCREMENT PRIMARY KEY,
  ausr_id INT NOT NULL,
  car_detail_id INT NOT NULL,
  booking_code VARCHAR(45) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  total_fee FLOAT,
  status VARCHAR(45),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (ausr_id) REFERENCES app_users(ausr_id),
  FOREIGN KEY (car_detail_id) REFERENCES car_details(car_detail_id),
  UNIQUE (booking_code)
);

-- -----------------------------------------------------
-- Table promotions
-- -----------------------------------------------------
DROP TABLE IF EXISTS promotions;

CREATE TABLE IF NOT EXISTS promotions (
  promotion_id INT AUTO_INCREMENT PRIMARY KEY,
  promotion_code VARCHAR(45) NOT NULL,
  description TEXT,
  discount_rate DECIMAL(5,2),
  dt_start TIMESTAMP,
  dt_end TIMESTAMP,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  UNIQUE (promotion_code)
);

-- -----------------------------------------------------
-- Table car_promotion
-- -----------------------------------------------------
DROP TABLE IF EXISTS car_promotion;

CREATE TABLE IF NOT EXISTS car_promotion (
  car_promotion_id INT AUTO_INCREMENT PRIMARY KEY,
  car_rental_term_id INT,
  promotion_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (promotion_id) REFERENCES promotions(promotion_id),
  FOREIGN KEY (car_rental_term_id) REFERENCES car_rental_terms(car_rental_term_id)
);

-- -----------------------------------------------------
-- Table user_role
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_role;

CREATE TABLE IF NOT EXISTS user_role (
  uro_id INT AUTO_INCREMENT PRIMARY KEY,
  description TEXT,
  user_id INT,
  role_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- -----------------------------------------------------
-- Table payments
-- -----------------------------------------------------
DROP TABLE IF EXISTS payments;

CREATE TABLE IF NOT EXISTS payments (
  payment_id INT AUTO_INCREMENT PRIMARY KEY,
  booking_id INT,
  ausr_id INT,
  amount DECIMAL(10,2) NOT NULL,
  payment_date TIMESTAMP,
  payment_status VARCHAR(45) COMMENT '결제 status : pending, completed, failed',
  transaction_id VARCHAR(100) COMMENT '결제 제공업체의 거래 ID',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_by VARCHAR(7) DEFAULT 'system' NOT NULL,
  updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_by VARCHAR(7),
  FOREIGN KEY (ausr_id) REFERENCES app_users(ausr_id),
  FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
  UNIQUE (transaction_id)
);