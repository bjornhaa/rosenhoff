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
(1,'2007-09-13 21:00:00','trening','Lørenhallen','22:00:00'),
(2,'2007-09-20 21:00:00','Trening','Lørenhallen','22:00:00'),
(3,'2007-10-01 21:00:00','Trening','Lørenhallen','22:00:00'),
(4,'2007-10-10 21:00:00','Trening','Lørenhallen','22:00:00'),
(5,'2007-10-19 21:00:00','Trening','Lørenhallen','22:00:00'),
(6,'2007-10-22 20:45:00','Treningskamp LSI 2','Skedsmo Ishall','21:00:00'),
(7,'2007-10-26 21:00:00','Trening','Lørenhallen','22:00:00'),
(8,'2007-11-04 17:00:00','RIL - Skedsmo 2','Lørenhallen','18:30:00'),
(9,'2007-11-16 21:00:00','RIL - Aker','Lørenhallen','22:30:00'),
(10,'2007-11-19 20:00:00','Rasta 2 - RIL','Lørenskog ishall','21:30:00'),
(11,'2007-12-02 17:00:00','RIL - Jordal','Lørenhallen','18:30:00'),
(12,'2007-12-08 15:00:00','Skedsmo 2 - RIL','Skedsmo Ishall','16:30:00'),
(13,'2007-12-17 20:00:00','Jar - RIL(Jarbanen)','Lørenhallen','21:30:00'),
(14,'2008-01-04 21:00:00','RIL - Jar','Lørenhallen','22:30:00'),
(15,'2008-01-11 21:00:00','Aker - RIL','Lørenhallen','22:30:00'),
(16,'2008-01-20 17:00:00','RIL - Rasta 2','Lørenhallen','18:30:00'),
(17,'2008-01-24 21:15:00','Jordal - RIL','Jordal','22:45:00'),
(18,'2008-02-03 17:00:00','RIL - Skedsmo 2','Lørenhallen','18:30:00'),
(19,'2008-02-11 20:00:00','Jar - RIL(Jarbanen)','Lørenhallen','21:30:00'),
(20,'2008-02-17 17:00:00','RIL - Aker','Lørenhallen','18:30:00'),
(21,'2008-03-02 17:00:00','Rasta 2 - RIL','Lørenskog ishall','18:30:00'),
(22,'2008-03-08 10:00:00','RIL - Jordal','Lørenhallen','11:30:00'),
(23,'2007-10-31 21:00:00','Trening','Lørenhallen','22:00:00');

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
(18,'<p>SERIEMESTERE SESONGEN 2006/2007</p><p>Etter å ha tapt seriemesterskapet i fjor på innbyrdes oppgjør, var det etter 5-2 seier over Mølla i siste seriekamp spesielt tilfredsstillende å kunne gå av banen som seriemestere sesongen 06/07. Fraværet av vår storscorer Pekka Koivisto var merkbart, og det var ikke før i 3.periode at vi avgjorde det hele til vår fordel mot et Mølla som gjorde alt i sin makt for å forhindre at seriemesterskapet havnet hos laget fra området mellom Trondheimsveien og Torshovdalen. Tusen takk til samtlige for en strålende sesong. Spesielt takk til våre utmerkede Finner som har vært sterkt delaktige i at vi kan krone oss med tittelen \"Seriemestre 06/07\".</p><p>RS</p><p></p>','J','2007-03-08 08:09:59'),
(23,'<p>GRATULERER !</p><p>Rune (Olsen) har blitt pappa til ei lita jente. Rosenhoff gratulerer !!!!</p>','J','2007-05-31 11:23:22');

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


