function solve() {
    let text = document.getElementById('text').value;
    let n = document.getElementById("number").value
    n = +n
    let resultSpan = document.getElementById("result");
    text=text.padEnd(Math.ceil(text.length/n)*n,text)
    let arr=[]
   

    for (let i = 0; i < text.length; i+=n) {
        arr.push(text.substr(i,n))
        
    }

    resultSpan.textContent=arr.join(" ")
 

    


}


