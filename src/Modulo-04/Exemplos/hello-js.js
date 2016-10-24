//quase sempre é melhor incluir js no final do html

console.log("Olá JS");


console.log('Nome: ', elfo.nome);

elfo.flechas =42;
console.log(elfo.flechas);
delete elfo.nome;
elfo.flechas = undefined;
elfo['Nome Completo'] = 'Legolas da Silva';
elfo.atirarFlecha = function(dwarf, batman, opt){
  opt();
  dwarf.vida -=10;
  elfo.experiencia++;
  dwarf.feliz = false;
  return dwarf;
};

//se chamar
(function(){
  console.log('oi');
})();

var dwarf ={vida:110};
var dwarf2=elfo.atirarFlecha(dwarf, true, function(){
  console.log('oi');
});

console.log(elfo, dwarf, dwarf2);

elfo.nome = "Legolas";
exibirElfoNaTela(elfo);

elfo2['Nome Completo']  = 'LeGolas';
exibirElfoNaTela(elfo2);
