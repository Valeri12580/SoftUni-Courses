function solve() {
    let specificWord=document.getElementById("word").value
    let array=JSON.parse(document.getElementById("text").value)
    let spanResult=document.getElementById("result");
    let neededToBeReplaced=array[0].split(" ").filter(e=>e!=="")[2]
    let regex=new RegExp(neededToBeReplaced,"i")

    for (let i = 0; i < array.length; i++) {
        const element = array[i];
      
        let p = document.createElement("p")
        p.textContent=  element.replace(regex,specificWord)
        spanResult.appendChild(p)
        
    }

}
solve()