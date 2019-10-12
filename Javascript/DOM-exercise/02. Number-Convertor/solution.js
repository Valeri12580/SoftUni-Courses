function solve() {
    let numberElement=document.getElementById("input")
    let btn=document.getElementsByTagName("button")[0]

    let getOptions=document.getElementById("selectMenuTo")
   
    let createOption=document.createElement("option")

    createOption.text="Binary";
    createOption.value="binary"
    getOptions.appendChild(createOption)

    createOption=document.createElement("option")
    createOption.text="Hexadecimal";
    createOption.value="hexadecimal"
    getOptions.appendChild(createOption)

    btn.addEventListener("click",parseNumber)


    function parseNumber(){
            let numberValue;
            
           
         
            if(getOptions.value==="binary"){
                numberValue=(+numberElement.value).toString(2)
            }else if(getOptions.value==="hexadecimal"){
                numberValue=(+numberElement.value).toString(16).toUpperCase()
            }

            let result=document.getElementById("result")
            
            
            result.value=numberValue

    }
    //TODO...
}