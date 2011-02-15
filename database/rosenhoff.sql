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
  `når` datetime NOT NULL default '0000-00-00 00:00:00',
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
(81,'2005-10-12 21:00:00','Trening','Lørenhallen','22:00:00',0),
(63,'2005-09-24 13:30:00','Trening','Lørenhallen','14:45:00',0),
(64,'2005-11-04 20:15:00','Mølla-RIL','Grünerhallen','21:45:00',0),
(65,'2005-11-11 21:15:00','RIL-Forward','Lørenhallen','22:45:00',0),
(66,'2005-11-17 19:15:00','Gamle Oslo-RIL','Grünerhallen','20:45:00',0),
(67,'2005-11-25 19:30:00','RIL-Tjernet','Lørenhallen','21:00:00',0),
(68,'2005-12-11 17:00:00','Ringerike2- RIL','Sjongshallen','18:30:00',0),
(69,'2006-01-13 19:30:00','RIL-Rasta2','Lørenhallen','21:00:00',0),
(70,'2006-01-20 21:15:00','RIL-Mølla','Lørenhallen','22:45:00',0),
(71,'2006-01-29 18:15:00','Forward-RIL','Jordal Amfi','19:45:00',0),
(72,'2006-02-03 21:15:00','RIL-Gamle Oslo','Lørenhallen','22:45:00',0),
(73,'2006-02-07 19:30:00','Tjernet-RIL','Grünerhallen','21:00:00',0),
(74,'2006-03-01 20:15:00','RIL-Ringerike2','Lørenhallen','21:45:00',0),
(75,'2006-03-10 20:30:00','Rasta2-RIL','Lørenskog','22:00:00',0),
(80,'2005-10-05 21:00:00','Trening','Lørenhallen','22:00:00',0),
(77,'2005-09-28 21:00:00','Trening','Lørenhallen','22:00:00',0),
(82,'2005-10-21 21:00:00','Trening','Lørenhallen','22:00:00',0),
(83,'2005-10-30 17:45:00','Trening','Lørenhallen','18:45:00',0),
(84,'2005-11-07 21:00:00','Trening','Lørenhallen','22:00:00',0),
(85,'2005-11-16 21:00:00','Trening','Lørenhallen','21:45:00',0),
(89,'2005-12-10 17:00:00','Trening','Lørenhallen','18:00:00',0),
(88,'2005-11-28 21:00:00','Trening','Lørenhallen','22:00:00',0),
(90,'2005-12-14 21:00:00','Trening','Lørenhallen','22:00:00',0),
(93,'2006-01-04 21:00:00','Trening','Lørenhallen','22:00:00',0),
(92,'2005-12-21 21:00:00','Trening (med Aker)','Lørenhallen','22:00:00',0),
(94,'2006-01-14 14:30:00','Trening','Lørenhallen','15:30:00',0),
(95,'2006-01-16 21:00:00','Trening','Lørenhallen','22:00:00',0),
(96,'2006-01-23 21:00:00','Trening','Lørenhallen','22:00:00',0),
(97,'2006-01-30 21:00:00','Trening','Lørenhallen','22:00:00',0),
(98,'2006-02-09 19:30:00','Trening','Lørenhallen','20:45:00',0),
(99,'2006-02-13 20:45:00','Trening','Lørenhallen','22:00:00',0),
(100,'2006-02-20 21:15:00','Trening','Lørenhallen','22:00:00',0),
(101,'2006-02-27 21:00:00','Trening','Lørenhallen','22:00:00',0),
(102,'2006-03-05 16:00:00','Trening','Lørenhallen','17:00:00',0),
(103,'2006-03-06 21:15:00','Trening(21:10)','Lørenhallen','22:00:00',0),
(104,'2006-03-13 21:00:00','Trening','Lørenhallen','22:00:00',0),
(105,'2006-04-11 17:00:00','test','test','17:00:00',0);

/*
Table structure for AktivitetInline
*/

