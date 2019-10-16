function addItem() {
    let    inputField = document.getElementById("newItemText")
    let li = document.createElement("li")
     if(inputField===null){
         throw new Error("error")
     }
    if( inputField.value!==""){
        li.textContent=inputField.value
        document.getElementById("items").appendChild(li)
        inputField.value=""
    }
    
}