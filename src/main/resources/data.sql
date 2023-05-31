--drop table chamis cascade;
--drop table arrets cascade;
--drop table defis cascade;
--drop table etapes cascade;
--drop table questions cascade;
--drop table indices cascade;

--Ajouter les Arrets
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENBERRIAT', 'BERRIAT-LE MAGASIN', 'https://www.google.com/maps/@45.1887486,5.7064745,3a,33.5y,6.99h,90.28t/data=!3m6!1e1!3m4!1spKqyVVnkojg9VyheBCnBOA!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENBIBLIUNI', 'BIBLIOTHÈQUES UNIVERSITAIRES', 'https://www.google.com/maps/@45.1929768,5.7708905,3a,15y,174.85h,88.88t/data=!3m6!1e1!3m4!1s6nGYZZVjcop5qBpR0gpbtQ!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENCHAVANT', 'CHAVANT', 'https://www.google.com/maps/@45.185495,5.7311437,3a,75y,15.22h,86.39t/data=!3m6!1e1!3m4!1sFKcCCWmRM6FnmSQfcD_Jxg!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENCLINBELD', 'CLINIQUE BELLEDONNE', 'https://www.google.com/maps/@45.1859727,5.7603181,3a,15y,244.68h,84.37t/data=!3m6!1e1!3m4!1sQenHRK5ydHK0SwxRTwmcHA!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENCXPATRE', 'CROIX DU PÂTRE', 'https://www.google.com/maps/@45.1683689,5.7627437,3a,15.7y,181.36h,86.37t/data=!3m6!1e1!3m4!1sKtypwYoRCVKHt7FIy3-yIg!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENDUBEDOUT', 'HUBERT DUBEDOUT - MAISON DU TOURISME', 'https://www.google.fr/maps/@45.1901564,5.7284658,3a,75y,188.5h,83.99t/data=!3m6!1e1!3m4!1sZWGfsMXx2sjXNXmgQ6RcEg!2e0!7i13312!8i6656');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENGREHOTEL', 'GRENOBLE HÔTEL DE VILLE', 'https://www.google.fr/maps/@45.1875745,5.737518,3a,75y,335.06h,79.17t/data=!3m6!1e1!3m4!1snQioz7enAccxCiyLV0zBrg!2e0!7i16384!8i8192');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENVICTHUGO', 'VICTOR HUGO', 'https://www.google.com/maps/@45.1898119,5.7250558,3a,75y,327.55h,83.64t/data=!3m6!1e1!3m4!1sD3q07wHDE23LN4vLFEYPjQ!2e0!7i13312!8i6656');
insert into arrets (codeTAG, arret, lien_street_map) values ('SEM_GENGABFAUR', 'GABRIEL FAURE', 'https://www.google.com/maps/place/Gabriel+Faur%C3%A9/@45.1922892,5.7643895,15z/data=!4m9!1m2!2m1!1sGabriel+Faur%C3%A9!3m5!1s0x478af5a819ee2c2b:0x752a39adf9629a65!8m2!3d45.1922596!4d5.7644324!15sCg5HYWJyaWVsIEZhdXLDqZIBCXRyYW1fc3RvcA%27');

--Ajouter les Chamis
insert into chamis (login, age, description,email) values ('koi', 23, 'C est Koi!', 'koi@gmail.com');
insert into chamis (login, age, description,email) values ('moha', 33, 'C est Moha!','moha@gmail.com');
insert into chamis (login, age, description,email) values ('anais', 37, 'C est Anais!', 'anais@gmail.com');
insert into chamis (login, age, description,email) values ('min',  13, 'C est Min!', 'min@gmail.com');

