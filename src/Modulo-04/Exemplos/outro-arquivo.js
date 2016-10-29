var elfo = {  nome:'Legolas', experiencia:1};

function exibirElfoNaTela(elfo){

    if(elfo ===undefined){
      var minusculo = elfo.nome.toLowerCase();
    }
    minusculo +='oi';
    alert(maiusculo(elfo.nome));
    function maiusculo(texto){
    return texto.toUpperCase();
  }
}
