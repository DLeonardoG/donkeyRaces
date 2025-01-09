	DROP database if exists donkeyRaces;
	CREATE database donkeyRaces;
	USE donkeyRaces;
	
	CREATE TABLE IF NOT EXISTS owners (
	    idOwner INT NOT NULL AUTO_INCREMENT,
	    name VARCHAR(255) NOT NULL,
	    ID VARCHAR(255) NOT NULL,
	    PRIMARY KEY (idOwner)
	);
	CREATE TABLE IF NOT EXISTS donkeys (
	    idDonkey INT NOT NULL AUTO_INCREMENT,
	    name VARCHAR(255) NOT NULL,
	    age VARCHAR(255) NOT NULL,
	    breed VARCHAR(255) NOT NULL,
	    idOwner int NOT NULL,
        FOREIGN KEY (idOwner) REFERENCES owners(idOwner),
	    PRIMARY KEY (idDonkey)
	);
	
	CREATE TABLE IF NOT EXISTS races (
	    idRace INT NOT NULL AUTO_INCREMENT,
	    date DATE NOT NULL,
	    place VARCHAR(255) NOT NULL,
	    PRIMARY KEY (idRace)
	);
	CREATE TABLE IF NOT EXISTS gamblers (
	    idGambler INT NOT NULL AUTO_INCREMENT,
	    name VARCHAR(255) NOT NULL,
	    ID VARCHAR(255) NOT NULL,
	    balanceAvailable int NOT NULL,
	    PRIMARY KEY (idGambler)
	);
	
    CREATE TABLE donkeysRaces(
    idDonkeyRace INT NOT NULL AUTO_INCREMENT,
    idDonkey int NOT NULL,
    idRace int NOT NULL,
    placeArrival int,
    FOREIGN KEY (idDonkey) REFERENCES donkeys(idDonkey),
    FOREIGN KEY (idRace) REFERENCES races(idRace),
    PRIMARY KEY (idDonkeyRace)
);
    CREATE TABLE gambling (
    idGambling INT NOT NULL AUTO_INCREMENT,
    idGambler int NOT NULL,
    idDonkeyRace int NOT NULL,
    amount int,
    FOREIGN KEY (idGambler) REFERENCES gamblers(idGambler),
    FOREIGN KEY (idDonkeyRace) REFERENCES donkeysRaces(idDonkeyRace),
    PRIMARY KEY (idGambling)
);