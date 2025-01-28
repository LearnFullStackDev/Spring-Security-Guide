# DEFAULT SCHEMA FOR SPRING SECURITY

create table users (
    username VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY,
    password VARCHAR_IGNORECASE(50) NOT NULL,
    enabled BOOLEAN NOT NULL
);

create table authorities (
    username VARCHAR_IGNORECASE(50) NOT NULL,
    authority VARCHAR_IGNORECASE(50) NOT NULL,
    CONSTRAINT fk_authorities_user FOREIGN KEY (username) REFERENCES users(username)
);

create unique index ix_auth_username on authorities (username,authority);