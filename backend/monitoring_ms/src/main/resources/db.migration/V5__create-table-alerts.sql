CREATE TABLE alerts (
    alert_id SERIAL PRIMARY KEY,
    date DATE,
    level VARCHAR(255) CHECK (level IN ('GREEN','YELLOW','ORANGE','RED')),
    message TEXT,
    user_id INTEGER,
    event_id INTEGER,
    CONSTRAINT fk_event FOREIGN KEY(event_id) REFERENCES events(event_id)
);