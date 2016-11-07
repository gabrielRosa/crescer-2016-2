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
		'http://www.streetfighter.com.br/upload/editor/20120623181731_940.gif',
		convert(datetime, '01/01/2001',111),
		176,
		47,
		'USA',
		'Yoga Fire, Yoga Flame.',
		0);

		Select Nome From Personagens