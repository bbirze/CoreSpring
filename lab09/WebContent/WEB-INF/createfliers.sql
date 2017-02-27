CREATE TABLE Flier
(
   FlierID         INT NOT NULL IDENTITY PRIMARY KEY,
   Name            VARCHAR(200),
   MileageBalance  INT
);


CREATE TABLE Award
(
   AwardID         INT NOT NULL IDENTITY PRIMARY KEY,
   Description     VARCHAR(200),
   MilesRequired   INT,
   FlierID         INT,
   FOREIGN KEY (FlierID) REFERENCES Flier(FlierID)
);

    
INSERT INTO Flier (Name, MileageBalance) VALUES ('John Smith', 50000);
INSERT INTO Flier (Name, MileageBalance) VALUES ('Sue Harrison', 150000);

INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('LAX-BOS', 3300, 1);
INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('BOS-LAX', 3300, 1);

INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('SFO-DEN', 1800, 2);
INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('DEN-SFO', 1800, 2);
INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('SFO-LAX', 500, 2);
INSERT INTO Award (Description, MilesRequired, FlierID) VALUES ('LAX-SFO', 500, 2);

