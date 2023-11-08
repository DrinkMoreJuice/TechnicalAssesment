CREATE TABLE match (
    id SERIAL PRIMARY KEY,
    description VARCHAR(200),
    match_date DATE,
    match_time TIME,
    team_a VARCHAR(50),
    team_b VARCHAR(50),
    sport VARCHAR(20)
);

CREATE TABLE match_odds (
    id SERIAL PRIMARY KEY,
    match_id INT,
    specifier VARCHAR(1),
    odd FLOAT,
    FOREIGN KEY (match_id) REFERENCES match(id)
);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES ('Match 01', '2023-11-02', '12:00:00', 'Team A', 'Team B', 'Football');

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES ('Match 02', '2023-11-02', '12:00:00', 'Team C', 'Team D', 'Basketball');

INSERT INTO match_odds (match_id, specifier, odd) 
VALUES(1, '1', 1), (1, '2', 2), (1, 'X', 1.5), (2, '1', 2.2), (2, '2', 0.7), (2, 'X', 1.8);
