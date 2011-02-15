/* 
SQLyog v4.02
Host - 10.0.0.11 : Database - rosenhoff_oldboys
**************************************************************
Server version 4.0.18
*/

create database if not exists `rosenhoff_oldboys`;

use `rosenhoff_oldboys`;

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
Table data for rosenhoff_oldboys.Aktivitet
*/

INSERT INTO `Aktivitet` VALUES 
(38,'2008-03-09 19:45:00','Ril Boys  -  Progress oldtimers','Grünerhallen','21:00:00'),
(37,'2008-03-02 21:00:00','Jutul Rhinos  -  Ril Boys','Bærum Ishall','22:15:00'),
(36,'2008-02-17 21:00:00','Ril Boys  -  Lambertseter','Grünerhallen','22:15:00'),
(35,'2008-02-10 21:00:00','Lørenskog 2  -  Ril Boys','Lørenskog ishall','22:15:00'),
(34,'2008-01-27 19:45:00','Ril Boys - LSI Oldtimers','Grünerhallen','21:00:00'),
(33,'2008-01-20 21:00:00','Oslo Oilers  -  Ril Boys','Grünerhallen','22:15:00'),
(32,'2007-12-16 19:45:00','Ril Boys  -  Jutul Rhinos','Grünerhallen','21:00:00'),
(31,'2007-12-02 19:45:00','Ril Boys  -  Grüner Eastenders','Grünerhallen','21:00:00'),
(30,'2007-11-12 22:00:00','Lambertseter 2  -  Ril Boys','Lørenhallen','23:15:00'),
(29,'2007-11-06 22:00:00','Progress Oldtimers  -  Ril Boys','Lørenhallen','23:15:00'),
(28,'2007-10-30 21:00:00','LSI Oldtmers  -  Ril Boys','Skedsmo Ishall','22:15:00'),
(40,'2007-10-26 21:00:00','TRENING ! !','Lørenhallen','22:00:00'),
(41,'2007-10-31 21:00:00','Trening ! !','Lørenhallen','22:00:00');

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
Table data for rosenhoff_oldboys.Bruker
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
Table data for rosenhoff_oldboys.Kamp
*/

INSERT INTO `Kamp` VALUES 
(24,'Oslo Oilers','2007-10-21','Hjemme',6,2,NULL),
(21,'Lørenskog 2','2007-10-07','Hjemme',10,0,NULL),
(23,'Grüner Eastenders','2007-10-14','Hjemme',2,2,NULL);

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
Table data for rosenhoff_oldboys.Nyhet
*/

INSERT INTO `Nyhet` VALUES 
(3,'<p>VM OLDBOYS</p><p>Under \"Bilder\" har vi lagt ut bildet av  laget som representerte RIL-BOYS under VM i oldboys, Daytona Beach, Florida i 1989.</p><p>RS</p>','J','2006-08-30 07:53:28'),
(4,'<p>LSI - RIL BOYS : 3 -7</p><p>Kampen mot LSI 13/2 ble gjennomført uten innbyttere.  En formidabel innsats av;Terje G og Terje H, Ponny, Hornfinn og Knut (pluss keper`n).</p><p>Dette til info for de av dere som \"glemte\" at det var kamp og satt hjemme i godstolen og så på Hotell Cæsar i reprise fra forrige torsdag !!!!!!!! </p>','J','2007-02-14 11:10:57'),
(9,'<p>Sesongen 2007/2008</p><p>Neste sesongs serie vil bli avviklet med med spill i 3 divisjoner. RIL Boys er iht forslag til inndeling plassert i 2. divisjon. Divisjonen består i tillegg av; Spartacus Broilers - Lambertseter Flyers I - Vikings - Lørenskog Oldtimers I - Gamle Oslo Rullators - Jar Oldtimers - Skjetten Old Gators. På årsmøtet i NOHA la Rosenhoff inn forslag om spill i 2 divisjoner etter modell av siste sesong. Forslaget ble nedstemt med 13 mot 3 stemmer.</p><p>Rune og Per</p>','J','2007-05-30 13:33:04'),
(10,'<p><strong>Velkommen til ny sesong med veteran hockey. Seriestart blir søndag 7. oktober mot Lørenskog</strong>.</p><p>Vi vil elers påpeke dette med spillelisenser. Laget blir ilagt bot på kr. 1.500,- pr. spiller pr. match samt tape matchen dersom noen blir tatt i å spille uten lisens. Minner også om korrekt utstyr eks. hjelm m/ørebeskyttelse og halsebeskytter.</p><p><u><strong>Vi savner noen drakter  </strong></u>Har du drakt eller annet utstyr som tilhører Rosenhoff, ønsker vi dettei retur dersom du ikke skal spille denne sesongen.</p><p>Hilsen Rune og Per</p>','J','2007-09-20 14:13:44');

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

