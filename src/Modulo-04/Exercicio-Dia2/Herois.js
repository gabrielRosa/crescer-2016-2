class Herois{
  constructor(array){
    this.array = array;
  }
/*
 foraDaGuerraCivil(){
   let ret = new Array();
   for(let i =0;i<this.array.length;i++){
      let objs = this.array[i];
      let events = objs.events;
      let itens = events.items;
      let participou = false;
        for(let j=0;j<itens.length;j++){
          let name = itens[j].name;
          if(name === "Civil War"){
            participou = true;
          }
      }
        if(!participou){
          ret.push(objs.name);
        }
    }
    return ret;
  }
  */

  foraDaGuerraCivil(){
    function contem(subTexto){
       return this.indeof("Civil War") !== -1;
    }
     return this.array.filter(array => array.events.items.filter(e => e.name.contem()).length ===0);
  }


/*
  maisPublicado(){
    let ret;
    let objs = this.array[0];
    let comics = objs.comics;
    let available = comics.available;
    ret = objs;
    for(let i =1;i<this.array.length;i++){
      objs = this.array[i];
      comics = objs.comics;
      let availableNow = comics.available;
      if(available<availableNow){
        available = availableNow;
        ret = objs;
      }

    }
    return ret;
  }
  */

/*
  mediaPaginas(){
    let pageCount = 0;
    let count =0;
    for(let i =0;i<this.array.length;i++){
      let objs = this.array[i];
      let comics = objs.comics;
      let itens = comics.items;
      for(let j = 0; j<itens.length;j++){
        let pages = itens[j].pageCount;
        pageCount =  pageCount + pages;
        count++;
      }
    }
    return pageCount/count;
  }
  */

/*
  seriesPorLongevidade(){
    //bug para ordenar
    let ret = new Array();
    for(let i =0;i<this.array.length;i++){
      let objs = this.array[i];
      let series = objs.series;
      let itens = series.items;
      for(let j = 0; j<itens.length;j++){
        ret.push(itens[j]);
      }
    }

    function compare(a,b) {
      return a.startYear - a.endYear
      < b.startYear - b.endYear;
    }
    ret.sort(compare);
    return ret;
    //bug para ordenar
  }
  */

/*
  comicMaisCara(){
    let price = 0;
    let ret;
    for(let i =0;i<this.array.length;i++){
      let objs = this.array[i];
      let comics = objs.comics;
      let itens = comics.items;
      let priceNow=0;
      for(let j = 0; j<itens.length;j++){
        let prices = itens[j].prices;
        for(var l=0; l<prices.length;l++){
          priceNow = priceNow + prices[l].price;
        }
      }
      if(priceNow>price){
        price = priceNow;
        ret = objs;
      }
    }
    return ret;
  }
*/
}
