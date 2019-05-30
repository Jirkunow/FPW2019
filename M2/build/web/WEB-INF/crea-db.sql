/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gznag
 * Created: 29-mag-2019
 */

create table articolo(
    idArt serial primary key,
    titolo varchar(150),
    testo varchar(300),
    immagine varchar(150),
    stato varchar(150),
    pubblicazione date,
    categoria varchar(150)
);

create table User(
    id serial primary key,
    nome varchar(150),
    cognome varchar(150),
    email varchar(150),
    ente varchar(150),
    autore varchar(150)
);

create table valutazioni(
    idValu serial primary key,
    commentoOrganizzatori varchar(300),
    commentoAutori varchar(300),
    voto int(11),
    idArt bigint unsigned references Articolo(idArt)on delete cascade on update cascade
);

create table art_user(
    idArt bigint unsigned references Articolo(idArt)on delete cascade on update cascade,
    id bigint unsigned references User(id) on update cascade on delete cascade
);  