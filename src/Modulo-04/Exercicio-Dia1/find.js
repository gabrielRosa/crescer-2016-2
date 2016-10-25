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
console.log(find([ 1, 2, 3 ], maiorIgualADois));

//teste 2

console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
  return typeof elem === 'string';
}));

//teste 3

console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
  return typeof elem.nome === 'c';
}));

//teste 4

var maiorIgualADois = 'maior igual ou a dois';
console.log(find([ 1, 2, 3 ], maiorIgualADois));
