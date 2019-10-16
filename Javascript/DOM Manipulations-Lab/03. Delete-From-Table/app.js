function deleteByEmail() {
    
    let input=document.querySelector("body > label > input[type=text]").value
    let tbody=document.querySelector("#customers > tbody")

    let emails=[]
    Array.from(tbody.children).forEach(e=>emails.push(e.children[1].textContent))
    let p=document.createElement("p")
    
    if(emails.includes(input)){
        let indexOfInput=emails.indexOf(input)
        let getRow=tbody.children[indexOfInput]
        tbody.removeChild(getRow)
        p.textContent="Deleted."
    }else{
        p.textContent="Not found."
    }
    document.getElementById("result").appendChild(p)

    
}