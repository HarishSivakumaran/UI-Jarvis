DROP TABLE IF EXISTS project CASCADE;

CREATE TABLE project (
    id serial PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email_id VARCHAR(100) NOT NULL,
    project VARCHAR(1000) NOT NULL
);

INSERT INTO project("name", email_id, project)
        VALUES('Harish', 'harish@sap.com', 'file//urls');