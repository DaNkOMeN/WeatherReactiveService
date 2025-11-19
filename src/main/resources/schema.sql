create table if not exists weather_info(
    id identity not null,
    region varchar(255) not null,
    country varchar(255) not null,
    state varchar(255) not null,
    city varchar(255) not null,
    local_date DATE not null,
    avg_temperature varchar(255) not null
);