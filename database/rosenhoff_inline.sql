/* 
SQLyog v4.02
Host - 10.0.0.11 : Database - rosenhoff_inline
**************************************************************
Server version 4.0.18
*/

create database if not exists `rosenhoff_inline`;

use `rosenhoff_inline`;

/*
Table structure for Aktivitet
*/

drop table if exists `Aktivitet`;
CREATE TABLE `Aktivitet` (
  `id` int(11) NOT NULL auto_increment,
  `naar` datetime NOT NULL default '0000-00-00 00:00:00',
  `hva` varchar(50) NOT NULL default '',
  `hvor` varchar(50) NOT NULL default '',
  `ferdig` time NOT NULL default '00:00:00',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM ROW_FORMAT=DYNAMIC;

/*
Table data for rosenhoff_inline.Aktivitet
*/

INSERT INTO `Aktivitet` VALUES 
(1,'2006-04-26 20:00:00','Vika Vipers  - Blunders 2','Grünerhallen','21:00:00'),
(2,'2006-05-04 19:00:00','Oslo Stars - Blunders 2','Grünerhallen','20:00:00'),
(3,'2006-05-09 19:00:00','Blunders 2 - Thunderboys','Grünerhallen','20:00:00'),
(4,'2006-05-10 20:00:00','Mølla - Blunders 2','Grünerhallen','21:00:00'),
(5,'2006-05-11 18:00:00','Blunders 2- Munin','Grünerhallen','19:00:00'),
(6,'2006-08-14 20:00:00','Snipers-Blunders 2','Grünerhallen','21:00:00'),
(7,'2006-08-15 18:00:00','Blunders 2- Eastenders','Grünerhallen','19:00:00'),
(8,'2006-08-17 19:00:00','Grüner-Blunders 2','Grünerhallen','20:00:00'),
(9,'2006-08-21 19:00:00','Blunders 2- Wheelfighters','Grünerhallen','20:00:00'),
(10,'2006-08-23 19:00:00','Blunders 2-Vika Vipers','Grünerhallen','20:00:00'),
(11,'2006-08-17 21:00:00','Eastenders-Blunders 2','Grünerhallen','22:00:00'),
(12,'2006-08-22 20:00:00','Blunders 2-Snipers','Grünerhallen','21:00:00'),
(13,'2007-04-23 20:00:00','Blunders 2 - Vika Vipers','Furuset forum','21:00:00'),
(14,'2007-04-25 19:00:00','NTG FA - Blunders 2','Furuset forum','20:00:00'),
(15,'2007-05-07 19:00:00','Blunders 2 - Rollerboys','Furuset forum','20:00:00'),
(16,'2007-05-10 20:00:00','Oslo Stars - Blunders 2','Furuset forum','21:00:00'),
(17,'2007-05-15 20:00:00','Blunders 2 - Oslo Stars','Furuset forum','21:00:00'),
(18,'2007-05-16 20:00:00','Wheelfighters - Blunders 2','Furuset forum','21:00:00'),
(19,'2007-05-22 20:00:00','Blunders 2 - Mølla','Furuset forum','21:00:00'),
(20,'2007-05-23 20:00:00','Vika Vipers - Blunders 2','Furuset forum','21:00:00'),
(21,'2007-05-29 19:00:00','Blunders 2 - NTG FA','Furuset forum','20:00:00'),
(22,'2007-05-31 19:00:00','Rollerboys - Blunders 2','Furuset forum','20:00:00'),
(23,'2007-06-04 19:00:00','Giga Gøy - Blunders 2','Furuset forum','20:00:00'),
(24,'2007-06-07 20:00:00','Mølla - Blunders 2','Furuset forum','21:00:00'),
(25,'2007-06-12 20:00:00','Blunders 2 - Wheelfighters','Furuset forum','21:00:00'),
(26,'2007-06-13 20:00:00','Blunders 2 - Giga Gøy','Furuset forum','21:00:00'),
(27,'2007-06-18 19:00:00','Semi: Nr 1 - Nr 4','Furuset forum','20:00:00'),
(28,'2007-06-18 20:00:00','Semi: Nr 2 - Nr 3','Furuset forum','21:00:00'),
(29,'2007-06-20 19:00:00','Finale','Furuset forum','20:00:00');

/*
Table structure for Bruker
*/

drop table if exists `Bruker`;
CREATE TABLE `Bruker` (
  `id` int(11) NOT NULL default '0',
  `brukerNavn` varchar(15) NOT NULL default '',
  `passord` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM ROW_FORMAT=DYNAMIC;

/*
Table data for rosenhoff_inline.Bruker
*/

INSERT INTO `Bruker` VALUES 
(0,'bjornhaa','klikk11'),
(1,'rune','runehoff');

/*
Table structure for Kamp
*/

drop table if exists `Kamp`;
CREATE TABLE `Kamp` (
  `id` int(11) NOT NULL auto_increment,
  `motstander` varchar(30) NOT NULL default '',
  `dato` date NOT NULL default '0000-00-00',
  `hjemme` varchar(10) NOT NULL default '',
  `maal_scoret` int(11) NOT NULL default '0',
  `maal_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for rosenhoff_inline.Kamp
*/

INSERT INTO `Kamp` VALUES 
(20,'NTG','2007-04-25','Hjemme',4,10,NULL),
(22,'Rollerboys','2007-05-07','Hjemme',2,11,NULL),
(23,'Oslo Stars','2007-05-10','Hjemme',2,14,NULL),
(24,'Oslo Stars','2007-05-15','Hjemme',4,8,NULL),
(25,'Wheelfighters','2007-05-16','Hjemme',6,5,NULL),
(26,'Mølla','2007-05-22','Hjemme',4,6,NULL),
(27,'Vika Vipers','2007-05-23','Hjemme',3,2,NULL),
(28,'NTG','2007-05-29','Hjemme',2,5,NULL),
(19,'Vika Vipers','2007-04-23','Hjemme',6,3,NULL);

/*
Table structure for Nyhet
*/

drop table if exists `Nyhet`;
CREATE TABLE `Nyhet` (
  `nyhet_id` int(11) NOT NULL auto_increment,
  `nyhet_txt` longtext NOT NULL,
  `aktiv` char(1) NOT NULL default 'n',
  `tidlagtinn` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`nyhet_id`)
) TYPE=MyISAM ROW_FORMAT=DYNAMIC;

/*
Table data for rosenhoff_inline.Nyhet
*/

INSERT INTO `Nyhet` VALUES 
(2,'<p>Har lagt ut noen bilder fra hockey-vm i Riga. Legg spesielt merke til mongobildet av Jon</p>','J','2006-08-13 19:45:57'),
(4,'<p>Inline-serien 2007</p><p>Oslo kommune/Oslo Idrettskrets  har leid ut hallen til BI for en lengre periode våren 07. Denne utleieperioden er i år lengre enn den vanligvis har vært, og det vil ikke være mulig å arrangere inline serie parallelt med utleie til BI. Det har vært diskutert å flytte serien til Lørenhallen, men Grünerhallen er ikke villige til å låne bort underlaget da dette skal nyttes ifm utleie til BI. Det er tydeligvis penga som styrer prioriteringen, men Grünerhallen har samtidig et ansvar, som monopolist på inline dekket, å legge tilrette slik at serien kan bli avviklet. Mange lag/spillere har investert masse penger i utstyr i en aktivitet som man har sett for seg at er et permanent arrangement. I beste fall vil det ila våren bli arrangert 1-2 turneringer. Hele opplegget stinker og er rett og slett uetisk i forhold til det ansvaret spesielt Idrettskretsen og kommunen har for å legge til rette for idrettsaktivitet i de fasilitetene som er beregnet for dette. Men vi vet jo alle hvilke partier som styrer i Oslo for øyeblikket.</p>','J','2007-03-21 12:23:23'),
(6,'<p>INLINE SERIE 2007</p><p>Gamle Oslo og Jordal Pro Sport (sjappa til Petter Prate) har sparka i gang inline serie.</p><p>Mer info om dette kan dere lese ved klikke inn på følgende link; <a href=\"http://www.inlinehockey.no\">http://www.inlinehockey.no</a></p>','J','2007-04-02 14:50:02');

/*
Table structure for Poeng
*/

drop table if exists `Poeng`;
CREATE TABLE `Poeng` (
  `id` int(11) NOT NULL auto_increment,
  `spiller` int(11) NOT NULL default '0',
  `erPass` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table structure for Rapport
*/

drop table if exists `Rapport`;
CREATE TABLE `Rapport` (
  `id` int(11) NOT NULL auto_increment,
  `kamp` int(11) NOT NULL default '0',
  `overskrift` varchar(50) default NULL,
  `tekst` text,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table structure for Spiller
*/

drop table if exists `Spiller`;
CREATE TABLE `Spiller` (
  `id` int(11) NOT NULL auto_increment,
  `navn` varchar(30) NOT NULL default '',
  `posisjon` char(3) default NULL,
  `bilde` varchar(40) default NULL,
  `kamper` int(11) NOT NULL default '0',
  `utv` int(11) NOT NULL default '0',
  `email` varchar(30) default NULL,
  `mobil` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

