function create(words) {
  let divContent=document.getElementById("content")
   words.forEach(e=>{
      let div=document.createElement("div")
      let p =document.createElement("p")
      p.textContent=e
      p.style.display="none"
      div.appendChild(p)
      divContent.appendChild(div)
      
   })

   let nodes=document.querySelector("#content").children;
   Array.from(nodes).map(x=>x.addEventListener("click",()=>{
      x.children[0].style.display="inline"
   }))



}