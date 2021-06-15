CREATE TABLE category
(
    id         BIGINT      NOT NULL AUTO_INCREMENT,
    name       VARCHAR(20) NULL DEFAULT NULL,
    order_by   INT         NULL DEFAULT NULL,
    created_at DATETIME    NOT NULL,
    updated_at DATETIME    NOT NULL,
    PRIMARY KEY (id)
) ENGINE = INNODB;

INSERT INTO category (id, name, order_by, created_at, updated_at)
VALUES (1, '教育', 1, NOW(), NOW());
INSERT INTO category (id, name, order_by, created_at, updated_at)
VALUES (2, 'スポーツ', 2, NOW(), NOW());
INSERT INTO category (id, name, order_by, created_at, updated_at)
VALUES (3, '趣味', 3, NOW(), NOW());

CREATE TABLE sub_category
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    category_id BIGINT      NOT NULL,
    name        VARCHAR(20) NULL DEFAULT NULL,
    order_by    INT         NULL DEFAULT NULL,
    created_at  DATETIME    NOT NULL,
    updated_at  DATETIME    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE
);

INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (1, '受験', 1, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (1, '数学', 2, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (1, '英語', 3, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (1, '化学', 4, NOW(), NOW());

INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (2, 'テニス', 5, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (2, 'サッカー', 6, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (2, 'ラグビー', 7, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (2, '野球', 8, NOW(), NOW());

INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (3, '園芸', 9, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (3, '音楽', 10, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (3, 'アニメ', 11, NOW(), NOW());
INSERT INTO sub_category (category_id, name, order_by, created_at, updated_at)
VALUES (3, 'ゲーム', 12, NOW(), NOW());


