USE donkeyRaces;

-- Insert owners
INSERT INTO owners (name, ID) VALUES
('John Doe', '12345'),
('Jane Smith', '67890'),
('Billy Bob', '54321');

-- Insert donkeys
INSERT INTO donkeys (name, age, breed, idOwner) VALUES
('Thunder', '5', 'Mule', 1),
('Storm', '3', 'Donkey', 2),
('Lightning', '4', 'Mule', 3);

-- Insert races
INSERT INTO races (date, place) VALUES
('2025-02-15', 'Sunny Park'),
('2025-03-10', 'Mountain Ridge'),
('2025-04-22', 'Desert Flats');

-- Insert gamblers
INSERT INTO gamblers (name, ID, balanceAvailable) VALUES
('Alice Green', '98765', 500),
('Bob Brown', '11223', 1000),
('Charlie White', '44556', 200);

-- Insert donkeysRaces (linking donkeys with races)
INSERT INTO donkeysRaces (idDonkey, idRace, placeArrival) VALUES
(1, 1, 1),  -- Thunder wins the first race
(2, 1, 2),  -- Storm comes second in the first race
(3, 1, 3),  -- Lightning comes third in the first race
(2, 2, 1),  -- Storm wins the second race
(1, 2, 2),  -- Thunder comes second in the second race
(3, 2, 3);  -- Lightning comes third in the second race

-- Insert gambling records
INSERT INTO gambling (idGambler, idDonkeyRace, amount) VALUES
(1, 1, 50),  -- Alice bets 50 on Thunder in the first race
(2, 2, 100), -- Bob bets 100 on Storm in the second race
(3, 3, 75);  -- Charlie bets 75 on Lightning in the third race

