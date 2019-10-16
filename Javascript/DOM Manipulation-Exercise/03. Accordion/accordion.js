function toggle() {
    let spanBtn=document.getElementsByClassName("button")[0]
    let div=document.getElementById("extra")
   
    if(spanBtn.textContent==="More"){
        div.style.display="block"
        spanBtn.textContent="Less"
    }else{
        div.style.display="none"
        spanBtn.textContent="More"
    }


    
    
    
    // spanBtn.addEventListener("click",function(e){
    //     div.style.display="inline"
    // })
}