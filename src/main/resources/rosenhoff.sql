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
Table structure for Bilde
*/

drop table if exists `Bilde`;
CREATE TABLE `Bilde` (
  `id` int(3) NOT NULL auto_increment,
  `bilde` longblob NOT NULL,
  `bildetekst` varchar(100) default NULL,
  `katalog` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;

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

