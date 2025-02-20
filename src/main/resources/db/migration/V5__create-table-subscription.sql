CREATE TABLE IF NOT EXISTS table_subscription (
    subscription_number INT AUTO_INCREMENT PRIMARY KEY,
    subscribed_user_id INT NOT NULL,
    indication_user_id INT DEFAULT NULL,
    event_id INT NOT NULL,
    CONSTRAINT fk_tbl_subscription_tbl_event FOREIGN KEY (event_id) REFERENCES table_event (event_id),
    CONSTRAINT fk_tbl_subscription_tbl_user FOREIGN KEY (subscribed_user_id) REFERENCES table_user (user_id),
    CONSTRAINT fk_table_subscription_tbl_user FOREIGN KEY (indication_user_id) REFERENCES table_user (user_id)
);

CREATE INDEX fk_tbl_subscription_tbl_user_idx ON table_subscription (subscribed_user_id);
CREATE INDEX fk_tbl_subscription_tbl_user1_idx ON table_subscription (indication_user_id);
CREATE INDEX fk_tbl_subscription_tbl_event1_idx ON table_subscription (event_id);