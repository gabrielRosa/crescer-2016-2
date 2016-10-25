//1
function gerarPiramide(niveis){
  var caracter = "R$";
  for(var i=0;i<niveis;i++){
    var ret = caracter;
    for(var j=0;j<i;j++){
      ret+=caracter;
    }
    console.log(ret);
  }
}

//console.log(gerarPiramide(9));
//2
/*
function diglettDig(){
  for(var i=1;i<=100;i++){
    if(i%3===0){
      console.log("Diglett dig");
    }else{
    console.log(i);
  }
  }
}

console.log(diglettDig());
*/

/*
function diglettDig(){
  for(var i=1;i<=100;i++){
    if(i%5===0 && !(i%3===0)){
      console.log("trio trio trio");
    }else{
    console.log(i);
  }
  }
}

console.log(diglettDig());
*/

function diglettDig(){
  for(var i=1;i<=100;i++){
    if(i%5===0 &&(i%3===0)){
      console.log("Diglett dig, trio trio trio");
    }else if(i%3===0){
    console.log("Diglett dig");
    }else if (i%5===0) {
    console.log("trio trio trio");
    }else {
    console.log(i);
    }
  }
}

//console.log(diglettDig());
//3
function find(array, func){
  if(typeof func !=="function"){
    return null;
  }
  var ret =[];
  var cont=0;
  for(var i =0, len = array.length;i<len;i++){
    if(func(array[i])){
      ret[cont++]=array[i];
    }
  }
  return ret;
}

//teste 1

var maiorIgualADois = function(elemento) {
  return elemento >= 2;
};
//console.log(find([ 1, 2, 3 ], maiorIgualADois));

//teste 2

//console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
//  return typeof elem === 'string';
//}));

//teste 3

//console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
//  return typeof elem.nome === 'c';
//}));

//teste 4

//var maiorIgualADois = 'maior igual ou a dois';
//console.log(find([ 1, 2, 3 ], maiorIgualADois));

//4

function subtrair(numero){
  return function (numero2){
    return numero - numero2;
  }
}

/*
console.log(subtrair(2)(1)); // 1
console.log(subtrair(0)(0)); // 0
console.log(subtrair(-1)(-2)); // 1
*/

//5

function iguais(param1, param2){
  if(param1 === param2){
    return true;
  }
  iguaisAux(param1, param2, 0);
  return false;
}

function iguaisAux(param1, param2, i){

}

var obj = { a: { a: 'a' }, b: 2 };
console.log(iguais(obj, obj)); // true
console.log(iguais(obj, { a: 1, b: 2 })); // false
console.log(iguais(obj, { a: { a: 'a' }, b: 2 })); // true
console.log(iguais({ a: 1 }, { b: 1 })); // false

//6
/*
function ctrlC(objeto){
  var newObj;
  for(var k in objeto){
    newObj[k] = objeto[k];
  }
  return newObj;
}

var destino = ctrlC({ a: '1' });
console.log(destino);
// { a: '1' }
console.log(origem === destino);
// false
console.log(iguais(origem, destino));
// true
destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
console.log(destino.a[2].e());
*/
// 3

//7

function mesclar(objeto1, objeto2){
    for (var k in objeto1){
      for (var l in objeto2){
        objeto1[k] = objeto1[l];
      }
    }
  }
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
