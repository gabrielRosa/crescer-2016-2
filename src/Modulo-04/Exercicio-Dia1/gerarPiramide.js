//1
function gerarPiramide(niveis){
  var caracter = "R$";
  for(var i=1;i<=niveis;i++){
    var ret = caracter;
    for(var j=1;j<=i;j++){
      ret+=caracter;
    }
    console.log(ret);
  }
}
/*
//outra forma
function gerarPiramide(niveis) {
  for (var i = 1; i <= niveis; i++) {
    console.log(Array(i+1).join('R$'));
  }
}
*/
console.log(gerarPiramide(9));
