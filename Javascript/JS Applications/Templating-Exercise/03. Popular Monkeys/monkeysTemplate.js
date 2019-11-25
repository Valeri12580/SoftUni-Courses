import {monkeys} from "./monkeys.js";

let htmlElements = {
    monkeysDiv: () => document.querySelector("body > section > div")
};

(function render() {
    let source = document.querySelector("#monkey-template").innerHTML;
    let template = Handlebars.compile(source);
    let result = template({monkeys});
    htmlElements.monkeysDiv().innerHTML = result;


})();


(function attachListener() {
    document.addEventListener("click", function (e) {
        if (e.target.textContent === "Info") {
            let id=e.target.getAttribute("btn-id");

            let content=document.querySelector(`body > section > div > div:nth-child(${id}) > p`);
            content.style.display=content.style.display==="none"?"block":"none"
        }
    })
})();