--Ajouter les Defis
insert into defis(id, description, titre, date_de_creation, arret, auteur, epilogue) 
values ('1','Pour réaliser ce défi vous devez trouver des packets caché sur le campus de grenoble, chaque paquet à soit une couleur ou une lettre alphabétique qui est dessus','packet caché', '22-12-2022 16:00', 'SEM_GENBERRIAT', 'koi','Vous etes a la fin!');
insert into defis(id, description, titre, date_de_creation, arret, auteur, epilogue)  
values ('2','trouvez les pièces caché dans le parc paul mistral et le tresor est à vous', 'chasse aux tresors', '22-12-2022 16:00','SEM_GENBIBLIUNI','moha','Defi termine!');
insert into defis(id, description, titre, date_de_creation, arret, auteur, epilogue) 
values ('3','un amateur doeuvres artistiques et scientifiques(Bobby Bryan) a besoin de certaines informations qui lui manquent pour compléter son enquête. Votre objectif est de trouver ces oeuvres sur le campus de l UGA pour repondre aux questions dont il a besoin','Oeuvres Artistiques','10-05-2022 14:30', 'SEM_GENBIBLIUNI', 'moha','Bravo Bobby Bryan vous remercie davoir participé à son défi et vous promet de nouvelles aventures prochainement');
insert into defis(id, description, titre, date_de_creation, arret, auteur, epilogue) 
values ('4','lhistoire reste un sujet fascinant et doit être conservé dans les mémoires.Votre objectif pour ce défi consiste à donner les noms de ces personnages historiques dont le nom figure sur des statues aux alentours de larrêt Victor Hugo','Histoire','10-05-2022 15:30', 'SEM_GENVICTHUGO', 'koi','Bravo nous esperons que vous chercherai à mieux connâitre ces personnage de lhistoire');
insert into defis(id, description, titre, date_de_creation, arret, auteur, epilogue) 
values ('5','Ce défi consiste à trouver le nombre de sheepest et la couleur des oiseaux des Bâtiments à partir de larrêt Gabriel fauret','Recherche', '22-12-2022 16:00', 'SEM_GENBERRIAT', 'koi','Vous etes a la fin!');

--Ajouter les Etapes
insert into etapes(id,instruction,defi) values('1','rendez vous à l arrêt Bibliothèque Universitaire et trouvez le packet caché derrière le monument qu on ne peut pas râter','1');
insert into etapes(id,instruction,defi) values('2','à l entrée du bâtiment IM2AG est caché le deuxième packet, trouvez le','1');
insert into etapes(id,instruction,defi) values('3','la première pièce est autour du terrain de voley derrière cet arbre si imposant qu on ne peut le râter','2');
insert into etapes(id, instruction,defi) values('4','la deuxième pièce est derrière ce banc juste à côté des fleur rose, trouvez la','2');
insert into etapes(id, instruction,defi) values('5','de là où vous avez trouvé la deuxième pièce la dernière est juste en face, trouvez la','2');
insert into etapes(id, instruction,defi) values('6','rendez vous à larrêt BU, à côté de larrêt de tram, en face de science po, se trouve une statue représentant le Dieu grec Hypnos, votre objectif consiste donc à trouver cette fresque et répondre à la question de Bryan.','3');
insert into etapes(id, instruction,defi) values('7','à present trouver lœuvre street art à côté de la tour irma. Cette oeuvre en bleu se trouve en face de larrêt bibliothèque universitaire.','3');
insert into etapes(id, instruction,defi) values('8',' à present vous devez vous dirirger vers la faculté de biologie, derrière les bâtiments de la  faculté se trouvent un parc où de façon artistique se trouve une structure de notre univers','3');
insert into etapes(id, instruction,defi) values('9','Maintenant soufflez un bon coup et ensuite rendez vous à la residence ouest, derrière le bâtiment E se trouve un magnifique portrait d’une femme, trouvez ce portrait','3');
insert into etapes(id, instruction,defi) values('10','rendez-vous à l’arrêt Victor Hugo, à votre descente trouver le fast-food Burger King juste en face, au milieu du parc se trouve une statue dun personnage, un chef dorchestre célèbre français du 19ème Siècle. Trouvez cette statue','4');
insert into etapes(id, instruction,defi) values('11',' quittez le parc, rendez-vous vers Fnac et traversez la place victor hugo, derrière le restau Pitaya se trouve à nouveau un petit parc, cette fois au milieu de ce parc se trouve une statue dun personnage de la mythologie grec, trouvez cette statue','4');
insert into etapes(id, instruction,defi) values('12',' à présent soufflez un bon coup et trouvez le café la table ronde. en face se trouve la statue  d’un vaillant soldat, connu à son époque pour sa bravoure, sa fidelité et son courage, trouvez sa statue','4');
insert into etapes(id, instruction,defi) values('13','rendez-vous à larrêt Gabriel Fauré et cherché le Bâtiment qui commence par la lettre M','5');
insert into etapes(id, instruction,defi) values('14','après avoir visualisé les oiseaux, cherchez le Bâtiment qui commence par la lettre I','5');

