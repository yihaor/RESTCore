-- DROP SEQUENCE tokenidseq;
CREATE SEQUENCE tokenidseq INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999 START 1;

-- DROP TABLE token;
CREATE TABLE token (
       tokenid NUMERIC(12) DEFAULT nextval('tokenidseq'::text) NOT NULL
     , token VARCHAR(255)
     , suite VARCHAR(255)
     , createdtime TIMESTAMP DEFAULT now()
     , expirytime TIMESTAMP
     , status character varying(1)
);

ALTER TABLE token
  ADD CONSTRAINT PK_TOKEN
      PRIMARY KEY (tokenid);


