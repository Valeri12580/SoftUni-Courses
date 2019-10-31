//ne raboti
function solve() {

    let input=JSON.parse(document.querySelector("#arr").value);
    let result=document.querySelector("#result")
    let pattern=new RegExp("^(?<firstName>[A-Z][a-z]*) (?<surname>[A-Z][a-z]*) (?<phoneNumber>\\+359(?<dashOrWhiteSpace>\\s|-)\\d{1}(\k<dashOrWhiteSpace>)\\d{3}(\\k<dashOrWhiteSpace>)\\d{3}) (?<email>[a-z]+@[a-z]+\\.[a-z]{2,3})$","g","m")
   input.forEach(e=>{
       if (pattern.test(e)){
           console.log(e);
           
           result.textContent=e+'\n'
       }else{
        result.textContent="Invalid\n"
       }
   })
   
   
    
}