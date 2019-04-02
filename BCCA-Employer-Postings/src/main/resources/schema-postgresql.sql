--DROP TABLE comments;
--DROP TABLE jobs;

CREATE TABLE IF NOT EXISTS jobs (
    jobId SERIAL PRIMARY KEY NOT NULL,
    company TEXT NOT NULL,
    position TEXT NOT NULL,
    location TEXT NOT NULL,
    prereqs TEXT NOT NULL,
    benefits TEXT NOT NULL,
    date_posted TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comments (
    id SERIAL PRIMARY KEY NOT NULL,
    jobId INT REFERENCES jobs(jobId) ON DELETE CASCADE NOT NULL,
    title TEXT NOT NULL,
    body TEXT NOT NULL
);
GRANT ALL ON TABLE jobs TO "postings";
GRANT ALL ON TABLE comments TO "postings";
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO  "postings";
GRANT ALL PRIVILEGES ON DATABASE "postings" TO "postings";

--INSERT INTO jobs (company, position, location, prereqs, benefits) VALUES ('Cspire', 'Software Engineer', 'Ridgeland,MS', '2+ years of experience', 'Available Benefits: Full Vision, Full Dental, Hull Health Care');
-- INSERT INTO comments (comment) VALUES ("A great opportunity!");

SELECT * FROM jobs;
SELECT * FROM comments;