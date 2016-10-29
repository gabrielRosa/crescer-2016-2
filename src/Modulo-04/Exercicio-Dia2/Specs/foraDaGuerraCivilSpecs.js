describe('foraDaGuerraCivil()', function() {

  it('retorna um array com todos aqueles personagens que NÃO participaram da guerra civíl', function() {
    let herois5 = new Herois(marvel);
    let resultado = herois5.foraDaGuerraCivil();
    expect(resultado[0]).toEqual('Guardians of the Galaxy');
  });

  it('retorna o objeto personagem que mais possui histórias em quadrinhos publicadas', function() {
    let dadosHerois = [
      { name: 'Debug Destruidor', comics: { available: 12 } },
      { name: 'Tipagem Maravilhosa', comics: { available: 39 } },
      { name: 'Compilador Prateado', comics: { available: 3 } }
    ]
    let herois5 = new Herois(dadosHerois);
    let resultado = herois5.maisPublicado();
    expect(resultado).toEqual({ name: 'Tipagem Maravilhosa', comics: { available: 39 } });
  });


  it('retorna a média de páginas de todos quadrinhos dos personagens', function() {
    let herois5 = new Herois(marvel);
    let resultado = herois5.mediaPaginas();
    expect(resultado).toEqual(37.03125);
  });
/*
  it(' retorna o objeto comic mais caro entre todos personagens', function() {
    let dadosHerois = [
      { name: 'Debug Destruidor', comics: { itens: { prices: {price : 100 }} } },
      { name: 'Tipagem Maravilhosa', comics:  { itens: { prices: {price : 1000 }} } },
      { name: 'Compilador Prateado', comics:  { itens: { prices: {price : 10}} } }
    ]
    let herois5 = new Herois(dadosHerois);
    let resultado = herois5.maisPublicado();
    expect(resultado).toEqual(  { name: 'Tipagem Maravilhosa', comics:  { itens:{ prices:{price : 100,2000}} } });
  });
*/
});
