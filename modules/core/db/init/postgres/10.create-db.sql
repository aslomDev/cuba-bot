-- begin BOT_TG_USER
create table BOT_TG_USER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_NAME varchar(255),
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    USER_ID bigint,
    --
    primary key (ID)
)^
-- end BOT_TG_USER
