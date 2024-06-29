CREATE TABLE events (
    event_id SERIAL PRIMARY KEY,
    description TEXT,
    magnitude VARCHAR(255) CHECK (magnitude IN ('MINOR','MODERATE','MAJOR','CATASTROPHIC')),
    date DATE,
    pollutant_id INTEGER,
    resource_id INTEGER,
    CONSTRAINT fk_pollutant FOREIGN KEY(pollutant_id) REFERENCES pollutants(pollutant_id),
    CONSTRAINT fk_resource FOREIGN KEY(resource_id) REFERENCES resources(resource_id)
);