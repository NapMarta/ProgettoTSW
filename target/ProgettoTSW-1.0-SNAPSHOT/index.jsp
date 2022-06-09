
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link href="css/homepage.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="javaScript/homepage.js"></script>
</head>
<body>
    <table>
        <tr>
            <td>
                <img src="logo.jpeg" height="60" width="60">
            </td>
            <td>
                <h2 id="nomePub">CookStock</h2>
            </td>
            <td>
                <img src="https://img.icons8.com/color/40/000000/instagram-new--v1.png" class="social"/>
                <img src="https://img.icons8.com/color/40/000000/facebook-new.png" class="social"/>
            </td>
        </tr>
    </table>
    <div class="navbar" id="up">
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/pizza.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/hamburger.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/chips.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/beer.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/60/C29436/ice-cream-in-waffle-cone.png"/></a>
    </div>

    <p class="content">
        GLI SCOPI DELLE RETI accesso alle informazioni, condivisione di risorse eterogenee, facilitazione della comunicazione.

        FUNZIONALITÀ DI UNA RETE  Affidabile (dobbiamo supporre che i dati poterbbero essere danneggiati, corrotti, perse, duplicati o ordine differente), Efficiente, Scalabile (con l’aumentare del numero degli utenti dovremmo aggiungere un piccolo Δx, rispettando la scelta economica e tecnologica), In grado di connettere ambienti applicativi diversi (eterogeneità dei dispositivi connessi), Instradamento (deve riuscire ad individuare i cammini ottimali da una specifica sorgente ad una specifica destinazione ovunque essi si trovano, indirizzare i nodi).

        Componenti di una rete: Hardware (apparati di interconnessione per il controllo della trasmissione) e Software (protocolli, drivers).

        Circuito fisico è punto-a-punto quando collega due soli nodi solo problemi di comunicazione
        fisica come: elettrici, ottici, onde elettromagnetiche.
        Circuito multipunto connette più nodi sullo stesso canale fisico  nuovi problemi come:
        Indirizzamento (quale nodo inviare un’informazione e a chi spedire la risposta), Commutazione (relay intermedi, favorire il passaggio di informazioni tra un nodo e l’altro), Instradamento e Alta Affidabilità (più strade di comunicazione così che se una cade la comunicazione può avvenire comunque). Possono nascere problemi di contesa (conflitto = collisione).

        Un possibile modello fisico che implementa la definizione data di rete di telecomunicazione deve prevedere la presenza di hosts (stazioni, dispositivi autonomi connessi a una rete, o anche Terminali, cioè punti di terminazione di una comunicazione), links (collegamenti trasmissivi, interconnessi fra loro tramite nodi di commutazione, es. punto a punto) e nodi di commutazione (Network switch = commutatore in italiano), il cui compito è quello di riconoscere le richieste per l’apertura di una connessione e fare in modo che i dati, relativi a tale connessione, arrivino al nodo di destinazione. Lo scopo è realizzare l’infrastruttura di rete stessa con una logica multi hop relay, cioè devono ricevere l’informazione su un’interfaccia e passarli avanti su un’altra interfaccia, ad ogni interfaccia è collegato un link di comunicazione diverso e quindi questi nodi smistano le informazioni da un link (e quindi può essere uno switch intermedio o di terminazione) verso un altro facendo viaggiare le informazioni. L'accordo fra tutti i commutatori permette l’individuazione di un percorso da un'origine ad una destinazione, questo permette la funzionalità di instradamento.

        MODELLI DI RETI
        1.	CLIENT-SERVER
        Sono coinvolti due processi (programmi in esecuzione), uno sulla macchina client e uno sulla macchina server. La comunicazione è rappresentata da un processo client che manda un messaggio attraverso la rete al processo server e resta in attesa di un messaggio di risposta. Quando il processo server riceve la richiesta, esegue il lavoro o recupera i dati desiderati e restituisce una risposta.
        2.	PEER-TO-PEER
        Gli individui che costituiscono un gruppo spontaneo sono in grado di comunicare tra di loro. In linea di principio, ognuno può comunicare con chiunque all’interno del gruppo senza che vi sia una divisione predefinita tra server e client. Ogni utente mantiene il proprio database in locale e fornisce un elenco di altri utenti a lui noti che fanno parte del sistema, e può visitare qualunque altro membro sia per vedere che cosa abbia sia per ottenere i nominativi di altri membri da ispezionare a loro volta.
        GLI SCOPI DELLE RETI accesso alle informazioni, condivisione di risorse eterogenee, facilitazione della comunicazione.

        FUNZIONALITÀ DI UNA RETE  Affidabile (dobbiamo supporre che i dati poterbbero essere danneggiati, corrotti, perse, duplicati o ordine differente), Efficiente, Scalabile (con l’aumentare del numero degli utenti dovremmo aggiungere un piccolo Δx, rispettando la scelta economica e tecnologica), In grado di connettere ambienti applicativi diversi (eterogeneità dei dispositivi connessi), Instradamento (deve riuscire ad individuare i cammini ottimali da una specifica sorgente ad una specifica destinazione ovunque essi si trovano, indirizzare i nodi).

        Componenti di una rete: Hardware (apparati di interconnessione per il controllo della trasmissione) e Software (protocolli, drivers).

        Circuito fisico è punto-a-punto quando collega due soli nodi solo problemi di comunicazione
        fisica come: elettrici, ottici, onde elettromagnetiche.
        Circuito multipunto connette più nodi sullo stesso canale fisico  nuovi problemi come:
        Indirizzamento (quale nodo inviare un’informazione e a chi spedire la risposta), Commutazione (relay intermedi, favorire il passaggio di informazioni tra un nodo e l’altro), Instradamento e Alta Affidabilità (più strade di comunicazione così che se una cade la comunicazione può avvenire comunque). Possono nascere problemi di contesa (conflitto = collisione).

        Un possibile modello fisico che implementa la definizione data di rete di telecomunicazione deve prevedere la presenza di hosts (stazioni, dispositivi autonomi connessi a una rete, o anche Terminali, cioè punti di terminazione di una comunicazione), links (collegamenti trasmissivi, interconnessi fra loro tramite nodi di commutazione, es. punto a punto) e nodi di commutazione (Network switch = commutatore in italiano), il cui compito è quello di riconoscere le richieste per l’apertura di una connessione e fare in modo che i dati, relativi a tale connessione, arrivino al nodo di destinazione. Lo scopo è realizzare l’infrastruttura di rete stessa con una logica multi hop relay, cioè devono ricevere l’informazione su un’interfaccia e passarli avanti su un’altra interfaccia, ad ogni interfaccia è collegato un link di comunicazione diverso e quindi questi nodi smistano le informazioni da un link (e quindi può essere uno switch intermedio o di terminazione) verso un altro facendo viaggiare le informazioni. L'accordo fra tutti i commutatori permette l’individuazione di un percorso da un'origine ad una destinazione, questo permette la funzionalità di instradamento.

        MODELLI DI RETI
        1.	CLIENT-SERVER
        Sono coinvolti due processi (programmi in esecuzione), uno sulla macchina client e uno sulla macchina server. La comunicazione è rappresentata da un processo client che manda un messaggio attraverso la rete al processo server e resta in attesa di un messaggio di risposta. Quando il processo server riceve la richiesta, esegue il lavoro o recupera i dati desiderati e restituisce una risposta.
        2.	PEER-TO-PEER
        Gli individui che costituiscono un gruppo spontaneo sono in grado di comunicare tra di loro. In linea di principio, ognuno può comunicare con chiunque all’interno del gruppo senza che vi sia una divisione predefinita tra server e client. Ogni utente mantiene il proprio database in locale e fornisce un elenco di altri utenti a lui noti che fanno parte del sistema, e può visitare qualunque altro membro sia per vedere che cosa abbia sia per ottenere i nominativi di altri membri da ispezionare a loro volta.

        GLI SCOPI DELLE RETI accesso alle informazioni, condivisione di risorse eterogenee, facilitazione della comunicazione.

        FUNZIONALITÀ DI UNA RETE  Affidabile (dobbiamo supporre che i dati poterbbero essere danneggiati, corrotti, perse, duplicati o ordine differente), Efficiente, Scalabile (con l’aumentare del numero degli utenti dovremmo aggiungere un piccolo Δx, rispettando la scelta economica e tecnologica), In grado di connettere ambienti applicativi diversi (eterogeneità dei dispositivi connessi), Instradamento (deve riuscire ad individuare i cammini ottimali da una specifica sorgente ad una specifica destinazione ovunque essi si trovano, indirizzare i nodi).

        Componenti di una rete: Hardware (apparati di interconnessione per il controllo della trasmissione) e Software (protocolli, drivers).

        Circuito fisico è punto-a-punto quando collega due soli nodi solo problemi di comunicazione
        fisica come: elettrici, ottici, onde elettromagnetiche.
        Circuito multipunto connette più nodi sullo stesso canale fisico  nuovi problemi come:
        Indirizzamento (quale nodo inviare un’informazione e a chi spedire la risposta), Commutazione (relay intermedi, favorire il passaggio di informazioni tra un nodo e l’altro), Instradamento e Alta Affidabilità (più strade di comunicazione così che se una cade la comunicazione può avvenire comunque). Possono nascere problemi di contesa (conflitto = collisione).

        Un possibile modello fisico che implementa la definizione data di rete di telecomunicazione deve prevedere la presenza di hosts (stazioni, dispositivi autonomi connessi a una rete, o anche Terminali, cioè punti di terminazione di una comunicazione), links (collegamenti trasmissivi, interconnessi fra loro tramite nodi di commutazione, es. punto a punto) e nodi di commutazione (Network switch = commutatore in italiano), il cui compito è quello di riconoscere le richieste per l’apertura di una connessione e fare in modo che i dati, relativi a tale connessione, arrivino al nodo di destinazione. Lo scopo è realizzare l’infrastruttura di rete stessa con una logica multi hop relay, cioè devono ricevere l’informazione su un’interfaccia e passarli avanti su un’altra interfaccia, ad ogni interfaccia è collegato un link di comunicazione diverso e quindi questi nodi smistano le informazioni da un link (e quindi può essere uno switch intermedio o di terminazione) verso un altro facendo viaggiare le informazioni. L'accordo fra tutti i commutatori permette l’individuazione di un percorso da un'origine ad una destinazione, questo permette la funzionalità di instradamento.

        MODELLI DI RETI
        1.	CLIENT-SERVER
        Sono coinvolti due processi (programmi in esecuzione), uno sulla macchina client e uno sulla macchina server. La comunicazione è rappresentata da un processo client che manda un messaggio attraverso la rete al processo server e resta in attesa di un messaggio di risposta. Quando il processo server riceve la richiesta, esegue il lavoro o recupera i dati desiderati e restituisce una risposta.
        2.	PEER-TO-PEER
        Gli individui che costituiscono un gruppo spontaneo sono in grado di comunicare tra di loro. In linea di principio, ognuno può comunicare con chiunque all’interno del gruppo senza che vi sia una divisione predefinita tra server e client. Ogni utente mantiene il proprio database in locale e fornisce un elenco di altri utenti a lui noti che fanno parte del sistema, e può visitare qualunque altro membro sia per vedere che cosa abbia sia per ottenere i nominativi di altri membri da ispezionare a loro volta.


        GLI SCOPI DELLE RETI accesso alle informazioni, condivisione di risorse eterogenee, facilitazione della comunicazione.

        FUNZIONALITÀ DI UNA RETE  Affidabile (dobbiamo supporre che i dati poterbbero essere danneggiati, corrotti, perse, duplicati o ordine differente), Efficiente, Scalabile (con l’aumentare del numero degli utenti dovremmo aggiungere un piccolo Δx, rispettando la scelta economica e tecnologica), In grado di connettere ambienti applicativi diversi (eterogeneità dei dispositivi connessi), Instradamento (deve riuscire ad individuare i cammini ottimali da una specifica sorgente ad una specifica destinazione ovunque essi si trovano, indirizzare i nodi).

        Componenti di una rete: Hardware (apparati di interconnessione per il controllo della trasmissione) e Software (protocolli, drivers).

        Circuito fisico è punto-a-punto quando collega due soli nodi solo problemi di comunicazione
        fisica come: elettrici, ottici, onde elettromagnetiche.
        Circuito multipunto connette più nodi sullo stesso canale fisico  nuovi problemi come:
        Indirizzamento (quale nodo inviare un’informazione e a chi spedire la risposta), Commutazione (relay intermedi, favorire il passaggio di informazioni tra un nodo e l’altro), Instradamento e Alta Affidabilità (più strade di comunicazione così che se una cade la comunicazione può avvenire comunque). Possono nascere problemi di contesa (conflitto = collisione).

        Un possibile modello fisico che implementa la definizione data di rete di telecomunicazione deve prevedere la presenza di hosts (stazioni, dispositivi autonomi connessi a una rete, o anche Terminali, cioè punti di terminazione di una comunicazione), links (collegamenti trasmissivi, interconnessi fra loro tramite nodi di commutazione, es. punto a punto) e nodi di commutazione (Network switch = commutatore in italiano), il cui compito è quello di riconoscere le richieste per l’apertura di una connessione e fare in modo che i dati, relativi a tale connessione, arrivino al nodo di destinazione. Lo scopo è realizzare l’infrastruttura di rete stessa con una logica multi hop relay, cioè devono ricevere l’informazione su un’interfaccia e passarli avanti su un’altra interfaccia, ad ogni interfaccia è collegato un link di comunicazione diverso e quindi questi nodi smistano le informazioni da un link (e quindi può essere uno switch intermedio o di terminazione) verso un altro facendo viaggiare le informazioni. L'accordo fra tutti i commutatori permette l’individuazione di un percorso da un'origine ad una destinazione, questo permette la funzionalità di instradamento.

        MODELLI DI RETI
        1.	CLIENT-SERVER
        Sono coinvolti due processi (programmi in esecuzione), uno sulla macchina client e uno sulla macchina server. La comunicazione è rappresentata da un processo client che manda un messaggio attraverso la rete al processo server e resta in attesa di un messaggio di risposta. Quando il processo server riceve la richiesta, esegue il lavoro o recupera i dati desiderati e restituisce una risposta.
        2.	PEER-TO-PEER
        Gli individui che costituiscono un gruppo spontaneo sono in grado di comunicare tra di loro. In linea di principio, ognuno può comunicare con chiunque all’interno del gruppo senza che vi sia una divisione predefinita tra server e client. Ogni utente mantiene il proprio database in locale e fornisce un elenco di altri utenti a lui noti che fanno parte del sistema, e può visitare qualunque altro membro sia per vedere che cosa abbia sia per ottenere i nominativi di altri membri da ispezionare a loro volta.

        GLI SCOPI DELLE RETI accesso alle informazioni, condivisione di risorse eterogenee, facilitazione della comunicazione.

        FUNZIONALITÀ DI UNA RETE  Affidabile (dobbiamo supporre che i dati poterbbero essere danneggiati, corrotti, perse, duplicati o ordine differente), Efficiente, Scalabile (con l’aumentare del numero degli utenti dovremmo aggiungere un piccolo Δx, rispettando la scelta economica e tecnologica), In grado di connettere ambienti applicativi diversi (eterogeneità dei dispositivi connessi), Instradamento (deve riuscire ad individuare i cammini ottimali da una specifica sorgente ad una specifica destinazione ovunque essi si trovano, indirizzare i nodi).

        Componenti di una rete: Hardware (apparati di interconnessione per il controllo della trasmissione) e Software (protocolli, drivers).

        Circuito fisico è punto-a-punto quando collega due soli nodi solo problemi di comunicazione
        fisica come: elettrici, ottici, onde elettromagnetiche.
        Circuito multipunto connette più nodi sullo stesso canale fisico  nuovi problemi come:
        Indirizzamento (quale nodo inviare un’informazione e a chi spedire la risposta), Commutazione (relay intermedi, favorire il passaggio di informazioni tra un nodo e l’altro), Instradamento e Alta Affidabilità (più strade di comunicazione così che se una cade la comunicazione può avvenire comunque). Possono nascere problemi di contesa (conflitto = collisione).

        Un possibile modello fisico che implementa la definizione data di rete di telecomunicazione deve prevedere la presenza di hosts (stazioni, dispositivi autonomi connessi a una rete, o anche Terminali, cioè punti di terminazione di una comunicazione), links (collegamenti trasmissivi, interconnessi fra loro tramite nodi di commutazione, es. punto a punto) e nodi di commutazione (Network switch = commutatore in italiano), il cui compito è quello di riconoscere le richieste per l’apertura di una connessione e fare in modo che i dati, relativi a tale connessione, arrivino al nodo di destinazione. Lo scopo è realizzare l’infrastruttura di rete stessa con una logica multi hop relay, cioè devono ricevere l’informazione su un’interfaccia e passarli avanti su un’altra interfaccia, ad ogni interfaccia è collegato un link di comunicazione diverso e quindi questi nodi smistano le informazioni da un link (e quindi può essere uno switch intermedio o di terminazione) verso un altro facendo viaggiare le informazioni. L'accordo fra tutti i commutatori permette l’individuazione di un percorso da un'origine ad una destinazione, questo permette la funzionalità di instradamento.

        MODELLI DI RETI
        1.	CLIENT-SERVER
        Sono coinvolti due processi (programmi in esecuzione), uno sulla macchina client e uno sulla macchina server. La comunicazione è rappresentata da un processo client che manda un messaggio attraverso la rete al processo server e resta in attesa di un messaggio di risposta. Quando il processo server riceve la richiesta, esegue il lavoro o recupera i dati desiderati e restituisce una risposta.
        2.	PEER-TO-PEER
        Gli individui che costituiscono un gruppo spontaneo sono in grado di comunicare tra di loro. In linea di principio, ognuno può comunicare con chiunque all’interno del gruppo senza che vi sia una divisione predefinita tra server e client. Ogni utente mantiene il proprio database in locale e fornisce un elenco di altri utenti a lui noti che fanno parte del sistema, e può visitare qualunque altro membro sia per vedere che cosa abbia sia per ottenere i nominativi di altri membri da ispezionare a loro volta.

    </p>

    <div class="navbar" id="down">
        <a href="#"><img src="https://img.icons8.com/ios/40/C29436/search--v1.png"/></a>
        <a href="#"><img src="https://img.icons8.com/ios-glyphs/40/C29436/shopping-cart--v1.png"/></a>
        <span class="dropup">
            <button class="dropbtn" onclick="isLogin()" id="utente">
                <img src="https://img.icons8.com/ios-glyphs/40/C29436/user-male-circle.png"/>
            </button>

            <div class="dropup-content" id="elements">
                <a href="#">Ordini Effettuati</a>
                <a href="#">Modifica Credenziali</a>
                <a href="#">Lista dei desideri</a>
                <a href="#">Logout</a>
            </div>
        </span>
        <a href="#"><img src="https://img.icons8.com/ios/40/C29436/info--v1.png"/></a>
    </div>
</body>
</html>
