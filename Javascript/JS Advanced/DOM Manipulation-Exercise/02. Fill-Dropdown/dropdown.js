function addItem() {
    let textInput=document.getElementById("newItemText")
    let valueInput=document.getElementById("newItemValue")

    let option=document.createElement("option")
    option.textContent=textInput.value+valueInput.value
    textInput.value=""
    valueInput.value=""
    document.getElementById("menu").appendChild(option)
}