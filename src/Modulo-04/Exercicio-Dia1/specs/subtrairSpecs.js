describe('subtrair()', function() {

  it('subtrair dois números inteiros positivos', function() {
    expect(subtrair(2)(1)).toEqual(1);
  });
  it('subtrair dois números iguais', function() {
    expect(subtrair(0)(0)).toEqual(0);
  });
  it('subtrair dois números, sendo um negativo', function() {
    expect(subtrair(-1)(2)).toEqual(-3);
  });

});
