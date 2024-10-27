--liquibase formatted sql
--changeset java:create-roles-table
CREATE TABLE roles (id BIGINT NOT NULL AUTO_INCREMENT, name varbinary(255) not null, type enum ('ADMIN', 'GUEST', 'SUPER_ADMIN', 'USER') null, PRIMARY KEY (id)) ENGINE=InnoDB;

--rollback DROP TABLE roles;
