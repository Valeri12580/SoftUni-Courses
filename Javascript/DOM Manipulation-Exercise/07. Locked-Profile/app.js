function lockedProfile() {
    Array.from(document.getElementsByTagName("button")).map(x=>x.addEventListener("click",function fn(e){
        let getLockedCheck=this.parentElement.querySelector(('input[value="lock"]'))
        if(getLockedCheck.checked!==true){
            let hiddenDiv=this.parentElement.getElementsByTagName("div")[0]
           if(this.textContent==="Show more"){

            hiddenDiv.style.display="block"
            this.textContent="Hide it"
           }else{
            hiddenDiv.style.display="none"
            this.textContent="Show more"
           }
            
        }

       


    }))
}