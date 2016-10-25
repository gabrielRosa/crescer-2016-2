function mesclar(objeto1, objeto2){
    for (var k in objeto1){
      for (var l in objeto2){
        if(objeto1[l] === objeto2[l])
        objeto1[l] = objeto1[l] + objeto2[l];
      }
    }
  }
//teste 1
var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100 },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200 },
  damasco: 100
};
mesclar(objeto1, objeto2);
console.log(objeto1);
