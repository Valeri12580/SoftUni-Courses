let template=""
let htmlElements={
    input:()=>document.querySelector("#towns"),
    resultDiv:()=>document.querySelector("#root")

};




document.addEventListener("click",function (e) {

    if(e.target.textContent==="Load" ){

        let towns=htmlElements.input().value.split(", ")
        displayResult(towns);
        clearInput();
    }

})

async function  displayResult(towns) {

    let result=template({towns});
    htmlElements.resultDiv().innerHTML=result



}

(async function  createTemplate() {
    let source=await fetch("template.hbs").then(e=>e.text());
     template=Handlebars.compile(source);

})();

function  clearInput() {
    htmlElements.input().value=""
}