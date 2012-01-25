ok-->ALTER TABLE SPILLER DROP COLUMN "BILDE" ;

ok-->ALTER TABLE "ROSENHOFF"."PUBLIC"."SPILLER" ADD "IMAGE_EXTENSION" varchar(6) NULL ;


CREATE TABLE "PUBLIC"."POLL"
(
   ID integer PRIMARY KEY NOT NULL,
   AKTIVITET_ID integer NOT NULL,
   LABEL varchar(10) DEFAULT 'TEST',
   SPILLER_ID integer NOT NULL,
   KOMMER boolean NOT NULL
)
;
ALTER TABLE "PUBLIC"."POLL"
ADD CONSTRAINT FK_POLL_AKTIVITET
FOREIGN KEY (AKTIVITET_ID)
REFERENCES "PUBLIC"."AKTIVITET"(AKTIVITET_ID)
;
;
CREATE INDEX FK_POLL_AKTIVITET_INDEX_2 ON "PUBLIC"."POLL"(AKTIVITET_ID)
;
CREATE UNIQUE INDEX PRIMARY_KEY_B8 ON "PUBLIC"."POLL"(ID)
;



ALTER TABLE "ROSENHOFF"."PUBLIC"."POLL" ADD "KOMMER" boolean NOT NULL ;
