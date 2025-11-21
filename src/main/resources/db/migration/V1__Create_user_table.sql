CREATE TYPE ROLES as ENUM ('Employee', 'Manager', 'Admin');

create table users
(
    id        BIGSERIAL PRIMARY KEY,
    user_name text not null,
    password  text not null,
    email     text not null,
    roles     roles[] default '{Employee}'::ROLES[],
    check ( email like '%@%.%')
);

create table user_tasks
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT not null,
    task_id BIGINT not null,
    constraint fk_user_task_user_id foreign key (user_id) references users (id) on delete cascade,
    constraint fk_user_task_task_id foreign key (task_id) references tasks (id) on delete cascade
)