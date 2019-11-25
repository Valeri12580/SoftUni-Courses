let htmlElements={
     allCats:()=>document.querySelector("#allCats > ul")
};
let cats=window.cats;
(() => {

     renderCatTemplate();

     function renderCatTemplate() {
          let source=document.getElementById("cat-template").innerHTML;
          let template=Handlebars.compile(source);
         let result=template({cats})
          htmlElements.allCats().innerHTML=result;


     };
 
})();


(()=>{
    document.addEventListener("click",function (e) {
            if(e.target.textContent==="Show status code" || e.target.textContent==="Hide status code"){
                let btn=e.target;
                let divInfo=btn.nextElementSibling;
                divInfo.style.display=divInfo.style.display==="none"?"block":"none";
                btn.textContent=btn.textContent==="Show status code"?"Hide status code":"Show status code";

            }
    })


})()
