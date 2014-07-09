-- DROP SEQUENCE requestlogidseq;
CREATE SEQUENCE requestlogidseq INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999 START 1;

-- DROP TABLE requestlog;
CREATE TABLE requestlog (
       requestid NUMERIC(12) DEFAULT nextval('requestlogidseq'::text) NOT NULL
     , token NUMERIC(12)
     , createdtime TIMESTAMP DEFAULT now()
     , request VARCHAR(255)
     , status VARCHAR(255)
     , requesturl VARCHAR(1000)
     , requestvalues TEXT
     , results TEXT
);

ALTER TABLE requestlog
  ADD CONSTRAINT PK_REQUEST
      PRIMARY KEY (requestid);

ALTER TABLE requestlog
  ADD CONSTRAINT FK_survey FOREIGN KEY (token)
      REFERENCES token (tokenid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