drop table if exists `AktivitetInline`;
CREATE TABLE `AktivitetInline` (
  `id` int(11) NOT NULL auto_increment,
  `når` datetime NOT NULL default '0000-00-00 00:00:00',
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
(1,'2006-04-26 20:00:00','Vika Vipers - Blunders 2','Grünerhallen','21:00:00',0),
(2,'2006-05-04 19:00:00','Oslo Stars - Blunders 2','Grünerhallen','20:00:00',0),
(3,'2006-05-09 19:00:00','Blunders 2 - Thunderboys','Grünerhallen','20:00:00',0),
(4,'2006-05-10 20:00:00','Mølla - Blunders 2','Grünerhallen','21:00:00',0),
(5,'2006-05-11 18:00:00','Blunders 2- Munin','Grünerhallen','19:00:00',0),
(6,'2006-08-14 20:00:00','Snipers-Blunders 2','Grünerhallen','21:00:00',0),
(7,'2006-08-15 18:00:00','Blunders 2- Eastenders','Grünerhallen','19:00:00',0),
(8,'2006-08-17 19:00:00','Grüner-Blunders 2','Grünerhallen','20:00:00',0),
(9,'2006-08-21 19:00:00','Blunders 2- Wheelfighters','Grünerhallen','20:00:00',0),
(10,'2006-08-23 19:00:00','Blunders 2-Vika Vipers','Grünerhallen','20:00:00',0),
(11,'2006-08-17 21:00:00','Eastenders-Blunders 2','Grünerhallen','22:00:00',0),
(12,'2006-08-22 20:00:00','Blunders 2-Snipers','Grünerhallen','21:00:00',0);

/*
Table structure for AktivitetOldBoys
*/

drop table if exists `AktivitetOldBoys`;
CREATE TABLE `AktivitetOldBoys` (
  `id` int(11) NOT NULL auto_increment,
  `når` datetime NOT NULL default '0000-00-00 00:00:00',
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
(32,'2005-12-18 20:45:00','RIL Boys-L.seter 2','Grünerhallen','22:00:00',0),
(30,'2005-12-05 21:15:00','Furuset-RIL Boys','Lørenhallen','22:30:00',0),
(29,'2005-12-04 19:30:00','RIL Boys-L.skog2','Grünerhallen','20:45:00',0),
(28,'2005-11-20 20:45:00','RIL Boys-Oilers','Grünerhallen','22:00:00',0),
(27,'2005-11-08 22:00:00','Progress-RIL Boys','Lørenhallen','23:15:00',0),
(26,'2005-10-30 20:45:00','RIL Boys-SkiFarmers','Grünerhallen','22:00:00',0),
(25,'2005-10-18 20:45:00','Jutul-RIL-Boys','Bærum','22:00:00',0),
(24,'2005-10-16 19:30:00','RIL Boys-GamleOslo','Grünerhallen','20:45:00',0),
(23,'2005-10-09 19:30:00','Grüner-RIL Boys','Grünerhallen','20:45:00',0),
(42,'2006-01-25 22:00:00','RIL BOYS  -  JUTUL','Grunerhallen','23:15:00',0),
(44,'2006-01-30 21:30:00','SKI FARMERS - RIL BOYS','Ski Ishall','22:45:00',0),
(45,'2006-02-14 22:00:00','RIL BOYS - LØRENSKOG','Grünerhallen','23:15:00',0),
(46,'2006-03-14 22:00:00','PROGRESS  -  RIL BOYS','Lørenhallen','23:15:00',0),
(47,'2006-02-28 21:00:00','SKEDSMO - RIL BOYS','Skedsmo ishall','22:15:00',0),
(48,'2006-03-07 22:00:00','RIL BOYS - OSLO OILERS','Grünerhallen','23:15:00',0);

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
  `mål_scoret` int(11) NOT NULL default '0',
  `mål_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampHockey
*/

INSERT INTO `KampHockey` VALUES 
(33,'Mølla','2005-11-04','Borte',7,2,NULL,0),
(34,'Forward','2005-11-11','Hjemme',6,3,NULL,0),
(35,'Gamle Oslo','2005-11-17','Borte',8,3,NULL,0),
(36,'Tjernet','2005-11-25','Hjemme',6,3,NULL,0),
(37,'Ringerike 2','2005-12-11','Borte',6,4,NULL,0),
(38,'Rasta 2','2006-01-13','Hjemme',16,3,NULL,0),
(39,'Mølla','2006-01-20','Hjemme',15,1,NULL,0),
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
  `mål_scoret` int(11) NOT NULL default '0',
  `mål_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampInline
*/

INSERT INTO `KampInline` VALUES 
(2,'Mølla','2006-04-04','Hjemme',0,7,NULL,0),
(3,'Munin','2006-04-05','Borte',5,0,NULL,0),
(4,'Grüner','2006-04-06','Hjemme',2,19,NULL,0),
(5,'Oslo Stars','2006-04-18','Hjemme',1,12,NULL,0),
(6,'Wheelfighters','2006-04-19','Borte',5,3,NULL,0),
(7,'Vika Vipers','2006-04-26','Borte',6,4,NULL,0),
(8,'Oslo Stars','2006-05-04','Borte',2,12,NULL,0),
(9,'Thunderboys','2006-05-09','Hjemme',9,2,NULL,0),
(10,'Mølla','2006-05-10','Borte',1,7,NULL,0),
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
  `mål_scoret` int(11) NOT NULL default '0',
  `mål_sluppet_inn` int(11) NOT NULL default '0',
  `beskrivelse` varchar(200) default NULL,
  `inline` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

/*
Table data for Rosenhoff.KampOldBoys
*/

INSERT INTO `KampOldBoys` VALUES 
(15,'Jutul','2005-10-18','Hjemme',3,7,NULL,0),
(13,'Grüner','2005-10-09','Hjemme',3,6,NULL,0),
(14,'Gamle Oslo','2005-10-16','Hjemme',4,7,NULL,0),
(17,'Ski Farmers','2005-10-30','Hjemme',3,3,NULL,0),
(19,'Progress','2005-11-08','Borte',4,4,NULL,0),
(20,'Oslo Oilers','2005-11-20','Hjemme',4,3,NULL,0),
(21,'Jutul','2006-01-25','Hjemme',0,3,NULL,0),
(22,'Ski Farmers','2006-01-30','Hjemme',6,2,NULL,0),
(23,'Lørenskog','2006-02-14','Hjemme',2,2,NULL,0),
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
(1,33,'Første seriekamp','Matchen bar preg av at vi ikke hadde fått tid til å samspille oss med våre nyervervelser fra Finland. Gutta fra \"de tusen sjøars land\" var også litt rustne og bar preg av at de ikke hadde spilt på en stund.Alt i alt en grei gjennomkjøring.'),
(2,34,'Kontrollerte inn seieren','Rosenhoff kontrollerte inn seieren mot et Forward lag som for anledningen var forsterket med tidligere Rosenhoff spiller gjennom mange år - Tom Eddy Harms som også scorer sitt første mål for sin nye klubb.\r\nForward hang godt med, men vår utmerkede Finske rekke avgjorde kampen nærmest på egen hånd med fire scorede mål. Morsomt å se at Forwards målvakt; Trond Ofte på snart 50 år fortsatt holder koken.'),
(3,37,'Sterk motstand','Ringerike overrasket med agressiv forechecking, bra bevegelse og stor innsatsvilje. Vi hadde vel her trodd at dette skulle bli plankekjøring basert på Ringerikes tidligere resultater i inneværende sesong. Selv om vi egentlig aldri følte oss sterkt truet hang Ringerike med helt til \"the bitter end\", og scorer sitt fjerde mål bare 2 sekunder før kampslutt. Pekka Koivisto scorer 3 av Rosenhoffs mål og er kampens frontfigur. David \"Krøvel Welle Walle\" Olsen får endelig hull på byllen og scorer sitt første mål i organisert seriespill. Gratulerer \"Krøvel\".Hornfinn scorer Rosenhoffs første mål etter et steinhardt slagskudd hvor keeperen til Ringerike fortsatt lurer på hvor spaken hans ble av. Det går rykter på Hønefoss at han brukte hele romjula på å lete. Uten resultat. Bjørn Humba Haakenstad kommer sterkt tilbake etter innledningsvis å ha vært kraftig preget av lørdagens julebord. Etter å ha kvittet seg med overflødig ribbe og akevitt kvikner han sakte men sikkert til live og lager Rosenhoffs femte mål med assistanse fra nyervervelsen Lars Ottar Kvåle fra NTNUI FLYERS.'),
(4,36,'Slår regjerende mestere','\"Bøffelhockey\" er et uttrykk som hjemmesidene til Rosenhoff lanserte for noen tid tilbake som en beskrivelse av Tjernets spillestil. Kjenntegnes av tackling av spiller som har spilt fra seg pucken for en peiode siden. Rosenhoff ledet komfortabelt 4-1 fram til 5 minutter spilt av andre periode og hadde vel egentlig ikke vært vitne til noe særlig \"bøfflete\" spill fra Tjernets side så langt. Etter dette iverksatte Tjernet sin mere kjente spillemåte - tok oss alvorlig på senga og reduserte til 4-3 ila 4 minutter. RIL greide imidlertid å ta seg kraftig sammen parallellt med at \"bøfflingen\" økte i intensitet. Øket \"Bøffling\" kan ofte føre til at fokuset utelukkende konsentreres rundt det å tackle og ikke noe særlig på spillet og pucken som sådann. Fører også vanligvis til flere minutter i utvisningsboksen. Mens Tjernet satt i fryseboksen i 12 minutter i tredje periode kunne Rosenhoff komfortabelt øke til både 5 og 6-3. Tjernets mannsterke støtteapparat mante sine spillere til ytterligere \"Bøffling\" og kjeftet sammenhengende på de udugelige dommerne uten at dette hadde nevneverdig positiv innflytelse på kampresultatet. Dette var en match hvor våre venner fra Finland tok ut hele sitt potensiale og stod for 5  av 6 mål. Tidligere Tjernet spiller; Kim Rustad sørget for Rosenhoff fjerde mål.'),
(5,35,'Finnene \"ruler\"','Denne kampen er det vel egentlig ikke så mye å skrive om bortsett fra at Rosenhoff kontrollerte stort sett hele veien. Gamle Oslo scorer riktignok det første målet, men greier ikke helt å holde følge med farten til Rosenhoffs \"importrekke\". Finnene scorer 7 av 8 mål. 6 av disse besørges av vår eminente nr. 17; Juhani Kaltakari. Bjørn \"Humba\" Haakenstad bryter Finnenes scoringsrekke med et lett blafrende håndleddsskudd som daler og lurer seg inn mellom leggskinna til en udekket Gamle-Oslo keeper.'),
(6,38,'Masse scoringer','Et Rosenhoff som hadde lært å ikke undervurdere motstanderen utfra plassering på tabellen - kjørte over et Rasta 2 som ikke holdt følge tempomessig.En del forfall til denne kampen åpnet for et midlertidig \"comeback\" fra Terje G. som greide seg utmerket selv om han hadde glemt at det var lov å tackle. Det mest spektakulære forfallet til denne kanpen var Bjørn Humba Haakenstad som av Uranienborg sosialkontor hadde fått innvilget en ukes opphold ved et Belgisk kurbad for å restituere seg etter en intensiv julebord -periode. Ilka Moilanen er kampens frontfigur med 6 scoringer og 3 pass. Anders Geithung utmerker seg også i denne kampen med 3 fine scoringer.'),
(7,39,'Fortsetter å vinne stort','Mølla ble et nummer for lite og sifrene fra første seriekamp ble mer enn dobla. Vår finske importrekke står for 10 av 15 mål. Spesielt samspillet mellom Ilka og Juhani imponerte tidvis stort i denne kampen. Humba Haakenstad var tilbake etter sitt kurbadopphold i Belgia, hvor det ble konkludert med at han hadde forspist seg på medisterkaker.\r\nDette var en kamp hvor Rosenhoffs keeper Rune Syversen lenge hadde mulighetene til å holde nullen for første gang siden lilleputtlaget til Rosenhoff seiret 1-0 over Kampørn på Dælenenga en januardag i 1971. Anders Geithung hadde frem til den fatale feilvurderingen som sørget for Mølla sitt mål, spilt en upåklagelig kamp. Herr Geithung styrer en helt ufarlig puck med kølleskaftet i bue over Rosenhoff-keeperen og rett i mål. Rosenhoffs formann, Tor Olsen, er kalt inn fra pensjonistferie i Spania for å ta stilling til en evt. utestengelse av herr Geithung for resten av sesongen.'),
(8,40,'Fortsatt ubeseiret','Denne kampen satt trolig rekord i sammenlagt alder på keepere i ordinært seriespill. Nærmere 100 år.Trond Ofte reddet Forward fra to-sifra tap etter en god kamp mellom stengene. Den \"gamle\" keeperveteranen med bakgrunn fra Rosenhoff, hadde flere kvalifiserte redninger. 5 av Rosenhoffs 7 mål ble scoret av vår eminente Finske - rekke. Rosenhoff førte kampen, men Forward greide tidvis å nøytralisere våre beste spillere gjennom tett markering og god bevegelighet. \"Humba\" Haakenstad spilte heller ikke i denne kampen opp mot sitt beste. Det mistenkes at Rødtvedt gutten med Vestkantambisjoner fører et for tiden hektisk uteliv. Observert sist lørdag på Lipp sammen med Petter Stordalen og Celina Middelfart.\r\nRosenhoffs beste spiller denne kampen var Tuomas. Tom Eddy Harms, tidligere Rosenhoff spiller, også kalt \"femtekolonisten\"  scorer Forward sitt tredje mål etter utallige forsøk på å overliste Rosenhoffs old boys keeper.'),
(9,40,'r','s'),
(10,41,'Nok en overlegen seier','Gamle Oslo holdt følge i 1 periode, så var det slutt. Perioderesultatene 2-2,5-1 og 5-1 forteller det meste. Våre briljante Finner scorer 8 av 12 mål. Det peneste målet ble scoret av Pekka som fyrer av et slagskudd rett innenfor blå opp i krysset til høyre for Gamle Oslo sin keeper.\r\nEllers så tegner både Jon, Lars Ottar, Kim og Bjørn seg for en scoring hver.Bjørn ser ut til å ha senket vestkantambisjonene sine en smule da han etter kampen skulle drikke øl og spille helsetrøye-poker med Bård og Anders. Vi ser fram til neste kamp mot Tjernet da seriemesterskapet i realiteten kan avgjøres.');

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
(1,1,'Rævkjørt','I denne kampen ble vi rævkjørt etter alle kunstens regler. Selv på 13-1 til Grüner så jobber alle grüner-schwina hjem som om det skulle stått om OL-plass. Nei fy faan, så spreke folk vil vi ha oss frabedt i vår divisjon');

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
(4,'Bjørn Haakenstad','A',NULL,1,1,8,11,0,0,'bjorn@haakenstad.com','900 900 35'),
(7,'Henrik Wilenius','A',NULL,0,1,9,0,0,0,'',''),
(8,'Arild Grønnerud','F',NULL,0,1,2,0,0,0,'','916 25 339'),
(9,'Terje Gulbrandsen','A',NULL,0,1,1,0,0,0,'terje.g@chello.no','915 98 435'),
(10,'Andrè Halvorsen','A',NULL,1,1,4,2,0,0,'',''),
(11,'Per Martin Hansen','F','martin.jpg',1,1,0,0,0,0,'','922 44 081'),
(26,'Kim Rustad','F',NULL,0,1,6,2,0,0,'',''),
(13,'Terje Heide','A',NULL,0,1,0,0,0,0,'terje.heide@sentrum.toyota.no','996 35 833'),
(27,'Lars Ottar Kvåle','A',NULL,0,1,6,2,0,0,'',''),
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
(31,'Bård Røsnæs','A',NULL,0,1,3,0,0,0,'','');

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
(4,'Bjørn Haakenstad','A',NULL,1,1,10,11,0,0,'bjorn@haakenstad.com','900 900 35'),
(9,'Terje Gulbrandsen','A',NULL,0,1,3,0,0,0,'terje.g@chello.no','915 98 435'),
(10,'Andrè Halvorsen','A',NULL,1,1,8,2,0,0,'',''),
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
(5,'Øystein Hansen','F',NULL,0,1,0,0,0,0,'','92625204'),
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
(22,'Arild Grønnerud','F','gammel_astrix.JPG',0,1,8,0,0,0,'','91625339'),
(27,'Bård Røsnæs','A',NULL,0,1,6,0,0,0,'','92054735'),
(28,'Mika Kolari','A',NULL,0,1,3,0,0,0,'','');

/*
Table structure for temp1024171
*/

drop table if exists `temp1024171`;
CREATE TABLE `temp1024171` (
  `id` int(11) default NULL,
  `navn` varchar(30) default NULL,
  `kamper` int(11) default NULL,
  `mål` int(11) default NULL,
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
  `mål` int(11) default NULL,
  `pass` int(11) default NULL,
  `utvisningMin` int(11) default NULL
) TYPE=MyISAM;

