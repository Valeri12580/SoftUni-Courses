import {get,put,del,post} from "./requester.js";


let htmlObjects={
    loadBooks:()=>document.querySelector("#loadBooks"),
    submitBooks:()=>document.querySelector("body > form > button"),
    bodyBooks:()=>document.querySelector("body > table > tbody")
    

}
let createForm={
    title:()=>document.querySelector("#title"),
    author:()=>document.querySelector("#author"),
    isnb:()=>document.querySelector("#isbn"),
    clear:function (){
        this.title().value=""
        this.author().value=""
        this.isnb().value=""
    }
}
let editForm={
    title:()=>document.querySelector("#edit-title"),
    author:()=>document.querySelector("#edit-author"),
    isnb:()=>document.querySelector("#edit-isbn"),
    clear:function (){
        this.title().value=""
        this.author().value=""
        this.isnb().value=""
    }
}
let actions={
    "Submit":async ()=>{
        let book=createBook(createForm.title().value,createForm.author().value,createForm.isnb().value)
        if(book){
            await post("appdata","books",book)
            await actions["LOAD ALL BOOKS"]()
            createForm.clear()
        }else{
            alertInvalidData()
        }
      
    
       
        
    },
    "LOAD ALL BOOKS":async ()=>{
        clearLoadedBooks()
        let data=await get("appdata","books")
        displayData(data)
        
      
    },
    "Delete":function(e){
        let element=e.parentNode.parentNode
      
      
        element.remove()
        
        del("appdata","books",element.getAttribute("data-id"));

    },
    "Edit":async function(e){
        let id =e.parentNode.parentNode.getAttribute("data-id")
        let getBook=await get("appdata",`books/${id}`)
        let book=createBook(getBook.title,getBook.author,getBook.isbn);
        setEditForm(id,book)
       
        
        
        
    },
    "Edit!":async function(id){
        let newBook=createBook(editForm.title().value,editForm.author().value,editForm.isnb().value)
        if(newBook){
            put("appdata",`books/${editForm.title().getAttribute("data-id")}`,newBook)
            await actions["LOAD ALL BOOKS"]()
            editForm.clear()
            editForm.title().removeAttribute("data-id")
        }else{
            alertInvalidData();
        }
       
       
    }
}
function alertInvalidData(){
    alert("Invalid data!")
}
function setEditForm(id,book){
    editForm.title().value=book.title;
    editForm.title().setAttribute("data-id",id)
    editForm.author().value=book.author;
    editForm.isnb().value=book.isbn
}
function clearLoadedBooks(){
  
    
    Array.from(htmlObjects.bodyBooks().children).forEach(e=>e.remove())
}


function createBook(title,author,isbn){
    if(title &&author && isbn){
        return {
        title,
        author,
        isbn
    }
    }
    
}



function displayData(data){
    data.forEach((object)=>{
        htmlObjects.bodyBooks().appendChild(createBookSkeleton(object))
    })

}

function createBookSkeleton(object){

    let tr=document.createElement("tr")
    tr.setAttribute("data-id",object["_id"])

    let propertiesToDisplay={
        title:object.title,
        author:object.author,
        isbn:object.isbn
    }
    for (const key in propertiesToDisplay) {
        if (propertiesToDisplay.hasOwnProperty(key)) {
            const element = propertiesToDisplay[key];
            let td=document.createElement("td")
            td.textContent=element;
            tr.appendChild(td)
        }

    }
    
   

    let tdButtons=document.createElement("td");

    let buttonEdit=document.createElement("button");
    buttonEdit.textContent="Edit"

    let buttonDelete=document.createElement("button");
    buttonDelete.textContent="Delete"

    tdButtons.append(buttonEdit,buttonDelete)

    tr.appendChild(tdButtons)
    return tr

}





(function attachEventListener(){
    document.addEventListener("click",function(e){
        e.preventDefault()

        if(typeof actions[e.target.textContent]==="function"){
            actions[e.target.textContent](e.target);
            
        }

    })
})()






