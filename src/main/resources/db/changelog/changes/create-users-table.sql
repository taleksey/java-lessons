--liquibase formatted sql
--changeset java:create-users-table
CREATE TABLE users (id BIGINT NOT NULL AUTO_INCREMENT, email varbinary(255) null, phone_number varbinary(255) null, username varbinary(255) null, PRIMARY KEY (id)) ENGINE=InnoDB;

--rollback DROP TABLE users;
