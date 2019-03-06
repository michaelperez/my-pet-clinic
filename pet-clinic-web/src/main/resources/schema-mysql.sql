CREATE
DATABASE IF NOT EXISTS mpc_dev;

ALTER
DATABASE mpc_dev
  DEFAULT CHARACTER
SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE mpc_dev;

CREATE TABLE IF NOT EXISTS vets
(
  id         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  INDEX(last_name
) ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties
(
  id          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(80),
  INDEX(description
) ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialties
(
  vet_id       BIGINT(20) UNSIGNED NOT NULL,
  specialty_id BIGINT(20) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets (id),
  FOREIGN KEY (specialty_id) REFERENCES specialties (id),
  UNIQUE (vet_id, specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS types
(
  id   BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name
) ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS owners
(
  id         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  address    VARCHAR(255),
  city       VARCHAR(80),
  telephone  VARCHAR(20),
  INDEX(last_name
) ) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pets
(
  id         BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    BIGINT(20) UNSIGNED NOT NULL,
  owner_id   BIGINT(20) UNSIGNED NOT NULL,
  INDEX(name
),
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visits
(
  id          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id      BIGINT(20) UNSIGNED NOT NULL,
  visit_date  DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets (id)
) engine=InnoDB;