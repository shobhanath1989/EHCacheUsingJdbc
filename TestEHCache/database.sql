-- Table: news

-- DROP TABLE news;

CREATE TABLE news
(
  id integer,
  newsheading character varying(55),
  newsbody character varying(55)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE news
  OWNER TO postgres;
GRANT ALL ON TABLE news TO postgres;
GRANT ALL ON TABLE news TO mytest;

INSERT INTO news(
            id, newsheading, newsbody)
    VALUES (?, ?, ?);