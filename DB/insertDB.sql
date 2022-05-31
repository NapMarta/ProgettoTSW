use cookstock;

insert into utente(nome, cognome, email) values 
("Mario", "Rossi", "mario01@gmail.com"),
("Marco", "Bianchi", "marco22@libero.it"),
("Luigi", "Ferreri","luigi34@gmail.com"),
("Maria", "Costante", "m.costante@gmail.com"),
("Alice", "Lo Conte","alice01.loconte@gmail.com");

insert into ordine(tipologia, sconto, totale,dataPagamento, tipoPagamento, idUtente) values
("A", 1.5, 45.70, "2021-10-10", "Contanti", 5),
("CP", 5, 15.70, "2022-01-15", "Contanti", 5),
("D", null , 25.00, "2021-05-10", "Carta di credito", 3),
("A", 5.3, 33.70, "2021-06-20", "PayPal", 2),
("A", 10, 51.20, "2020-11-05", "Contanti", 1);

insert into prodotto(nome, prezzo, descrizione, tipologia) values 
("Messicano", 10.00, "(HAMBURGER GOURMET DI VITELLO 180g, POMODORO, LATTUGA, FONDUTA DI CHEDDAR, CIPOLLE IN AGRODOLCE E SALSA GUACAMOLE)", "Panino"),
("Denver", 10.00, "(HAMBURGER GOURMET DI VITELLO 180g, BACON, FONDUTA DI CHEDDAR E PATATINE)", "Panino"),
("Margherita", 4.00, "(POMODORO, MOZZARELLA E BASILICO)", "Pizza"),
("Salsiccia e olive", 7.00, "(SALSICCIA, OLIVE NERE E MOZZARELLA)", "Pizza"),
("Ichnusa", 3.00, "(Birra bionda)", "Bibita");

insert into appartenere values 
(1,4,2),
(1,5,3),
(1,2,1),
(3,1,2);

insert into listaDesideri values 
("pizzePreferite", 4),
("daProvare", 2),
("Panini", 1);

insert into seleziona values
(2, "daProvare", 2),
(3, "daProvare", 2),
(1, "pizzePreferite", 4),
(2, "Panini", 1);

insert into carrello(sconto,totale,numeroProdotti,idUtente) values
(2.5, 15.50, 2, 5),
(5, 37.50, 4, 1),
(2.5, 10.00, 1, 3);

insert into contenere values
(1, 3, 2),
(1, 5, 2),
(3, 1, 1);


