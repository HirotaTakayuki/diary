create table booksinfo (
      id   INT         AUTO_INCREMENT NOT NULL
    , title VARCHAR(50) NOT NULL
    , price   INT      NOT NULL
    , dt   DATETIME    DEFAULT CURRENT_TIMESTAMP
    , PRIMARY KEY (id)
)
;
