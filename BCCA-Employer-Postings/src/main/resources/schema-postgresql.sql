CREATE TABLE IF NOT EXISTS jobs (
    id SERIAL PRIMARY KEY NOT NULL,
    company TEXT NOT NULL,
    position TEXT NOT NULL,
    location TEXT NOT NULL
);

--ALTER TABLE jobs OWNER TO "user";
-- GRANT ALL ON TABLE jobs TO "user";
--
-- GRANT ALL PRIVILEGES ON DATABASE "application-db" TO "user";
--
-- INSERT INTO applications (company, position, location) VALUES ("Cspire", "Software Engineer", "Ridgeland, MS");