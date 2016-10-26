describe('foraDaGuerraCivil()', function() {

  it('retorna um array com todos aqueles personagens que NÃO participaram da guerra civíl', function() {
    let herois5 = new Herois(marvel);
    let resultado = herois5.foraDaGuerraCivil();
    expect(resultado[0]).toEqual('Guardians of the Galaxy');
  });
  /*
  //como testar um objeto
  it('retorna o objeto personagem que mais possui histórias em quadrinhos publicadas', function() {
    let herois5 = new Herois(marvel);
    let resultado = herois5.maisPublicado();
    expect(resultado[0]).toEqual();
  });
  */

  it('retorna a média de páginas de todos quadrinhos dos personagens', function() {
    let herois5 = new Herois(marvel);
    let resultado = herois5.mediaPaginas();
    expect(resultado).toEqual(37.03125);
  });

  //duvidas de como testar objetos

});
