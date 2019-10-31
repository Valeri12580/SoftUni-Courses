function solve() {
  let getInput = document.getElementById("text").value

  let result = document.getElementById("result")

  let stringOutput = ""
  getInput = getInput.split(" ").filter(e => e !== "");
  for (const e of getInput) {
    if (Number(e)) {
      stringOutput += String.fromCharCode(e)
    } else {
      let charToNum = []
      for (let i = 0; i < e.length; i++) {
        charToNum.push(e[i].charCodeAt(0))

      }
      let p = document.createElement("p")
      p.textContent = charToNum.join(" ")
      result.appendChild(p)
    }


  }
  let p = document.createElement("p")
  p.textContent=stringOutput
  result.appendChild(p)


}