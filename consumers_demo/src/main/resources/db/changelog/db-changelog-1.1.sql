--liquibase formatted sql

--changeset grisha:1
ALTER TABLE users
    ADD CONSTRAINT emailConstr UNIQUE (email);