--Ajouter les Questions
insert into questions(id,question,reponse_correcte,point,etape) values('1','quel est la couleur du paquet ?', 'rouge', 1,'1');
insert into questions(id,question,reponse_correcte,point,etape) values('2','quel est la lettre inscrite au dos du paquet ?','Y',1,'2');
insert into questions(id,question,reponse_correcte,point,etape) values('3','si vous l avez trouvé quel est le mot inscrit sur le dos de cette lettre ?','pirate',1,'3');
insert into questions(id,question,reponse_correcte,point,etape) values('4',' donnez le mot inscrit sur cette nouvelle pièce','Des',1,'4');
insert into questions(id,question,reponse_correcte,point,etape) values('5','quel mot lisez vous sur cette dernière pièce ?','caraibes',1,'5');
insert into questions(id,question,reponse_correcte,point,etape) values('6','donnez le nom du sculpteur qui a fait cette œuvre.','Jose Seguiri',5,'6');
insert into questions(id,question,reponse_correcte,point,etape) values('7','quel est le nom de la rue où se trouve cette œuvre ?','Rue des Mathématiques',4,'7');
insert into questions(id,question,reponse_correcte,point,etape) values('8','quel est le nom scientifique quon donne habituellement à ce qui est representé dans ce parc ?','Le système solaire',4,'8');
insert into questions(id,question,reponse_correcte,point,etape) values('9','on peut jouer à un sport juste à côté de cette œuvre, lequel ?','Le Basketball',3,'9');
insert into questions(id,question,reponse_correcte,point,etape) values('10','quel est le personnage représenté par cette statue ?','Hector Berlioz',6,'10');
insert into questions(id,question,reponse_correcte,point,etape) values('11','Quel est le nom de cet être puissant de la mythologie ?','Hercule',5,'11');
insert into questions(id,question,reponse_correcte,point,etape) values('12','quel son nom ?','Bayard',5,'12');
insert into questions(id,question,reponse_correcte,point,etape) values('13','quel est la couleur des oiseaux dessiné devant ce batiment ?','rouge',5,'13');
insert into questions(id,question,reponse_correcte,point,etape) values('14','combien de sheepest dans ce batiment ?','6',5,'14');

--Ajouter les Indices
insert into indices(id,description, point_reduit,question) values('1', 'le paquet aura la même couleur que la mer lors de la traversé de Moïse',1,'1');
insert into indices(id,description, point_reduit,question) values('2', 'cette lettre est grec',2,'2');
insert into indices(id,description, point_reduit,question) values('3', 'le capitaine crochet exerce le même metier',2,'3');
insert into indices(id,description, point_reduit,question) values('4','c est une préposition qui commence par D',3,'4');
insert into indices(id,description, point_reduit,question) values('5','l ensemble des mots forment une saga populaire de l acteur Jonhy Deep',2,'5');
insert into indices(id,description, point_reduit,question) values('6','la signature de l’auteur se trouve juste au pied de la statue, et ses initiales sont JS',2,'6');
insert into indices(id,description, point_reduit,question) values('7','le nom de cette rue a un rapport avec une matière scientifique',2,'7');
insert into indices(id,description, point_reduit,question) values('8','toutes les planètes y sont représentées suivant leur position par rapport au soleil',3,'8');
insert into indices(id,description, point_reduit,question) values('9','Michael Jordan y était un champion',3,'9');
insert into indices(id,description, point_reduit,question) values('10','le nom du personnage est noté au pied de la statue, son nom a été donné à un arrêt de tram sur le campus',2,'10');
insert into indices(id,description, point_reduit,question) values('11','le nom du personnage est souvent utilisé pour designé une personnage ayant une force surhumaine',2,'11');
insert into indices(id,description, point_reduit,question) values('12','il s’agit d’un vaillant chevalier français du 16ème siècle, et une ecole porte son nom dans GRENOBLE',3,'12');
insert into indices(id,description, point_reduit,question) values('13','le batiment blanc lié à linnovation',3,'13');
insert into indices(id,description, point_reduit,question) values('14','dans ce batiment on fait des études de marketing',3,'14'); 

