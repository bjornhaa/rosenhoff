/* 
SQLyog v4.02
Host - 10.0.0.11 : Database - Rosenhoff_hockey
**************************************************************
Server version 4.0.18
*/

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
);

/*
Table data for Rosenhoff_hockey.Aktivitet
*/

INSERT INTO `Aktivitet` VALUES 
(1,'2007-09-13 21:00:00','trening','L�renhallen','22:00:00'),
(2,'2007-09-20 21:00:00','Trening','L�renhallen','22:00:00'),
(3,'2007-10-01 21:00:00','Trening','L�renhallen','22:00:00'),
(4,'2007-10-10 21:00:00','Trening','L�renhallen','22:00:00'),
(5,'2007-10-19 21:00:00','Trening','L�renhallen','22:00:00'),
(6,'2007-10-22 20:45:00','Treningskamp LSI 2','Skedsmo Ishall','21:00:00'),
(7,'2007-10-26 21:00:00','Trening','L�renhallen','22:00:00'),
(8,'2007-11-04 17:00:00','RIL - Skedsmo 2','L�renhallen','18:30:00'),
(9,'2007-11-16 21:00:00','RIL - Aker','L�renhallen','22:30:00'),
(10,'2007-11-19 20:00:00','Rasta 2 - RIL','L�renskog ishall','21:30:00'),
(11,'2007-12-02 17:00:00','RIL - Jordal','L�renhallen','18:30:00'),
(12,'2007-12-08 15:00:00','Skedsmo 2 - RIL','Skedsmo Ishall','16:30:00'),
(13,'2007-12-17 20:00:00','Jar - RIL(Jarbanen)','L�renhallen','21:30:00'),
(14,'2008-01-04 21:00:00','RIL - Jar','L�renhallen','22:30:00'),
(15,'2008-01-11 21:00:00','Aker - RIL','L�renhallen','22:30:00'),
(16,'2008-01-20 17:00:00','RIL - Rasta 2','L�renhallen','18:30:00'),
(17,'2008-01-24 21:15:00','Jordal - RIL','Jordal','22:45:00'),
(18,'2008-02-03 17:00:00','RIL - Skedsmo 2','L�renhallen','18:30:00'),
(19,'2008-02-11 20:00:00','Jar - RIL(Jarbanen)','L�renhallen','21:30:00'),
(20,'2008-02-17 17:00:00','RIL - Aker','L�renhallen','18:30:00'),
(21,'2008-03-02 17:00:00','Rasta 2 - RIL','L�renskog ishall','18:30:00'),
(22,'2008-03-08 10:00:00','RIL - Jordal','L�renhallen','11:30:00'),
(23,'2007-10-31 21:00:00','Trening','L�renhallen','22:00:00');

/*
Table structure for Bruker
*/

drop table if exists `Bruker`;
CREATE TABLE `Bruker` (
  `id` int(11) NOT NULL default '0',
  `brukerNavn` varchar(15) NOT NULL default '',
  `passord` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ;

/*
Table data for Rosenhoff_hockey.Bruker
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
) ;

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
) ;

/*
Table data for Rosenhoff_hockey.Nyhet
*/

INSERT INTO `Nyhet` VALUES 
(18,'<p>SERIEMESTERE SESONGEN 2006/2007</p><p>Etter � ha tapt seriemesterskapet i fjor p� innbyrdes oppgj�r, var det etter 5-2 seier over M�lla i siste seriekamp spesielt tilfredsstillende � kunne g� av banen som seriemestere sesongen 06/07. Frav�ret av v�r storscorer Pekka Koivisto var merkbart, og det var ikke f�r i 3.periode at vi avgjorde det hele til v�r fordel mot et M�lla som gjorde alt i sin makt for � forhindre at seriemesterskapet havnet hos laget fra omr�det mellom Trondheimsveien og Torshovdalen. Tusen takk til samtlige for en str�lende sesong. Spesielt takk til v�re�utmerkede Finner som har v�rt sterkt delaktige i at vi kan krone oss med tittelen \"Seriemestre 06/07\".</p><p>RS</p><p></p>','J','2007-03-08 08:09:59'),
(23,'<p>GRATULERER�!</p><p>Rune (Olsen) har blitt pappa til ei lita jente. Rosenhoff gratulerer !!!!</p>','J','2007-05-31 11:23:22');

/*
Table structure for Poeng
*/

drop table if exists `Poeng`;
CREATE TABLE `Poeng` (
  `id` int(11) NOT NULL auto_increment,
  `spiller` int(11) NOT NULL default '0',
  `erPass` int(1) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ;

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
) ;

/*
Table data for Rosenhoff_hockey.Rapport
*/

INSERT INTO `Rapport` VALUES 
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
Table structure for Spiller
*/

drop table if exists `Spiller`;
CREATE TABLE `Spiller` (
  `id` int(11) NOT NULL auto_increment,
  `navn` varchar(30) NOT NULL default '',
  `posisjon` char(3) default NULL,
  `bilde` longblob,
  `kamper` int(11) NOT NULL default '0',
  `utv` int(11) NOT NULL default '0',
  `email` varchar(30) default NULL,
  `mobil` varchar(15) default NULL,
  PRIMARY KEY  (`id`)
) ;

/*
Table data for Rosenhoff_hockey.Spiller
*/


