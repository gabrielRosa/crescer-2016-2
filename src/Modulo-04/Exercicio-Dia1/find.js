/*function find(array, fnFiltro){
  let ret =[];
  if(typeof fnFiltro !=="function"){
    for(let i =0, len = array.length;i<len;i++){
      if(fnFiltro(array[i])){
        ret.push(array[i]);
      }
    }
  }
  return ret;
}
*/
function find(array, fnFiltro) {

  let resultado = [];
  if (typeof fnFiltro === 'function') {
    for (let i = 0; i < array.length; i++) {
      let encontrou = fnFiltro(array[i]);
      if (encontrou) {
        resultado.push(array[i]);
      }
    }
  }
  return resultado;

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
