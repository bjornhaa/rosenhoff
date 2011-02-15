/* 
SQLyog v4.02
Host - 10.0.0.11 : Database - Rosenhoff
**************************************************************
Server version 4.0.18
*/

create database if not exists `Rosenhoff`;

use `Rosenhoff`;

/*
Table structure for AktivitetHockey
*/

drop table if exists `AktivitetHockey`;
CREATE TABLE `AktivitetHockey` (
  `id` int(11) NOT NULL auto_increment,
  `n�r` datetime NOT NULL default '0000-00-00 00:00:00',
  `hva` varchar(50) NOT NULL default '',
  `hvor` varchar(50) NOT NULL default '',
  `ferdig` time NOT NULL default '00:00:00',
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.AktivitetHockey
*/

INSERT INTO `AktivitetHockey` VALUES 
(81,'2005-10-12 21:00:00','Trening','L�renhallen','22:00:00',0),
(63,'2005-09-24 13:30:00','Trening','L�renhallen','14:45:00',0),
(64,'2005-11-04 20:15:00','M�lla-RIL','Gr�nerhallen','21:45:00',0),
(65,'2005-11-11 21:15:00','RIL-Forward','L�renhallen','22:45:00',0),
(66,'2005-11-17 19:15:00','Gamle Oslo-RIL','Gr�nerhallen','20:45:00',0),
(67,'2005-11-25 19:30:00','RIL-Tjernet','L�renhallen','21:00:00',0),
(68,'2005-12-11 17:00:00','Ringerike2- RIL','Sjongshallen','18:30:00',0),
(69,'2006-01-13 19:30:00','RIL-Rasta2','L�renhallen','21:00:00',0),
(70,'2006-01-20 21:15:00','RIL-M�lla','L�renhallen','22:45:00',0),
(71,'2006-01-29 18:15:00','Forward-RIL','Jordal Amfi','19:45:00',0),
(72,'2006-02-03 21:15:00','RIL-Gamle Oslo','L�renhallen','22:45:00',0),
(73,'2006-02-07 19:30:00','Tjernet-RIL','Gr�nerhallen','21:00:00',0),
(74,'2006-03-01 20:15:00','RIL-Ringerike2','L�renhallen','21:45:00',0),
(75,'2006-03-10 20:30:00','Rasta2-RIL','L�renskog','22:00:00',0),
(80,'2005-10-05 21:00:00','Trening','L�renhallen','22:00:00',0),
(77,'2005-09-28 21:00:00','Trening','L�renhallen','22:00:00',0),
(82,'2005-10-21 21:00:00','Trening','L�renhallen','22:00:00',0),
(83,'2005-10-30 17:45:00','Trening','L�renhallen','18:45:00',0),
(84,'2005-11-07 21:00:00','Trening','L�renhallen','22:00:00',0),
(85,'2005-11-16 21:00:00','Trening','L�renhallen','21:45:00',0),
(89,'2005-12-10 17:00:00','Trening','L�renhallen','18:00:00',0),
(88,'2005-11-28 21:00:00','Trening','L�renhallen','22:00:00',0),
(90,'2005-12-14 21:00:00','Trening','L�renhallen','22:00:00',0),
(93,'2006-01-04 21:00:00','Trening','L�renhallen','22:00:00',0),
(92,'2005-12-21 21:00:00','Trening (med Aker)','L�renhallen','22:00:00',0),
(94,'2006-01-14 14:30:00','Trening','L�renhallen','15:30:00',0),
(95,'2006-01-16 21:00:00','Trening','L�renhallen','22:00:00',0),
(96,'2006-01-23 21:00:00','Trening','L�renhallen','22:00:00',0),
(97,'2006-01-30 21:00:00','Trening','L�renhallen','22:00:00',0),
(98,'2006-02-09 19:30:00','Trening','L�renhallen','20:45:00',0),
(99,'2006-02-13 20:45:00','Trening','L�renhallen','22:00:00',0),
(100,'2006-02-20 21:15:00','Trening','L�renhallen','22:00:00',0),
(101,'2006-02-27 21:00:00','Trening','L�renhallen','22:00:00',0),
(102,'2006-03-05 16:00:00','Trening','L�renhallen','17:00:00',0),
(103,'2006-03-06 21:15:00','Trening(21:10)','L�renhallen','22:00:00',0),
(104,'2006-03-13 21:00:00','Trening','L�renhallen','22:00:00',0),
(105,'2006-04-11 17:00:00','test','test','17:00:00',0);

/*
Table structure for AktivitetInline
*/

drop table if exists `AktivitetInline`;
CREATE TABLE `AktivitetInline` (
  `id` int(11) NOT NULL auto_increment,
  `n�r` datetime NOT NULL default '0000-00-00 00:00:00',
  `hva` varchar(50) NOT NULL default '',
  `hvor` varchar(50) NOT NULL default '',
  `ferdig` time NOT NULL default '00:00:00',
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.AktivitetInline
*/

INSERT INTO `AktivitetInline` VALUES 
(1,'2006-04-26 20:00:00','Vika Vipers - Blunders 2','Gr�nerhallen','21:00:00',0),
(2,'2006-05-04 19:00:00','Oslo Stars - Blunders 2','Gr�nerhallen','20:00:00',0),
(3,'2006-05-09 19:00:00','Blunders 2 - Thunderboys','Gr�nerhallen','20:00:00',0),
(4,'2006-05-10 20:00:00','M�lla - Blunders 2','Gr�nerhallen','21:00:00',0),
(5,'2006-05-11 18:00:00','Blunders 2- Munin','Gr�nerhallen','19:00:00',0),
(6,'2006-08-14 20:00:00','Snipers-Blunders 2','Gr�nerhallen','21:00:00',0),
(7,'2006-08-15 18:00:00','Blunders 2- Eastenders','Gr�nerhallen','19:00:00',0),
(8,'2006-08-17 19:00:00','Gr�ner-Blunders 2','Gr�nerhallen','20:00:00',0),
(9,'2006-08-21 19:00:00','Blunders 2- Wheelfighters','Gr�nerhallen','20:00:00',0),
(10,'2006-08-23 19:00:00','Blunders 2-Vika Vipers','Gr�nerhallen','20:00:00',0),
(11,'2006-08-17 21:00:00','Eastenders-Blunders 2','Gr�nerhallen','22:00:00',0),
(12,'2006-08-22 20:00:00','Blunders 2-Snipers','Gr�nerhallen','21:00:00',0);

/*
Table structure for AktivitetOldBoys
*/

drop table if exists `AktivitetOldBoys`;
CREATE TABLE `AktivitetOldBoys` (
  `id` int(11) NOT NULL auto_increment,
  `n�r` datetime NOT NULL default '0000-00-00 00:00:00',
  `hva` varchar(50) NOT NULL default '',
  `hvor` varchar(50) NOT NULL default '',
  `ferdig` time NOT NULL default '00:00:00',
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.AktivitetOldBoys
*/

INSERT INTO `AktivitetOldBoys` VALUES 
(40,'2006-01-09 22:00:00','Skjetten-RIL Boys','Furuset Forum','23:00:00',0),
(31,'2005-12-13 21:00:00','LSI-RIL Boys','Skedsmo','22:15:00',0),
(32,'2005-12-18 20:45:00','RIL Boys-L.seter 2','Gr�nerhallen','22:00:00',0),
(30,'2005-12-05 21:15:00','Furuset-RIL Boys','L�renhallen','22:30:00',0),
(29,'2005-12-04 19:30:00','RIL Boys-L.skog2','Gr�nerhallen','20:45:00',0),
(28,'2005-11-20 20:45:00','RIL Boys-Oilers','Gr�nerhallen','22:00:00',0),
(27,'2005-11-08 22:00:00','Progress-RIL Boys','L�renhallen','23:15:00',0),
(26,'2005-10-30 20:45:00','RIL Boys-SkiFarmers','Gr�nerhallen','22:00:00',0),
(25,'2005-10-18 20:45:00','Jutul-RIL-Boys','B�rum','22:00:00',0),
(24,'2005-10-16 19:30:00','RIL Boys-GamleOslo','Gr�nerhallen','20:45:00',0),
(23,'2005-10-09 19:30:00','Gr�ner-RIL Boys','Gr�nerhallen','20:45:00',0),
(42,'2006-01-25 22:00:00','RIL BOYS  -  JUTUL','Grunerhallen','23:15:00',0),
(44,'2006-01-30 21:30:00','SKI FARMERS - RIL BOYS','Ski Ishall','22:45:00',0),
(45,'2006-02-14 22:00:00','RIL BOYS - L�RENSKOG','Gr�nerhallen','23:15:00',0),
(46,'2006-03-14 22:00:00','PROGRESS  -  RIL BOYS','L�renhallen','23:15:00',0),
(47,'2006-02-28 21:00:00','SKEDSMO - RIL BOYS','Skedsmo ishall','22:15:00',0),
(48,'2006-03-07 22:00:00','RIL BOYS - OSLO OILERS','Gr�nerhallen','23:15:00',0);

/*
Table structure for BrukereHockey
*/

drop table if exists `BrukereHockey`;
CREATE TABLE `BrukereHockey` (
  `id` int(11) NOT NULL default '0',
  `brukerNavn` varchar(15) NOT NULL default '',
  `passord` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.BrukereHockey
*/

INSERT INTO `BrukereHockey` VALUES 
(0,'bjornhaa','klikk11'),
(1,'rune','runehoff');

/*
Table structure for BrukereInline
*/

drop table if exists `BrukereInline`;
CREATE TABLE `BrukereInline` (
  `id` int(11) NOT NULL default '0',
  `brukerNavn` varchar(15) NOT NULL default '',
  `passord` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.BrukereInline
*/

INSERT INTO `BrukereInline` VALUES 
(0,'bjornhaa','klikk11'),
(1,'rune','runehoff');

/*
Table structure for BrukereOldBoys
*/

drop table if exists `BrukereOldBoys`;
CREATE TABLE `BrukereOldBoys` (
  `id` int(11) NOT NULL default '0',
  `brukerNavn` varchar(15) NOT NULL default '',
  `passord` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.BrukereOldBoys
*/

INSERT INTO `BrukereOldBoys` VALUES 
(1,'bjornhaa','klikk11'),
(2,'perboe','perjan'),
(3,'rune','runehoff');

/*
Table structure for KampHockey
*/

drop table if exists `KampHockey`;
CREATE TABLE `KampHockey` (
  `id` int(11) NOT NULL auto_increment,
  `motstander` varchar(30) NOT NULL default '',
  `dato` date NOT NULL default '0000-00-00',
  `hjemme` varchar(10) NOT NULL default '',
  `m�l_scoret` int(11) NOT NULL default '0',
  `m�l_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampHockey
*/

INSERT INTO `KampHockey` VALUES 
(33,'M�lla','2005-11-04','Borte',7,2,NULL,0),
(34,'Forward','2005-11-11','Hjemme',6,3,NULL,0),
(35,'Gamle Oslo','2005-11-17','Borte',8,3,NULL,0),
(36,'Tjernet','2005-11-25','Hjemme',6,3,NULL,0),
(37,'Ringerike 2','2005-12-11','Borte',6,4,NULL,0),
(38,'Rasta 2','2006-01-13','Hjemme',16,3,NULL,0),
(39,'M�lla','2006-01-20','Hjemme',15,1,NULL,0),
(40,'Forward','2006-01-29','Borte',7,3,NULL,0),
(41,'Gamle Oslo','2006-02-03','Hjemme',12,4,NULL,0),
(42,'Tjernet','2006-02-07','Borte',2,7,NULL,0),
(43,'Ringerike','2006-03-01','Hjemme',4,5,NULL,0),
(44,'Rasta 2','2006-03-10','Borte',11,5,NULL,0);

/*
Table structure for KampInline
*/

drop table if exists `KampInline`;
CREATE TABLE `KampInline` (
  `id` int(11) NOT NULL auto_increment,
  `motstander` varchar(30) NOT NULL default '',
  `dato` date NOT NULL default '0000-00-00',
  `hjemme` varchar(10) NOT NULL default '',
  `m�l_scoret` int(11) NOT NULL default '0',
  `m�l_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampInline
*/

INSERT INTO `KampInline` VALUES 
(2,'M�lla','2006-04-04','Hjemme',0,7,NULL,0),
(3,'Munin','2006-04-05','Borte',5,0,NULL,0),
(4,'Gr�ner','2006-04-06','Hjemme',2,19,NULL,0),
(5,'Oslo Stars','2006-04-18','Hjemme',1,12,NULL,0),
(6,'Wheelfighters','2006-04-19','Borte',5,3,NULL,0),
(7,'Vika Vipers','2006-04-26','Borte',6,4,NULL,0),
(8,'Oslo Stars','2006-05-04','Borte',2,12,NULL,0),
(9,'Thunderboys','2006-05-09','Hjemme',9,2,NULL,0),
(10,'M�lla','2006-05-10','Borte',1,7,NULL,0),
(11,'Munin','2006-05-11','Hjemme',10,1,NULL,0);

/*
Table structure for KampOldBoys
*/

drop table if exists `KampOldBoys`;
CREATE TABLE `KampOldBoys` (
  `id` int(11) NOT NULL auto_increment,
  `motstander` varchar(30) NOT NULL default '',
  `dato` date NOT NULL default '0000-00-00',
  `hjemme` varchar(10) NOT NULL default '',
  `m�l_scoret` int(11) NOT NULL default '0',
  `m�l_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampOldBoys
*/

INSERT INTO `KampOldBoys` VALUES 
(15,'Jutul','2005-10-18','Hjemme',3,7,NULL,0),
(13,'Gr�ner','2005-10-09','Hjemme',3,6,NULL,0),
(14,'Gamle Oslo','2005-10-16','Hjemme',4,7,NULL,0),
(17,'Ski Farmers','2005-10-30','Hjemme',3,3,NULL,0),
(19,'Progress','2005-11-08','Borte',4,4,NULL,0),
(20,'Oslo Oilers','2005-11-20','Hjemme',4,3,NULL,0),
(21,'Jutul','2006-01-25','Hjemme',0,3,NULL,0),
(22,'Ski Farmers','2006-01-30','Hjemme',6,2,NULL,0),
(23,'L�renskog','2006-02-14','Hjemme',2,2,NULL,0),
(24,'LSI','2006-02-28','Borte',3,3,NULL,0),
(25,'Oslo Oilers','2006-03-07','Hjemme',5,3,NULL,0);

/*
Table structure for PoengHockey
*/

drop table if exists `PoengHockey`;
CREATE TABLE `PoengHockey` (
  `id` int(11) NOT NULL auto_increment,
  `spiller` int(11) NOT NULL default '0',
  `erPass` int(1) NOT NULL default '0',
  `erInline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.PoengHockey
*/

INSERT INTO `PoengHockey` VALUES 
(3,19,0,0),
(4,19,1,0),
(5,10,1,0),
(6,4,1,0),
(7,25,1,0),
(8,7,0,0),
(9,7,1,0),
(10,7,0,0),
(11,17,0,0),
(12,17,0,0),
(13,26,0,0),
(14,26,1,0),
(15,26,1,0),
(16,28,0,0),
(17,24,1,0),
(18,6,0,0),
(19,7,0,0),
(20,24,0,0),
(21,24,1,0),
(22,21,0,0),
(23,21,0,0),
(24,27,1,0),
(25,26,1,0),
(26,29,0,0),
(27,29,0,0),
(28,30,0,0),
(29,29,0,0),
(30,30,0,0),
(31,31,0,0),
(32,19,0,0),
(33,19,0,0),
(34,24,1,0),
(35,19,0,0),
(36,24,1,0),
(37,7,1,0),
(38,4,0,0),
(39,31,1,0),
(40,19,0,0),
(41,24,1,0),
(42,32,0,0),
(43,19,0,0),
(44,24,1,0),
(45,19,0,0),
(46,17,1,0),
(47,7,0,0),
(48,7,0,0),
(49,21,1,0),
(50,32,0,0),
(51,7,1,0),
(52,26,0,0),
(53,32,1,0),
(54,21,0,0),
(55,7,1,0),
(56,32,0,0),
(57,7,1,0),
(58,15,0,0),
(59,25,0,0),
(60,24,0,0),
(61,24,0,0),
(62,19,1,0),
(63,4,0,0),
(64,27,1,0),
(65,24,0,0),
(66,24,0,0),
(67,21,0,0),
(68,24,1,0),
(69,6,0,0),
(70,15,0,0),
(71,21,1,0),
(72,28,0,0),
(73,15,1,0),
(74,6,0,0),
(75,21,0,0),
(76,21,0,0),
(77,24,0,0),
(78,21,1,0),
(79,32,0,0),
(80,21,0,0),
(81,21,0,0),
(82,24,1,0),
(83,32,0,0),
(84,24,0,0),
(85,21,1,0),
(86,6,0,0),
(87,9,1,0),
(88,21,0,0),
(89,4,0,0),
(90,17,1,0),
(91,21,0,0),
(92,21,0,0),
(93,24,1,0),
(94,19,0,0),
(95,24,1,0),
(96,15,1,0),
(97,19,0,0),
(98,6,1,0),
(99,21,0,0),
(100,19,1,0),
(101,28,0,0),
(102,17,1,0),
(103,4,1,0),
(104,24,0,0),
(105,22,1,0),
(106,6,0,0),
(107,7,1,0),
(108,19,1,0),
(109,24,0,0),
(110,15,1,0),
(111,24,0,0),
(112,21,1,0),
(113,7,0,0),
(114,28,1,0),
(115,17,0,0),
(116,4,1,0),
(117,19,0,0),
(118,21,1,0),
(119,24,1,0),
(120,22,0,0),
(121,19,1,0),
(122,4,0,0),
(123,32,1,0),
(124,27,1,0),
(125,24,0,0),
(126,7,1,0),
(127,24,0,0),
(128,19,1,0),
(129,17,0,0),
(130,19,0,0),
(131,19,0,0),
(132,26,1,0),
(133,6,0,0),
(134,24,1,0),
(135,24,0,0),
(136,21,1,0),
(137,26,1,0),
(138,27,0,0),
(139,4,1,0),
(140,28,1,0),
(141,4,0,0),
(142,26,1,0),
(143,24,0,0),
(144,28,1,0),
(145,17,0,0),
(146,4,1,0),
(147,24,0,0),
(148,21,0,0),
(149,21,0,0),
(150,24,0,0),
(151,21,0,0),
(152,4,1,0),
(153,26,0,0),
(154,24,1,0),
(155,15,1,0),
(156,19,0,0),
(157,24,1,0);

/*
Table structure for PoengInline
*/

drop table if exists `PoengInline`;
CREATE TABLE `PoengInline` (
  `id` int(11) NOT NULL auto_increment,
  `spiller` int(11) NOT NULL default '0',
  `erPass` int(1) NOT NULL default '0',
  `erInline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table structure for PoengOldBoys
*/

drop table if exists `PoengOldBoys`;
CREATE TABLE `PoengOldBoys` (
  `id` int(11) NOT NULL auto_increment,
  `spiller` int(11) NOT NULL default '0',
  `erPass` int(1) NOT NULL default '0',
  `erInline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.PoengOldBoys
*/

INSERT INTO `PoengOldBoys` VALUES 
(1,13,0,0),
(2,13,0,0),
(3,9,0,0),
(4,15,0,0),
(5,9,0,0),
(6,14,0,0),
(7,9,0,0);

/*
Table structure for RapportHockey
*/

drop table if exists `RapportHockey`;
CREATE TABLE `RapportHockey` (
  `id` int(11) NOT NULL auto_increment,
  `kamp` int(11) NOT NULL default '0',
  `overskrift` varchar(50) default NULL,
  `tekst` text,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.RapportHockey
*/

INSERT INTO `RapportHockey` VALUES 
(1,33,'F�rste seriekamp','Matchen bar preg av at vi ikke hadde f�tt tid til � samspille oss med v�re nyervervelser fra Finland. Gutta fra \"de tusen sj�ars land\" var ogs� litt rustne og bar preg av at de ikke hadde spilt p� en stund.Alt i alt en grei gjennomkj�ring.'),
(2,34,'Kontrollerte inn seieren','Rosenhoff kontrollerte inn seieren mot et Forward lag som for anledningen var forsterket med tidligere Rosenhoff spiller gjennom mange �r - Tom Eddy Harms som ogs� scorer sitt f�rste m�l for sin nye klubb.\r\nForward hang godt med, men v�r utmerkede Finske rekke avgjorde kampen n�rmest p� egen h�nd med fire scorede m�l. Morsomt � se at Forwards m�lvakt; Trond Ofte p� snart 50 �r fortsatt holder koken.'),
(3,37,'Sterk motstand','Ringerike overrasket med agressiv forechecking, bra bevegelse og stor innsatsvilje. Vi hadde vel her trodd at dette skulle bli plankekj�ring basert p� Ringerikes tidligere resultater i innev�rende sesong. Selv om vi egentlig aldri f�lte oss sterkt truet hang Ringerike med helt til \"the bitter end\", og scorer sitt fjerde m�l bare 2 sekunder f�r kampslutt. Pekka Koivisto scorer 3 av Rosenhoffs m�l og er kampens frontfigur. David \"Kr�vel Welle Walle\" Olsen f�r endelig hull p� byllen og scorer sitt f�rste m�l i organisert seriespill. Gratulerer \"Kr�vel\".Hornfinn scorer Rosenhoffs f�rste m�l etter et steinhardt slagskudd hvor keeperen til Ringerike fortsatt lurer p� hvor spaken hans ble av. Det g�r rykter p� H�nefoss at han brukte hele romjula p� � lete. Uten resultat. Bj�rn Humba Haakenstad kommer sterkt tilbake etter innledningsvis � ha v�rt kraftig preget av l�rdagens julebord. Etter � ha kvittet seg med overfl�dig ribbe og akevitt kvikner han sakte men sikkert til live og lager Rosenhoffs femte m�l med assistanse fra nyervervelsen Lars Ottar Kv�le fra NTNUI FLYERS.'),
(4,36,'Sl�r regjerende mestere','\"B�ffelhockey\" er et uttrykk som hjemmesidene til Rosenhoff lanserte for noen tid tilbake som en beskrivelse av Tjernets spillestil. Kjenntegnes av tackling av spiller som har spilt fra seg pucken for en peiode siden. Rosenhoff ledet komfortabelt 4-1 fram til 5 minutter spilt av andre periode og hadde vel egentlig ikke v�rt vitne til noe s�rlig \"b�fflete\" spill fra Tjernets side s� langt. Etter dette iverksatte Tjernet sin mere kjente spillem�te - tok oss alvorlig p� senga og reduserte til 4-3 ila 4 minutter. RIL greide imidlertid � ta seg kraftig sammen parallellt med at \"b�fflingen\" �kte i intensitet. �ket \"B�ffling\" kan ofte f�re til at fokuset utelukkende konsentreres rundt det � tackle og ikke noe s�rlig p� spillet og pucken som s�dann. F�rer ogs� vanligvis til flere minutter i utvisningsboksen. Mens Tjernet satt i fryseboksen i 12 minutter i tredje periode kunne Rosenhoff komfortabelt �ke til b�de 5 og 6-3. Tjernets mannsterke st�tteapparat mante sine spillere til ytterligere \"B�ffling\" og kjeftet sammenhengende p� de udugelige dommerne uten at dette hadde nevneverdig positiv innflytelse p� kampresultatet. Dette var en match hvor v�re venner fra Finland tok ut hele sitt potensiale og stod for 5  av 6 m�l. Tidligere Tjernet spiller; Kim Rustad s�rget for Rosenhoff fjerde m�l.'),
(5,35,'Finnene \"ruler\"','Denne kampen er det vel egentlig ikke s� mye � skrive om bortsett fra at Rosenhoff kontrollerte stort sett hele veien. Gamle Oslo scorer riktignok det f�rste m�let, men greier ikke helt � holde f�lge med farten til Rosenhoffs \"importrekke\". Finnene scorer 7 av 8 m�l. 6 av disse bes�rges av v�r eminente nr. 17; Juhani Kaltakari. Bj�rn \"Humba\" Haakenstad bryter Finnenes scoringsrekke med et lett blafrende h�ndleddsskudd som daler og lurer seg inn mellom leggskinna til en udekket Gamle-Oslo keeper.'),
(6,38,'Masse scoringer','Et Rosenhoff som hadde l�rt � ikke undervurdere motstanderen utfra plassering p� tabellen - kj�rte over et Rasta 2 som ikke holdt f�lge tempomessig.En del forfall til denne kampen �pnet for et midlertidig \"comeback\" fra Terje G. som greide seg utmerket selv om han hadde glemt at det var lov � tackle. Det mest spektakul�re forfallet til denne kanpen var Bj�rn Humba Haakenstad som av Uranienborg sosialkontor hadde f�tt innvilget en ukes opphold ved et Belgisk kurbad for � restituere seg etter en intensiv julebord -periode. Ilka Moilanen er kampens frontfigur med 6 scoringer og 3 pass. Anders Geithung utmerker seg ogs� i denne kampen med 3 fine scoringer.'),
(7,39,'Fortsetter � vinne stort','M�lla ble et nummer for lite og sifrene fra f�rste seriekamp ble mer enn dobla. V�r finske importrekke st�r for 10 av 15 m�l. Spesielt samspillet mellom Ilka og Juhani imponerte tidvis stort i denne kampen. Humba Haakenstad var tilbake etter sitt kurbadopphold i Belgia, hvor det ble konkludert med at han hadde forspist seg p� medisterkaker.\r\nDette var en kamp hvor Rosenhoffs keeper Rune Syversen lenge hadde mulighetene til � holde nullen for f�rste gang siden lilleputtlaget til Rosenhoff seiret 1-0 over Kamp�rn p� D�lenenga en januardag i 1971. Anders Geithung hadde frem til den fatale feilvurderingen som s�rget for M�lla sitt m�l, spilt en up�klagelig kamp. Herr Geithung styrer en helt ufarlig puck med k�lleskaftet i bue over Rosenhoff-keeperen og rett i m�l. Rosenhoffs formann, Tor Olsen, er kalt inn fra pensjonistferie i Spania for � ta stilling til en evt. utestengelse av herr Geithung for resten av sesongen.'),
(8,40,'Fortsatt ubeseiret','Denne kampen satt trolig rekord i sammenlagt alder p� keepere i ordin�rt seriespill. N�rmere 100 �r.Trond Ofte reddet Forward fra to-sifra tap etter en god kamp mellom stengene. Den \"gamle\" keeperveteranen med bakgrunn fra Rosenhoff, hadde flere kvalifiserte redninger. 5 av Rosenhoffs 7 m�l ble scoret av v�r eminente Finske - rekke. Rosenhoff f�rte kampen, men Forward greide tidvis � n�ytralisere v�re beste spillere gjennom tett markering og god bevegelighet. \"Humba\" Haakenstad spilte heller ikke i denne kampen opp mot sitt beste. Det mistenkes at R�dtvedt gutten med Vestkantambisjoner f�rer et for tiden hektisk uteliv. Observert sist l�rdag p� Lipp sammen med Petter Stordalen og Celina Middelfart.\r\nRosenhoffs beste spiller denne kampen var Tuomas. Tom Eddy Harms, tidligere Rosenhoff spiller, ogs� kalt \"femtekolonisten\"  scorer Forward sitt tredje m�l etter utallige fors�k p� � overliste Rosenhoffs old boys keeper.'),
(9,40,'r','s'),
(10,41,'Nok en overlegen seier','Gamle Oslo holdt f�lge i 1 periode, s� var det slutt. Perioderesultatene 2-2,5-1 og 5-1 forteller det meste. V�re briljante Finner scorer 8 av 12 m�l. Det peneste m�let ble scoret av Pekka som fyrer av et slagskudd rett innenfor bl� opp i krysset til h�yre for Gamle Oslo sin keeper.\r\nEllers s� tegner b�de Jon, Lars Ottar, Kim og Bj�rn seg for en scoring hver.Bj�rn ser ut til � ha senket vestkantambisjonene sine en smule da han etter kampen skulle drikke �l og spille helsetr�ye-poker med B�rd og Anders. Vi ser fram til neste kamp mot Tjernet da seriemesterskapet i realiteten kan avgj�res.');

/*
Table structure for RapportInline
*/

drop table if exists `RapportInline`;
CREATE TABLE `RapportInline` (
  `id` int(11) NOT NULL auto_increment,
  `kamp` int(11) NOT NULL default '0',
  `overskrift` varchar(50) default NULL,
  `tekst` text,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.RapportInline
*/

INSERT INTO `RapportInline` VALUES 
(1,1,'R�vkj�rt','I denne kampen ble vi r�vkj�rt etter alle kunstens regler. Selv p� 13-1 til Gr�ner s� jobber alle gr�ner-schwina hjem som om det skulle st�tt om OL-plass. Nei fy faan, s� spreke folk vil vi ha oss frabedt i v�r divisjon');

/*
Table structure for SpillereHockey
*/

drop table if exists `SpillereHockey`;
CREATE TABLE `SpillereHockey` (
  `id` int(11) NOT NULL auto_increment,
  `navn` varchar(30) NOT NULL default '',
  `posisjon` char(3) default NULL,
  `bilde` varchar(40) default NULL,
  `inline` int(1) NOT NULL default '0',
  `hockey` int(1) NOT NULL default '1',
  `kamper_hockey` int(11) NOT NULL default '0',
  `utv_hockey` int(11) NOT NULL default '0',
  `kamper_inline` int(11) NOT NULL default '0',
  `utv_inline` int(11) NOT NULL default '0',
  `email` varchar(30) default NULL,
  `mobil` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.SpillereHockey
*/

INSERT INTO `SpillereHockey` VALUES 
(6,'Anders Geithung','F','anders.jpg',1,1,8,2,0,0,'','900 900 55'),
(5,'Rune Syversen','K','rune_syv.jpg',1,1,9,2,0,0,'rsyversen@mil.no','934 83 182'),
(4,'Bj�rn Haakenstad','A',NULL,1,1,8,11,0,0,'bjorn@haakenstad.com','900 900 35'),
(7,'Henrik Wilenius','A',NULL,0,1,9,0,0,0,'',''),
(8,'Arild Gr�nnerud','F',NULL,0,1,2,0,0,0,'','916 25 339'),
(9,'Terje Gulbrandsen','A',NULL,0,1,1,0,0,0,'terje.g@chello.no','915 98 435'),
(10,'Andr� Halvorsen','A',NULL,1,1,4,2,0,0,'',''),
(11,'Per Martin Hansen','F','martin.jpg',1,1,0,0,0,0,'','922 44 081'),
(26,'Kim Rustad','F',NULL,0,1,6,2,0,0,'',''),
(13,'Terje Heide','A',NULL,0,1,0,0,0,0,'terje.heide@sentrum.toyota.no','996 35 833'),
(27,'Lars Ottar Kv�le','A',NULL,0,1,6,2,0,0,'',''),
(15,'Arnfinn Hoff','F','arnfinn.jpg',1,1,8,2,0,0,'',''),
(16,'Rune Ilseng','A','illseng.jpg',1,1,0,0,0,0,'','902 07 905'),
(17,'Jon Johannessen','A',NULL,0,1,8,2,0,0,'','924 252 48'),
(18,'Jorma Knuutinen','K',NULL,0,1,0,0,0,0,'','920 44 183'),
(19,'Juhani Kaltakari','A',NULL,0,1,7,4,0,0,'',''),
(21,'Illka Moilanen','A',NULL,0,1,5,2,0,0,'',''),
(22,'Ronny Pedersen','F','ronny.jpg',1,1,5,0,0,0,'','920 62 977'),
(28,'Svein Rudihaugen','A',NULL,0,1,8,2,0,0,'',''),
(24,'Pekka Koivisto','A',NULL,0,1,8,6,0,0,'',''),
(25,'David Walle-Olsen','A',NULL,1,1,5,2,0,0,'',''),
(32,'Tuomas Kukkula','A',NULL,0,1,7,0,0,0,'',''),
(31,'B�rd R�sn�s','A',NULL,0,1,3,0,0,0,'','');

/*
Table structure for SpillereInline
*/

drop table if exists `SpillereInline`;
CREATE TABLE `SpillereInline` (
  `id` int(11) NOT NULL auto_increment,
  `navn` varchar(30) NOT NULL default '',
  `posisjon` char(3) default NULL,
  `bilde` varchar(40) default NULL,
  `inline` int(1) NOT NULL default '0',
  `hockey` int(1) NOT NULL default '1',
  `kamper_hockey` int(11) NOT NULL default '0',
  `utv_hockey` int(11) NOT NULL default '0',
  `kamper_inline` int(11) NOT NULL default '0',
  `utv_inline` int(11) NOT NULL default '0',
  `email` varchar(30) default NULL,
  `mobil` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.SpillereInline
*/

INSERT INTO `SpillereInline` VALUES 
(6,'Anders Geithung','F','anders.jpg',1,1,11,2,0,0,'','900 900 55'),
(5,'Rune Syversen','K','rune_syv.jpg',1,1,13,2,0,0,'rsyversen@mil.no','934 83 182'),
(4,'Bj�rn Haakenstad','A',NULL,1,1,10,11,0,0,'bjorn@haakenstad.com','900 900 35'),
(9,'Terje Gulbrandsen','A',NULL,0,1,3,0,0,0,'terje.g@chello.no','915 98 435'),
(10,'Andr� Halvorsen','A',NULL,1,1,8,2,0,0,'',''),
(11,'Per Martin Hansen','F','martin.jpg',1,1,3,0,0,0,'','922 44 081'),
(13,'Terje Heide','A',NULL,0,1,0,0,0,0,'terje.heide@sentrum.toyota.no','996 35 833'),
(15,'Arnfinn Hoff','F','arnfinn.jpg',1,1,12,2,0,0,'',''),
(16,'Rune Ilseng','A','illseng.jpg',1,1,4,0,0,0,'','902 07 905'),
(22,'Ronny Pedersen','F','ronny.jpg',1,1,8,0,0,0,'','920 62 977'),
(25,'David Walle-Olsen','A',NULL,1,1,7,2,0,0,'','');

/*
Table structure for SpillereOldBoys
*/

drop table if exists `SpillereOldBoys`;
CREATE TABLE `SpillereOldBoys` (
  `id` int(11) NOT NULL auto_increment,
  `navn` varchar(30) NOT NULL default '',
  `posisjon` char(3) default NULL,
  `bilde` varchar(40) default NULL,
  `inline` int(1) NOT NULL default '0',
  `hockey` int(1) NOT NULL default '1',
  `kamper_hockey` int(11) NOT NULL default '0',
  `utv_hockey` int(11) NOT NULL default '0',
  `kamper_inline` int(11) NOT NULL default '0',
  `utv_inline` int(11) NOT NULL default '0',
  `email` varchar(30) default NULL,
  `mobil` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.SpillereOldBoys
*/

INSERT INTO `SpillereOldBoys` VALUES 
(6,'Eddie Eriksen','F','gammel_astrix_fjes.jpg',0,1,0,0,0,0,'','92625125'),
(5,'�ystein Hansen','F',NULL,0,1,0,0,0,0,'','92625204'),
(4,'Rune Syversen','K',NULL,0,1,8,0,0,0,'','93-06-89-63.'),
(7,'Willy Larsen','A',NULL,0,1,2,0,0,0,'','92-66-68-02.'),
(25,'Arnfinn Hoff','A',NULL,0,1,8,0,0,0,'','48273706'),
(9,'Terje Heide','A',NULL,0,1,7,0,0,0,'','99-63-58-33.'),
(10,'Morten Andresen','A',NULL,0,1,4,0,0,0,'','47311433'),
(24,'Knut Pedersen','F',NULL,0,1,6,0,0,0,'','90599279'),
(12,'Tom Bendixen','A',NULL,0,1,1,0,0,0,'','91595970'),
(13,'Terje Gulbrandsen','A',NULL,0,1,9,0,0,0,'','91-59-84-35.'),
(23,'Tom Eddy Harms','A',NULL,0,1,7,0,0,0,'','91819138'),
(16,'Per Martin Hansen','F',NULL,0,1,1,0,0,0,'','92-24-40-81.'),
(17,'Roar Kjus','A',NULL,0,1,0,0,0,0,'','90-20-99-72.'),
(19,'Jan Korslund','F',NULL,0,1,0,0,0,0,'','95067464'),
(26,'Andre Halvorsen','A',NULL,0,1,3,0,0,0,'','91778191'),
(21,'Ingar Andersen','A','senilix.jpg',0,1,0,0,0,0,'','92834544'),
(22,'Arild Gr�nnerud','F','gammel_astrix.JPG',0,1,8,0,0,0,'','91625339'),
(27,'B�rd R�sn�s','A',NULL,0,1,6,0,0,0,'','92054735'),
(28,'Mika Kolari','A',NULL,0,1,3,0,0,0,'','');

/*
Table structure for temp1024171
*/

drop table if exists `temp1024171`;
CREATE TABLE `temp1024171` (
  `id` int(11) default NULL,
  `navn` varchar(30) default NULL,
  `kamper` int(11) default NULL,
  `m�l` int(11) default NULL,
  `pass` int(11) default NULL,
  `utvisningMin` int(11) default NULL
) TYPE=MyISAM;

/*
Table structure for temp1047719
*/

drop table if exists `temp1047719`;
CREATE TABLE `temp1047719` (
  `id` int(11) default NULL,
  `navn` varchar(30) default NULL,
  `kamper` int(11) default NULL,
  `m�l` int(11) default NULL,
  `pass` int(11) default NULL,
  `utvisningMin` int(11) default NULL
) TYPE=MyISAM;

