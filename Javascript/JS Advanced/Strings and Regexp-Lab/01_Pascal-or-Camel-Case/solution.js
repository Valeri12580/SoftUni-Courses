function solve() {
  let types = {
    "Pascal Case": (lowerCaseArrayString) => {
      let value  = lowerCaseArrayString.reduce((acc, curr) => {
        curr = curr.replace(curr.charAt(0), curr.charAt(0).toUpperCase())
        return acc + curr
      }, "")
      return value 
    },
    "Camel Case": (lowerCaseArrayString) => {
      let value = lowerCaseArrayString.reduce((acc, curr, i) => {
        console.log(curr);
        if (i !== 0) {
          curr = curr.replace(curr.charAt(0), curr.charAt(0).toUpperCase())
        }
        return acc + curr
      }, "")
      return value
    },

  }
  let inputText = document.getElementById("text").value;
  let namingConvention = document.getElementById("naming-convention").value;

  let lowerCaseArrayString = inputText.split(" ").map(e => e.toLowerCase());
  let finalString = "";

  if (types.hasOwnProperty(namingConvention)) {
    finalString = types[namingConvention](lowerCaseArrayString);
  } else {
    finalString = "Error!";
  }
  document.getElementById("result").textContent = finalString;

  



}