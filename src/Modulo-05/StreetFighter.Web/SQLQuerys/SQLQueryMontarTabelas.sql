Create Table Personagens(
	IDPersonagem int not null identity,
	Nome varchar(100) not null,
	Imagem varchar(200) not null,
	Nascimento DateTime not null,
	Altura int not null,
	Peso decimal not null,
	AbreviacaoPais varchar(3) not null,
	GolpesEspeciais varchar(300) not null,
	PersonagemOculto bit not null,
	
	constraint PK_IDPersonagem primary key(IDPersonagem)
);

Create Table Usuarios(
	IDUsuario int not null identity,
	Nome varchar(100) not null,
	Senha varchar(256) not null,

	constraint PK_IDUsuario primary key(IDUsuario)
);