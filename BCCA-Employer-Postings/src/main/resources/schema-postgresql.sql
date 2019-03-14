CREATE TABLE IF NOT EXISTS jobs (
    jobId SERIAL PRIMARY KEY NOT NULL,
    company TEXT NOT NULL,
    position TEXT NOT NULL,
    location TEXT NOT NULL,
    benefits TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS comments (
    id SERIAL PRIMARY KEY NOT NULL,
    jobId INT REFERENCES jobs(jobId) NOT NULL,
    comment TEXT NOT NULL
);
-- INSERT INTO jobs (company, position, location) VALUES ("Cspire", "Software Engineer", "Ridgeland, MS", "Available Benefits: Full Vision, Full Dental, Hull Health Care");
-- INSERT INTO comments (comment) VALUES ("A great opportunity!");