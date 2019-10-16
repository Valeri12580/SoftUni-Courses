function addItem() {
    let    inputField = document.getElementById("newText")
    let items=document.getElementById("items")
    if(inputField===null){
        throw new Error("error")
    }


    let li = document.createElement("li")
    let a=creatingATag()


    if( inputField.value!==""){
        li.innerHTML=inputField.value
        li.appendChild(a)
       items. appendChild(li)
        inputField.value=""
    }


    function creatingATag(){
        let a =document.createElement("a")
   
        a.textContent="[Delete]"
        a.setAttribute("href","#")
        a.addEventListener("click",remove)
        return a
    }

    function remove(e){
        items.removeChild(e.target.parentNode)
    }


   




    
}