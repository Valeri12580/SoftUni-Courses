function solve(){
   let lastItem=""
   Array.from(document.querySelector("body > table > tbody").children).map(e=>e.addEventListener("click",function(){
      if(this.style.backgroundColor===""){
         if(lastItem!==""){
            lastItem.style.backgroundColor=""
         }
         this.style.backgroundColor="#413f5e"
         lastItem=this
         
      }else{
         this.style.backgroundColor=""
      }
      
   }))
}
