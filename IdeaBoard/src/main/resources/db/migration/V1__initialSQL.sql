DROP TABLE IF EXISTS project CASCADE;

CREATE TABLE project (
    id serial PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email_id VARCHAR(100) NOT NULL,
    project_url VARCHAR(1000) NOT NULL
);
