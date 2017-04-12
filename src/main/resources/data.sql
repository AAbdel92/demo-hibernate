

insert into promo (nom) values ('Laposte');
insert into promo (nom) values ('PoleEmploi');

insert into role (nom) values ('ADMIN');
insert into role (nom) values ('TUTEUR');
insert into role (nom) values ('FORMATEUR');
insert into role (nom) values ('APPRENANT');

insert into utilisateur (pseudo, mot_de_passe, email, promo_id) 
values ('Abdel', 'rico', 'abdel@rico.com', 1);
insert into utilisateur (pseudo, mot_de_passe, email, promo_id) 
values ('Damien', 'osef', 'damien@osef.com', 1);
insert into utilisateur (pseudo, mot_de_passe, email, promo_id) 
values ('Franck', 'rien', 'franck@rien.com', 1);
insert into utilisateur (pseudo, mot_de_passe, email, promo_id) 
values ('Manu', 'form', 'manu@form.com', 1);
insert into utilisateur (pseudo, mot_de_passe, email, promo_id) 
values ('Michael', 'lbp', 'michael@lbp.com', 1);

insert into utilisateur_role (utilisateur_id, role_id)
values (1, 4);
insert into utilisateur_role (utilisateur_id, role_id)
values (2, 4);
insert into utilisateur_role (utilisateur_id, role_id)
values (3, 4);
insert into utilisateur_role (utilisateur_id, role_id)
values (4, 1);
insert into utilisateur_role (utilisateur_id, role_id)
values (4, 3);
insert into utilisateur_role (utilisateur_id, role_id)
values (5, 2);
