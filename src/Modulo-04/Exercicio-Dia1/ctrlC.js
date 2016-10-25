function ctrlC(objeto){
  var newObj;
  for(var k in objeto){
    newObj = objeto[k];
  }
  return newObj;
}

var origem = { a: '1' };
var destino = ctrlC(origem);
console.log(destino);
// { a: '1' }
console.log(origem === destino);
// false
console.log(iguais(origem, destino));
// true
destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
console.log(destino.a[2].e());
// 3
