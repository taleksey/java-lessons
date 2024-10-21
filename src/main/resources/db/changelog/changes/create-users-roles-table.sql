--liquibase formatted sql
--changeset java:create-users-roles-table
CREATE TABLE user_roles (rule_id bigint not null, user_id bigint not null, constraint foreign_key_roles
    foreign key (rule_id) references roles (id), username varbinary(255) null, constraint foreign_key_users
    foreign key (user_id) references users (id)) ENGINE=InnoDB;

--rollback DROP TABLE user_roles;
