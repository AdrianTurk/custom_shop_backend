/* Payment Methods: */
INSERT INTO `custom_shop`.`payment_methods` (`id_method`, `method_name`, `description`,`deleted`)
VALUES
    (1, 'Bitcoin', 'Pago mediante pasarela externa',false),
    (2, 'MercadoPago', 'Pago mediante pasarela externa MercadoPago',false),
    (3, 'Targeta de credito', 'Pago mediante pasarela externa',false),
    (4, 'Transferencia', 'Pago mediante pasarela externa',false);

/*Vendedores*/
INSERT INTO `custom_shop`.`sellers` (`id_seller`, `email`, `name`, `password`,`deleted`) 
VALUES
    (1, 'email1@seller1.com', 'Vendedor de prueba Nº 1', '1234', false),
    (2, 'email2@seller2.com', 'Vendedor de prueba Nº 2', '1234', false),
    (3, 'email3@seller3.com', 'Vendedor de prueba Nº 3', '1234', false);

/*for seller 1*/
INSERT INTO `custom_shop`.`sellers_payment_methods`(`sellers_id_seller`,`payment_methods_id_method`)
    VALUES (1,1),(1,2),(1,3),(1,4);

/*for seller 2*/
INSERT INTO `custom_shop`.`sellers_payment_methods`(`sellers_id_seller`,`payment_methods_id_method`)
    VALUES  (2,1),(2,3);

/*for seller 3*/
INSERT INTO `custom_shop`.`sellers_payment_methods`(`sellers_id_seller`,`payment_methods_id_method`)
    VALUES(3,4);

/*Base_Products:*/
INSERT INTO `custom_shop`.`base_products`(`id_product`,`base_price`,`delay_time_hours`,`name`,`description`,`deleted`)
VALUES
    (1,500,24,'Taza Modelo 1','Taza de ceramica 220ml',false),
    (2,400,24,'Taza Modelo 2','Taza de vidrio 200ml',false),
    (3,500,24,'Mate de Madera','Mate madera chico 120ml',false),
    (4,500,24,'Mate modelo 2','Mate de madera forrado en cuero 180ml',false),
    (5,500,24,'Gorra 1','Gorra con visera comun',false),
    (6,500,24,'Remera Corta 1','Remera manga corta cuello U',false),
    (7,500,24,'Remera Larga 1','Remera manga larga cuello U',false);


/*Tazas y vasos*/
INSERT INTO `custom_shop`.`customizations`(`id_customization`,`name`,`description`,`deleted`)
VALUES
    (1,'Logo frente chico','Impresion de logo personalizado de 50mm x 50mm vitrograbado',false),
    (2,'Logo frente medio','Impresion de logo personalizado de 100mm x 70mm vitrograbado',false),
    (3,'Logo frente full','Impresion de logo personalizado de superficie completa vitrograbado',false);

/* Varios */
INSERT INTO `custom_shop`.`customizations`(`id_customization`,`name`,`description`,`deleted`)
VALUES
    (4,'Color Azul','Material en fondo azul',false),
    (5,'Color Negro','Material en fondo negro',false),
    (6,'Color A Pedido','Material en fondo a pedido',false);

/*gorras*/
INSERT INTO `custom_shop`.`customizations`(`id_customization`,`name`,`description`,`deleted`)
VALUES
    (7,'Color','Color de material base posibles[azul,rojo,verde,gris,blanco]',false),
    (8,'Logo','Logo en frente 3 colores',false),
    (9,'Logo','Logo en frente fullcolor',false);

/*Remeras*/
INSERT INTO `custom_shop`.`customizations`(`id_customization`,`name`,`description`,`deleted`)
VALUES
    (10,'Impresion frente chico','impresion en frente 15x20cm maximo 1 color',false),
    (11,'Impresion fondo chico','impresion en fondo 15x20cm maximo 1 color',false),
    (12,'Impresion frente fullsize','impresion en frente completo 1 color',false),
    (13,'Impresion fondo fullsize','impresion en fondo completo 1 color',false),
    (14,'Impresion frente chico fullcolor','impresion en frente 15x20cm maximo full color',false),
    (15,'Impresion fondo chico fullcolor','impresion en fondo 15x20cm maximo full color',false),
    (16,'Impresion frente fullsize fullcolor','impresion en frente completo full color',false),
    (17,'Impresion texto frente','impresion de texto en frente',false),
    (18,'Impresion texto reverso','impresion al reverso',false),
    (19,'Reservado','Reservado',true);

/*Mates*/

