CREATE TABLE measurements (
    measurement_id SERIAL PRIMARY KEY,
    date DATE,
    ph FLOAT,
    temperature FLOAT,
    user_id INTEGER,
    pollutant_id INTEGER,
    resource_id INTEGER,
    CONSTRAINT fk_pollutant FOREIGN KEY(pollutant_id) REFERENCES pollutants(pollutant_id),
    CONSTRAINT fk_resource FOREIGN KEY(resource_id) REFERENCES resources(resource_id)
);