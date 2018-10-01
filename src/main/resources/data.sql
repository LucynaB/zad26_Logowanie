

INSERT INTO user(id, first_name,last_name,user_name,password,enabled) VALUES (1, 'Anna','Kowalska','admin','{bcrypt}$2a$10$ZmBeJAHt7uoK5DeRAnN/h.1d8AIgvq6I0Bk7Fa4ztwVAtPm1/.aNO', true);
INSERT INTO user(id, first_name,last_name,user_name,password,enabled) VALUES (2, 'Piotr','Nowak','user1','{bcrypt}$2a$10$Qi5T60PTDCh9LEkh6SNNLeo1PUY9pIffD/fdDFvRhPO6m5pRUFhuC', true);
INSERT INTO user(id, first_name,last_name,user_name,password,enabled) VALUES (3, 'Jan','Majewski','user2','{bcrypt}$2a$10$KinV2Uf/EgFttFGlULoxYe0FFqdLaDcVp7AEhJztJb0iLwFSY5wuu', true);


INSERT INTO USER_ROLE(user_name, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(user_name, role) values ('user1', 'ROLE_USER');
INSERT INTO USER_ROLE(user_name, role) values ('user2', 'ROLE_USER');