--Ajouter les Materiels
insert into materiels (id, description, lien, etape) values ('1', 'le Burger King', 'https://cdn-s-www.ledauphine.com/images/C0ACB78E-0C78-43E9-8589-6327B97B3893/NW_raw/photo-le-dl-1484084086.jpg','10');
insert into materiels (id, description, lien, etape) values ('2', 'un image de Pitaya', 'https://th.bing.com/th/id/R.73d964aacb94143dfae055ee52aca051?rik=UlTylRyhGfsIpA&pid=ImgRaw&r=0','11');
insert into materiels (id, description, lien, etape) values ('3', 'un image de ce cafe', 'https://c2.staticflickr.com/6/5246/5292974545_e6ec2060d2_b.jpg','12');

--Ajouter les Visites
insert into visites (id, commentaires, date_de_visite, score, statut, temps, chami, defi)
values (1, 'Les questions et les indices sont trop ambigues! C est quoi un package caché?!', '07-05-2022 16:00', '0', 'abandonne', '48.50', 'anais', '1');
insert into visites (id, commentaires, date_de_visite, score, statut, temps, chami, defi)
values (2, 'Trop facile!', '12-05-2022 09:00', '12', 'fini', '15.00', 'moha', '3');

----------------------
--Ajouter les Chamis
insert into chami (username, age, description,email) values ('koi', 23, 'C est Koi!', 'koi@gmail.com');
insert into chami (username, age, description,email) values ('moha', 33, 'C est Moha!','moha@gmail.com');
insert into chami (username, age, description,email) values ('anais', 37, 'C est Anais!', 'anais@gmail.com');
insert into chami (username, age, description,email) values ('min',  13, 'C est Min!', 'min@gmail.com');

--Ajouter les Arrets
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENBERRIAT', 'BERRIAT-LE MAGASIN', 'https://www.google.com/maps/@45.1887486,5.7064745,3a,33.5y,6.99h,90.28t/data=!3m6!1e1!3m4!1spKqyVVnkojg9VyheBCnBOA!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENBIBLIUNI', 'BIBLIOTHÈQUES UNIVERSITAIRES', 'https://www.google.com/maps/@45.1929768,5.7708905,3a,15y,174.85h,88.88t/data=!3m6!1e1!3m4!1s6nGYZZVjcop5qBpR0gpbtQ!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENCHAVANT', 'CHAVANT', 'https://www.google.com/maps/@45.185495,5.7311437,3a,75y,15.22h,86.39t/data=!3m6!1e1!3m4!1sFKcCCWmRM6FnmSQfcD_Jxg!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENCLINBELD', 'CLINIQUE BELLEDONNE', 'https://www.google.com/maps/@45.1859727,5.7603181,3a,15y,244.68h,84.37t/data=!3m6!1e1!3m4!1sQenHRK5ydHK0SwxRTwmcHA!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENCXPATRE', 'CROIX DU PÂTRE', 'https://www.google.com/maps/@45.1683689,5.7627437,3a,15.7y,181.36h,86.37t/data=!3m6!1e1!3m4!1sKtypwYoRCVKHt7FIy3-yIg!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENDUBEDOUT', 'HUBERT DUBEDOUT - MAISON DU TOURISME', 'https://www.google.fr/maps/@45.1901564,5.7284658,3a,75y,188.5h,83.99t/data=!3m6!1e1!3m4!1sZWGfsMXx2sjXNXmgQ6RcEg!2e0!7i13312!8i6656');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENGREHOTEL', 'GRENOBLE HÔTEL DE VILLE', 'https://www.google.fr/maps/@45.1875745,5.737518,3a,75y,335.06h,79.17t/data=!3m6!1e1!3m4!1snQioz7enAccxCiyLV0zBrg!2e0!7i16384!8i8192');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENVICTHUGO', 'VICTOR HUGO', 'https://www.google.com/maps/@45.1898119,5.7250558,3a,75y,327.55h,83.64t/data=!3m6!1e1!3m4!1sD3q07wHDE23LN4vLFEYPjQ!2e0!7i13312!8i6656');
insert into arret (codeTAG, arret, lien_street_map) values ('SEM_GENGABFAUR', 'GABRIEL FAURE', 'https://www.google.com/maps/place/Gabriel+Faur%C3%A9/@45.1922892,5.7643895,15z/data=!4m9!1m2!2m1!1sGabriel+Faur%C3%A9!3m5!1s0x478af5a819ee2c2b:0x752a39adf9629a65!8m2!3d45.1922596!4d5.7644324!15sCg5HYWJyaWVsIEZhdXLDqZIBCXRyYW1fc3RvcA%27');

