import  {contacts} from "./contacts.js";

let src=document.getElementById("template").innerHTML;

let template=Handlebars.compile(src);
let htmlContainer= {
    contacts: () => document.querySelector("#contacts")

}

function main(){

    displayContacts(contacts)

}
main()


function displayContacts(contacts){
    contacts.forEach(e=>{
        let html=template(e);
        htmlContainer.contacts().innerHTML+=`${html}\n`;

    })

}

document.addEventListener("click",function (e) {
        if(e.target.tagName==="BUTTON"){
            e.target.nextElementSibling.style.display=e.target.nextElementSibling.style.display==="none"?"block":"none"
        }
});


