insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (password, username)
values
('$2a$12$JSYjkbR.SUVQpn/Vp7Y3bOD2.IsS17QvRqCtjK9OATUo/rVdFX/Ym', 'user');

insert into users_roles (user_id, role_id) values (1, 2);