--Ajouter les defi
insert into defi (id, description, titre, date_creation, auteur, epilogue)
values ('1','Pour réaliser ce défi vous devez trouver des packets caché sur le campus de grenoble, chaque paquet à soit une couleur ou une lettre alphabétique qui est dessus','packet caché', '22-12-2022 16:00', 'koi','Vous etes a la fin!');
insert into defi (id, description, titre, date_creation, auteur, epilogue)
values ('2','trouvez les pièces caché dans le parc paul mistral et le tresor est à vous', 'chasse aux tresors', '22-12-2022 16:00', 'moha','Defi termine!');
insert into defi (id, description, titre, date_creation, auteur, epilogue)
values ('3','un amateur doeuvres artistiques et scientifiques(Bobby Bryan) a besoin de certaines informations qui lui manquent pour compléter son enquête. Votre objectif est de trouver ces oeuvres sur le campus de l UGA pour repondre aux question  dont il a besoin','Oeuvres Artistiques','10-05-2022 14:30', 'moha','Bravo Bobby Bryan vous remercie davoir participé à son défi et vous promet de nouvelles aventures prochainement');
insert into defi (id, description, titre, date_creation, auteur, epilogue)
values ('4','lhistoire reste un sujet fascinant et doit être conservé dans les mémoires.Votre objectif pour ce défi consiste à donner les noms de ces personnages historiques dont le nom figure sur des statues aux alentours de larrêt Victor Hugo','Histoire','10-05-2022 15:30', 'koi','Bravo nous esperons que vous chercherai à mieux connâitre ces personnage de lhistoire');
insert into defi (id, description, titre, date_creation, auteur, epilogue)
values ('5','Ce défi consiste à trouver le nombre de sheepest et la couleur des oiseaux des Bâtiments à partir de larrêt Gabriel fauret','Recherche', '22-12-2022 16:00', 'koi','Vous etes a la fin!');

