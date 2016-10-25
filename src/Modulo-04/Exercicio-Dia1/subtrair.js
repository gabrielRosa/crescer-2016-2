//4

function subtrair(numero){
  return function (numero2){
    return numero - numero2;
  }
}

//teste1

console.log(subtrair(2)(1)); // 1

//teste2

console.log(subtrair(0)(0)); // 0

//teste3

console.log(subtrair(-1)(-2)); // 1
