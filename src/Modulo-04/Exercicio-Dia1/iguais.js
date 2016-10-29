function ehObjeto(obj) {
  return typeof obj === 'object';
}

function iguais(obj1, obj2) {

  if (ehObjeto(obj1) && ehObjeto(obj2)) {
    if (Object.keys(obj1).length !== Object.keys(obj2).length) {
      return false;
    }

    for (let prop in obj1) {
      let saoIguais = iguais(obj1[prop], obj2[prop]);
      if (!saoIguais) return false;
    }
    return true;
  }
  
  return obj1 === obj2;
}



var obj = { a: { a: 'a' }, b: 2 };
console.log(iguais(obj, obj)); // true
console.log(iguais(obj, { a: 1, b: 2 })); // false
console.log(iguais(obj, { a: { a: 'a' }, b: 2 })); // true
console.log(iguais({ a: 1 }, { b: 1 })); // false
