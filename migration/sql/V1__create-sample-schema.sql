CREATE TABLE category
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    name       VARCHAR(20) NULL     DEFAULT NULL,
    order_by   INT         NULL     DEFAULT NULL,
    created_at DATETIME    NOT NULL,
    updated_at DATETIME    NOT NULL,
    PRIMARY KEY (id)
);

