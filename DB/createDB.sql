/*drop
database if exists CookStock;
create
database CookStock;*/

use CookStock;

create table utente(
	id int auto_increment primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    email varchar(50) not null,
    passwordUtente varchar(128) not null,
    isAdmin boolean default false,
    unique(email)
);

create table ordine
(
	codice int auto_increment primary key,
    tipologia varchar(2) check(tipologia = 'A' OR 
							   tipologia = 'D' OR 
                               tipologia = 'CP') not null,
    totale double(4,2) not null,
    dataPagamento date not null,
    tipoPagamento varchar(20) check(tipoPagamento = 'Contanti' OR 
									tipoPagamento = 'Carta di credito' OR 
                                    tipoPagamento = 'PayPal') not null,
	numeroCarta varchar(16),
    via varchar(50),
    cap varchar(5),
    citta varchar(20),
	idUtente int,
    foreign key(idUtente) references utente(id)
);
/*
create table prodotto
(
	codice int auto_increment primary key,
    nome varchar(30) not null,
    prezzo double(4,2) not null,
    descrizione varchar(200),
    tipologia varchar(30) check(tipologia = 'Panino' OR 
								tipologia = 'Pizza' OR 
                                tipologia = 'Bibita' OR 
                                tipologia = 'Fritto' OR 
                                tipologia = 'Dolce') not null,
	immagine mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

create table appartenere
(
	codiceProdotto int,
    codiceOrdine int,
    quantità int not null,
    
    primary key(codiceProdotto, codiceOrdine),
    foreign key(codiceProdotto) references prodotto(codice),
    foreign key(codiceOrdine) references ordine(codice)
);

create table listaDesideri
(
    idUtente int auto_increment,
    primary key(idUtente),
    foreign key(idUtente) references utente(id)
);

create table seleziona
(
	codiceProdotto int,
    idUtente int,
    primary key(codiceProdotto, idUtente),
    foreign key(codiceProdotto) references prodotto(codice),
    foreign key(idUtente) references listaDesideri(idUtente)
);

create table carrello(
	codice int auto_increment primary key,
    totale double(4,2) not null,
    numeroProdotti int not null,
    idUtente int,
    
    foreign key(idUtente) references utente(id)
);

create table contenere(
	codiceCarrello int,
    codiceProdotto int,
    quantità int not null,
    primary key(codiceCarrello, codiceProdotto),
	foreign key(codiceCarrello) references carrello(codice),
    foreign key(codiceProdotto) references prodotto(codice)

);