INSERT INTO vets
VALUES (1, 'James', 'Carter');
INSERT INTO vets
VALUES (2, 'Helen', 'Leary');
INSERT INTO vets
VALUES (3, 'Linda', 'Douglas');
INSERT INTO vets
VALUES (4, 'Rafael', 'Ortega');
INSERT INTO vets
VALUES (5, 'Henry', 'Stevens');
INSERT INTO vets
VALUES (6, 'Sharon', 'Jenkins');

INSERT INTO specialties
VALUES (1, 'Radiology');
INSERT INTO specialties
VALUES (2, 'Surgery');
INSERT INTO specialties
VALUES (3, 'Dentistry');

INSERT INTO vet_specialties
VALUES (2, 1);
INSERT INTO vet_specialties
VALUES (3, 2);
INSERT INTO vet_specialties
VALUES (3, 3);
INSERT INTO vet_specialties
VALUES (4, 2);
INSERT INTO vet_specialties
VALUES (5, 1);

INSERT INTO types
VALUES (1, 'Cat');
INSERT INTO types
VALUES (2, 'Dog');
INSERT INTO types
VALUES (3, 'Lizard');
INSERT INTO types
VALUES (4, 'Snake');
INSERT INTO types
VALUES (5, 'Bird');
INSERT INTO types
VALUES (6, 'Hamster');

INSERT INTO owners
VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners
VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO owners
VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO owners
VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO owners
VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO owners
VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO owners
VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO owners
VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO owners
VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO owners
VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT INTO pets
VALUES (1, 'Eddy', PARSEDATETIME('2010-09-07', 'yyyy-MM-dd'), 1, 1);
INSERT INTO pets
VALUES (2, 'Basil', PARSEDATETIME('2012-08-06', 'yyyy-MM-dd'), 6, 2);
INSERT INTO pets
VALUES (3, 'Rosy', PARSEDATETIME('2011-04-17', 'yyyy-MM-dd'), 2, 3);
INSERT INTO pets
VALUES (4, 'Jewel', PARSEDATETIME('2010-03-07', 'yyyy-MM-dd'), 2, 3);
INSERT INTO pets
VALUES (5, 'Iggy', PARSEDATETIME('2010-11-30', 'yyyy-MM-dd'), 3, 4);
INSERT INTO pets
VALUES (6, 'George', PARSEDATETIME('2010-01-20', 'yyyy-MM-dd'), 4, 5);
INSERT INTO pets
VALUES (7, 'Samantha', PARSEDATETIME('2012-09-04', 'yyyy-MM-dd'), 1, 6);
INSERT INTO pets
VALUES (8, 'Max', PARSEDATETIME('2012-09-04', 'yyyy-MM-dd'), 1, 6);
INSERT INTO pets
VALUES (9, 'Lucky', PARSEDATETIME('2011-08-06', 'yyyy-MM-dd'), 5, 7);
INSERT INTO pets
VALUES (10, 'Mulligan', PARSEDATETIME('2007-02-24', 'yyyy-MM-dd'), 2, 8);
INSERT INTO pets
VALUES (11, 'Freddy', PARSEDATETIME('2010-03-09', 'yyyy-MM-dd'), 5, 9);
INSERT INTO pets
VALUES (12, 'Lucky', PARSEDATETIME('2010-06-24', 'yyyy-MM-dd'), 2, 10);
INSERT INTO pets
VALUES (13, 'Sly', PARSEDATETIME('2012-06-08', 'yyyy-MM-dd'), 1, 10);

INSERT INTO visits
VALUES (1, 7, PARSEDATETIME('2013-01-01', 'yyyy-MM-dd'), 'Rabies shot');
INSERT INTO visits
VALUES (2, 8, PARSEDATETIME('2013-01-02', 'yyyy-MM-dd'), 'Rabies shot');
INSERT INTO visits
VALUES (3, 8, PARSEDATETIME('2013-01-03', 'yyyy-MM-dd'), 'Neutered');
INSERT INTO visits
VALUES (4, 7, PARSEDATETIME('2013-01-04', 'yyyy-MM-dd'), 'Spayed');