INSERT INTO `custom_shop`.`customizations`(`id_customization`,`name`,`description`,`deleted`)
VALUES
    (20,'grabado de logo cuero','Grabado de logo sobre cuero',false),
    (21,'grabado de logo madera','Grabado de logo sobre madera',false),
    (22,'bombilla grabada opcional','Grabado de logo en bombilla',false);

/* Posible Customizations */
/* posibles tazas*/
INSERT INTO `custom_shop`.`posible_customizations`
	(`id`,`added_cost`,`hours_delay`,`base_product_id_product`,`customization_id_customization`)
VALUES
	(1,100,24,1,1),
    (2,110,30,1,2),
    (3,200,12,1,3),
    (4,125,6,1,4),
    (5,105,20,1,5),
	(6,120,30,1,6),
	(7,50,48,2,1),
    (8,100,20,2,2),
    (9,150,8,2,3),
    (10,175,10,2,4),
    (11,200,24,2,5),
    (12,130,48,2,6);

/* posibles mates*/
INSERT INTO `custom_shop`.`posible_customizations`
	(`id`,`added_cost`,`hours_delay`,`base_product_id_product`,`customization_id_customization`)
VALUES
	(13,200,24,3,21),
    (14,300,24,3,22),
    (15,250,48,4,20),
    (16,300,48,4,22);

/* posibles gorras*/
INSERT INTO `custom_shop`.`posible_customizations`
	(`id`,`added_cost`,`hours_delay`,`base_product_id_product`,`customization_id_customization`)
VALUES
	(17,0,24,5,7),
    (18,200,48,5,8),
    (19,500,48,5,9);

/* posibles remeras*/
INSERT INTO `custom_shop`.`posible_customizations`
	(`id`,`added_cost`,`hours_delay`,`base_product_id_product`,`customization_id_customization`)
VALUES
    (20,100,24,6,4),
    (21,100,24,6,5),
    (22,100,24,6,6),
	(23,100,24,6,9),
    (24,100,24,6,10),
    (25,100,24,6,11),
    (26,100,24,6,12),
    (27,100,24,6,13),
    (28,100,24,6,14),
    (29,100,24,6,15),
    (30,100,24,6,16),
    (31,100,24,6,17),
    (32,100,24,6,18),
    (33,100,24,6,19),
    (34,100,24,6,4),
    (35,100,24,6,5),
    (36,100,24,6,6),
	(40,100,24,7,9),
    (41,100,24,7,10),
    (42,100,24,7,11),
    (43,100,24,7,12),
    (44,100,24,7,13),
    (45,100,24,7,14),
    (46,100,24,7,15),
    (47,100,24,7,16),
    (48,100,24,6,17),
    (49,100,24,6,18),
    (50,100,24,6,19);

/*Custom Products*/

INSERT INTO `custom_shop`.`custom_products`(`id_custom_product`,`deleted`,`name`,`seller_id_seller`,`base_product_id_product`)
VALUES
	(1,false,"Remera Blanca con emoji 😋",1,6),
    (2,false,"Remera Blanca con emoji 🤪",1,6);

INSERT INTO `custom_shop`.`customizations_applied`(`id_customization_apply`,`deleted`,`value`,`base_product_id_product`,`custom_product_id_product`,`customization_id_customization`)
VALUES
    (1,false,'https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/zany-face_1f92a.png',6,1,14),
    (2,false,'https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/face-savoring-food_1f60b.png',6,2,14);

/*Remeras frase*/
INSERT INTO `custom_shop`.`custom_products`(`id_custom_product`,`deleted`,`name`,`seller_id_seller`,`base_product_id_product`)
VALUES
	(3,false,"Remera Blanca con inscripcion frase Messi",2,6),
    (4,false,"Remera Blanca con frase: It's True",2,6);

INSERT INTO `custom_shop`.`customizations_applied`(`id_customization_apply`,`deleted`,`value`,`base_product_id_product`,`custom_product_id_product`,`customization_id_customization`)
VALUES
    (3,false,'Que miras, bobo? /Notas: Arial 20pts Negro',6,3,17),
    (4,false,"<h1> !FALSE </h1> <br> <h4> IT'S FUNNY BECAUSE </h4> <br> <h2> IT'S TRUE </h2> /Notas: Arial 26pts",6,4,17),
    (5,false,"Amarillo Brillante",6,4,6);


/*
 https://ae01.alicdn.com/kf/Hce7bf9a477224ea48c3d781ed1b98af2O/Camisetas-estampadas-con-cita-de-programador-para-hombre-playera-con-frase-False-It-s-Funny-Because.jpg_640x640.jpg
*/