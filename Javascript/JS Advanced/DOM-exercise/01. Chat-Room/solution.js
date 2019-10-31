function solve() {
   let btn = document.getElementById("send")
   btn.addEventListener("click",sendMsg)
   function sendMsg(){
      let element=document.querySelector("#chat_input")
   
      let newDiv=document.createElement("div")
   
      newDiv.classList.add("message","my-message")
     
      newDiv.innerHTML=element.value
      document.getElementById("chat_messages").appendChild(newDiv)
      element.value=""
   
   }

  
   
}




