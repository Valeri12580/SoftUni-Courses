function notify(message) {
    let divContent=document.querySelector("#notification")
    
    
    divContent.textContent=message
    divContent.style.display="block"
    setTimeout(()=>{
        divContent.removeChild(p)
        divContent.style.display="none"
    },2000)
}