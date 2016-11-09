Insert into Personagens(
		Nome,
		Imagem,
		Nascimento,
		Altura,
		Peso,
		AbreviacaoPais,
		GolpesEspeciais,
		PersonagemOculto)

		values(
		'Yoga',
		'http://vignette3.wikia.nocookie.net/dcheroesrpg/images/f/f1/Dhalsim.jpg/revision/latest?cb=20110828202018',
		convert(datetime, '01/01/2001',111),
		176,
		47,
		'USA',
		'Yoga Fire, Yoga Flame.',
		0);

		Select * From Personagens

		Select Nome,IDPersonagem,Imagem,Nascimento,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto From Personagens Where IDPersonagem = 2

		UPDATE Personagens SET Nome = @param_Nome ,Imagem = @param_Imagem ,Nascimento = @param_Nascimento,Altura = @param_Altura,Peso = @param_Peso,AbreviacaoPais = @param_AbreviacaoPais ,GolpesEspeciais = @param_GolpesEspeciais,PersonagemOculto = @param_PersonagemOculto WHERE IDPersonagem = 3

		INSERT INTO Personagens (Nome,Imagem,Nascimento,Altura,Peso,AbreviacaoPais,GolpesEspeciais,PersonagemOculto) values ('ji', param_Imagem , param_Nascimento, param_Altura, param_Peso, param_AbreviacaoPais , param_GolpesEspeciais, param_PersonagemOculto)
