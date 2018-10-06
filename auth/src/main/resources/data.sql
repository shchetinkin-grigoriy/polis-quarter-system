INSERT INTO sec_privilege (privilege_id, name, description) VALUES (1, 'PRIVILEGE_ADMIN_READ', 'description for privilege admin read');
INSERT INTO sec_privilege (privilege_id, name, description) VALUES (2, 'PRIVILEGE_USER_READ', 'description for privilege user read');

INSERT INTO sec_role (role_id, name, description) VALUES (1, 'ROLE_ADMIN', 'description for role admin');
INSERT INTO sec_role (role_id, name, description) VALUES (2, 'ROLE_USER', 'description for role user');

INSERT INTO sec_role_privileges (sec_role_role_id, privileges_privilege_id) VALUES (1, 1);
INSERT INTO sec_role_privileges (sec_role_role_id, privileges_privilege_id) VALUES (2, 2);

INSERT INTO sec_user (id, enabled, username, password) VALUES (1, true, 'admin', 'admin');
INSERT INTO sec_user (id, enabled, username, password) VALUES (2, true, 'user', 'user');

INSERT INTO sec_user_roles (sec_user_id, roles_role_id) VALUES (1, 1);
INSERT INTO sec_user_roles (sec_user_id, roles_role_id) VALUES (2, 2);