--Ajouter les Etapes
insert into etape (id, instruction, arret_codeTAG) values ('1','rendez vous à l arrêt Bibliothèque Universitaire et trouvez le packet caché derrière le monument qu on ne peut pas râter','SEM_GENBERRIAT');
insert into etape (id, instruction, arret_codeTAG) values ('2','à l entrée du bâtiment IM2AG est caché le deuxième packet, trouvez le','SEM_GENBERRIAT');
insert into etape (id, instruction, arret_codeTAG) values ('3','la première pièce est autour du terrain de voley derrière cet arbre si imposant qu on ne peut le râter','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('4','la deuxième pièce est derrière ce banc juste à côté des fleur rose, trouvez la','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('5','de là où vous avez trouvé la deuxième pièce la dernière est juste en face, trouvez la','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('6','rendez vous à larrêt BU, à côté de larrêt de tram, en face de science po, se trouve une statue représentant le Dieu grec Hypnos, votre objectif consiste donc à trouver cette fresque et répondre à la question de Bryan.','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('7','à present trouver lœuvre street art à côté de la tour irma. Cette oeuvre en bleu se trouve en face de larrêt bibliothèque universitaire.','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('8',' à present vous devez vous dirirger vers la faculté de biologie, derrière les bâtiments de la  faculté se trouvent un parc où de façon artistique se trouve une structure de notre univers','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('9','Maintenant soufflez un bon coup et ensuite rendez vous à la residence ouest, derrière le bâtiment E se trouve un magnifique portrait d’une femme, trouvez ce portrait','SEM_GENBIBLIUNI');
insert into etape (id, instruction, arret_codeTAG) values ('10','rendez-vous à l’arrêt Victor Hugo, à votre descente trouver le fast-food Burger King juste en face, au milieu du parc se trouve une statue dun personnage, un chef dorchestre célèbre français du 19ème Siècle. Trouvez cette statue','SEM_GENVICTHUGO');
insert into etape (id, instruction, arret_codeTAG) values ('11',' quittez le parc, rendez-vous vers Fnac et traversez la place victor hugo, derrière le restau Pitaya se trouve à nouveau un petit parc, cette fois au milieu de ce parc se trouve une statue dun personnage de la mythologie grec, trouvez cette statue','SEM_GENVICTHUGO');
insert into etape (id, instruction, arret_codeTAG) values ('12',' à présent soufflez un bon coup et trouvez le café la table ronde. en face se trouve la statue  d’un vaillant soldat, connu à son époque pour sa bravoure, sa fidelité et son courage, trouvez sa statue','SEM_GENVICTHUGO');
insert into etape (id, instruction, arret_codeTAG) values ('13','rendez-vous à larrêt Gabriel Fauré et cherché le Bâtiment qui commence par la lettre M','SEM_GENBERRIAT');
insert into etape (id, instruction, arret_codeTAG) values ('14','après avoir visualisé les oiseaux, cherchez le Bâtiment qui commence par la lettre I','SEM_GENBERRIAT');

--Associer les Etapes avec leur Defis correspondants
insert into defi_etapes (defi_id, etapes_id) values (1, 1);
insert into defi_etapes (defi_id, etapes_id) values (1, 2);
insert into defi_etapes (defi_id, etapes_id) values (2, 3);
insert into defi_etapes (defi_id, etapes_id) values (2, 4);
insert into defi_etapes (defi_id, etapes_id) values (2, 5);
insert into defi_etapes (defi_id, etapes_id) values (3, 6);
insert into defi_etapes (defi_id, etapes_id) values (3, 7);
insert into defi_etapes (defi_id, etapes_id) values (3, 8);
insert into defi_etapes (defi_id, etapes_id) values (3, 9);
insert into defi_etapes (defi_id, etapes_id) values (4, 10);
insert into defi_etapes (defi_id, etapes_id) values (4, 11);
insert into defi_etapes (defi_id, etapes_id) values (4, 12);
insert into defi_etapes (defi_id, etapes_id) values (5, 13);
insert into defi_etapes (defi_id, etapes_id) values (5, 14);

--Ajouter les questions
insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('1', 'quel est la couleur du paquet ?', 'rouge', 1, 'regardez derriere le 1er banc', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('2', 'quel est la lettre inscrite au dos du paquet ?', 'Y', 1 ,'c est a cote d une machine!', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('3',' donnez le mot inscrit sur cette nouvelle pièce','Des', 1, '...', 0);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('4','quel mot lisez vous sur cette dernière pièce ?', 'caraibes', 1, '...', 0);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('5','donnez le nom du sculpteur qui a fait cette œuvre.', 'Jose Seguiri', 5 ,'C est indique en bas de la statue', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('6','quel est le nom de la rue où se trouve cette œuvre ?','Rue des Mathématiques', 4, 'Regardez la signe au debut du chemin', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('7','on peut jouer à un sport juste à côté de cette œuvre, lequel ?','Le Basketball',3,'Suivez les Graffitis', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('8','quel est le personnage représenté par cette statue ?', 'Hector Berlioz', 6, '...', 0);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('9', 'Quel est le nom de cet être puissant de la mythologie ?', 'Hercule', 5, 'La plus forte personne de la Grece!', 1);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('10', 'quel est la couleur des oiseaux dessiné devant ce batiment ?', 'rouge', 5, '5 oiseaux en total!', 0);

insert into question (id, question, reponse_correcte, point, indice, cout_indice)
values('11', 'combien de sheepest dans ce batiment ?', '6' , 5, 'Ne ratez pas les sheepest en bas!', 0);









