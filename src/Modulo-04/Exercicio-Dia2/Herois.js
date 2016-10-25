class Herois{
  constructor(array){
    this.array = array;
  }

 foraDaGuerraCivil(){
    for(var i =0;i<this.array.length;i++){
      var objs = this.array[i];
      var events = objs.events;
      var itens = events.items;
      var participou = false;
      for(var j=0;j<itens.length;j++){
      if(itens[j].name ==! 'Civil War'){
        participou = true;
      }
      }
      if(participou){
        console.log(objs.name);
      }
    }
}
}
