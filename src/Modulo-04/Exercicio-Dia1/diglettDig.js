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

console.log(diglettDig());
