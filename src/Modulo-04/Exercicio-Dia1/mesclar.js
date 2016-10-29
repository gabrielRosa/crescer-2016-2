var mesclar = function(obj1, obj2, recursiva = false) {

  for (var prop in obj2) {
    if (recursiva && typeof obj2[prop] === 'object') {
      mesclar(obj1[prop], obj2[prop], recursiva);
    } else {
      obj1[prop] = obj2[prop];
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
