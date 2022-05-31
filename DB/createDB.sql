drop
database if exists CookStock;
create
database CookStock;

use CookStock;

create table utente(
	id int auto_increment primary key,
    nome varchar(30),
    cognome varchar(30),
    email varchar(30),
    passwordUtente varchar(30)
);

create table ordine
(
	codice int auto_increment primary key,
    tipologia varchar(2) check(tipologia = 'A' OR 
							   tipologia = 'D' OR 
                               tipologia = 'CP') not null,
    sconto double,
    totale double(4,2),
    dataPagamento date,
    tipoPagamento varchar(20) check(tipoPagamento = 'Contanti' OR 
									tipoPagamento = 'Carta di credito' OR 
                                    tipoPagamento = 'PayPal') not null,
	idUtente int,
    foreign key(idUtente) references utente(id)
);

create table prodotto
(
	codice int auto_increment primary key,
    nome varchar(30),
    prezzo double(4,2),
    descrizione varchar(200),
    tipologia varchar(30) check(tipologia = 'Panino' OR 
								tipologia = 'Pizza' OR 
                                tipologia = 'Bibita' OR 
                                tipologia = 'Fritto' OR 
                                tipologia = 'Dolce') not null,
	immagine mediumblob
);

create table appartenere
(
	codiceProdotto int,
    codiceOrdine int,
    quantità int,
    
    primary key(codiceProdotto, codiceOrdine),
    foreign key(codiceProdotto) references prodotto(codice),
    foreign key(codiceOrdine) references ordine(codice)
);

create table listaDesideri
(
	nome varchar(30),
    idUtente int auto_increment,
    primary key(nome, idUtente),
    foreign key(idUtente) references utente(id)
);

create table seleziona
(
	codiceProdotto int,
    nomeLista varchar(30),
    idUtente int,
    primary key(codiceProdotto, nomeLista, idUtente),
    foreign key(codiceProdotto) references prodotto(codice),
    foreign key(nomeLista, idUtente) references listaDesideri(nome, idUtente)
);

create table carrello(
	codice int auto_increment primary key,
    sconto double,
    totale double(4,2),
    numeroProdotti int,
    idUtente int,
    
    foreign key(idUtente) references utente(id)
);

create table contenere(
	codiceCarrello int,
    codiceProdotto int,
    quantità int,
    primary key(codiceCarrello, codiceProdotto),
	foreign key(codiceCarrello) references carrello(codice),
    foreign key(codiceProdotto) references prodotto(codice)

);
