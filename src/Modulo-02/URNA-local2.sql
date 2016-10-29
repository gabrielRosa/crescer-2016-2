

CREATE TABLE Candidato
  (
    IDCandidato    INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (100) NOT NULL ,
    NomePopular    VARCHAR2 (200) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    RegistroTRE    VARCHAR2 (50) NOT NULL ,
    Partido        VARCHAR2 (100) NOT NULL ,
    Foto           VARCHAR2 (250) NOT NULL ,
    NumeroEscolha  VARCHAR2 (7) NOT NULL ,
    TipoCargo      VARCHAR2 (100) NOT NULL ,
    Cidade         INTEGER NOT NULL
  ) ;
ALTER TABLE Candidato ADD CONSTRAINT Candidatos_PK PRIMARY KEY ( IDCandidato ) ;
ALTER TABLE Candidato ADD CONSTRAINT Candidatos__UN UNIQUE ( RegistroTRE ) ;


CREATE TABLE Cidade
  (
    IDCidade INTEGER NOT NULL ,
    Nome     VARCHAR2 (200) NOT NULL ,
    IDUF     INTEGER NOT NULL
  ) ;
ALTER TABLE Cidade ADD CONSTRAINT Cidade_PK PRIMARY KEY ( IDCidade ) ;


CREATE TABLE Eleitor
  (
    IDEleitor      INTEGER NOT NULL ,
    NomeCompleto   VARCHAR2 (100) NOT NULL ,
    TituloEleitor  VARCHAR2 (20) NOT NULL ,
    RG             VARCHAR2 (15) NOT NULL ,
    DataNascimento DATE NOT NULL ,
    Zona           VARCHAR2 (3) NOT NULL ,
    Secao          VARCHAR2 (5) NOT NULL ,
    Situacao       VARCHAR2 (1) NOT NULL
  ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor_PK PRIMARY KEY ( IDEleitor ) ;
ALTER TABLE Eleitor ADD CONSTRAINT Eleitor__UN UNIQUE ( TituloEleitor , RG ) ;


CREATE TABLE UF
  (
    IDUF  INTEGER NOT NULL ,
    Sigla VARCHAR2 (2) NOT NULL ,
    Nome  VARCHAR2 (30) NOT NULL
  ) ;
ALTER TABLE UF ADD CONSTRAINT UF_PK PRIMARY KEY ( IDUF ) ;
ALTER TABLE UF ADD CONSTRAINT UF__UN UNIQUE ( Sigla ) ;


CREATE TABLE Votocao
  (
    IDVoto       INTEGER NOT NULL ,
    FK_Candidato INTEGER NOT NULL ,
    Branco       VARCHAR2 (1) NOT NULL
  ) ;
ALTER TABLE Votocao ADD CONSTRAINT TABLE_6_PK PRIMARY KEY ( IDVoto ) ;


ALTER TABLE Votocao ADD CONSTRAINT FK_Candidato FOREIGN KEY ( FK_Candidato ) REFERENCES Candidato ( IDCandidato ) ;

ALTER TABLE Candidato ADD CONSTRAINT FK_Cidade FOREIGN KEY ( Cidade ) REFERENCES Cidade ( IDCidade ) ;

ALTER TABLE Cidade ADD CONSTRAINT FK_IDUF FOREIGN KEY ( IDUF ) REFERENCES UF ( IDUF ) ;


