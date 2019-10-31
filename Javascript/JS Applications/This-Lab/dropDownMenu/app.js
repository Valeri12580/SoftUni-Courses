function solve() {
   let chooseStyle=document.querySelector("#dropdown")
   let stylelist=document.querySelector("#dropdown-ul")
   let box=document.querySelector("#box")
   
   document.addEventListener("click",function(e){
      
      console.log(e.currentTarget===this);
      
      
      
      
      
    
       
       
       
       if(stylelist.style.display==="block"){
        stylelist.style.display="none"
        box.style.backgroundColor=""
       }else{
        stylelist.style.display="block"
        
       }

   
       
   })

   stylelist.addEventListener("click",function (e){
     
        
       box.style.backgroundColor=e.target.textContent
       
   })
}