function solve() {
  let input=document.getElementById("input").innerHTML.split(".")
  let output=document.getElementById("output")
  if(input===null || output===null){
    throw new Error("Error")
  }
  let p=document.createElement("p")
  let count=1;
  while(input.length!==0){
    p.innerHTML+=input.shift()+"."
    if(count%3==0){
      output.appendChild(p)
      p=document.createElement("p")
    }

    count++;
  }
  output.appendChild(p)
   
    
    
    
   
    
  
  //fixni da se pokazvat po 3 na p
}