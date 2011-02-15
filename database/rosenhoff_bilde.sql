use `Rosenhoff_hockey`;

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

