CREATE TABLE departments
(
    `id`         BIGINT    NOT NULL AUTO_INCREMENT,
    `company_id` BIGINT    NOT NULL,
    `name`       VARCHAR(128),
    `version`    INTEGER,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);