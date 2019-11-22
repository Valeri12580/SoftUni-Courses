//v zadachata nqma nishto koeto ne e iskano po uslovie-delete button i drugi.Tochno za tova e napisana taka primitivno....
//nqma proverki za nevalidni danni zashtoto tova e zadacha i ne smqtam che e nujno.Nqma go i po uslovie.Znam che trqbva da ima,no ne mislq che e nujno v tozi moment
import {get ,post} from "./requester.js"


let ids=[];
let tableResult={
    tbody:()=>document.querySelector("#results > tbody")
}
let formInputs={
    firstName:()=>document.querySelector("#first-name"),
    lastName:()=>document.querySelector("#last-name"),
    facultyNumber:()=>document.querySelector("#faculty-number"),
    grade:()=>document.querySelector("#grade"),
    id:()=>document.querySelector("#ID"),
    submit:()=>document.querySelector("#submit-btn"),
    reloadBtn:()=>document.querySelector("#reload-btn")


}

let functions={
    addStudent:()=>{
        let first_name=formInputs.firstName().value;
        let last_name=formInputs.lastName().value;
        let faculty_number=formInputs.facultyNumber().value;
        let grade=formInputs.grade().value;
        let id =formInputs.id().value
        if(ids.includes(+id)){
            alert("Choose another id!")
        }else{
            post("appdata","students",studentCreator(first_name,last_name,grade,faculty_number,id));
            functions.displayStudents();
            ids.push(id)
        }
        
        
        
    },
    displayStudents:async ()=>{
        clearTBody();
        
        let data=await get("appdata","students");
       
        
        data.forEach(e=>{
            
            tableResult.tbody().appendChild(studentLoader(e));
        })
        
        
        
    }
}
function studentCreator(first_name,last_name,grade,faculty_number,id){
   
    let student={
        first_name,
        last_name,
        grade,
        faculty_number,
        id:id
    }
    
    return student ;
    
}
function studentLoader(e){
    let  tr=document.createElement("tr");
    let student={
        id:e.id,
        firstName:e.first_name,
        lastName:e.last_name,
        grade:e.grade,
        facultyNumber:e.faculty_number
    }
    for (const key in student) {
        if (student.hasOwnProperty(key)) {
            const element = student[key];
            let td=document.createElement("td");
            td.textContent=element;
            tr.appendChild(td);
        }
    }
    return tr

    


}
let actions={
    "submit-btn":()=>{
        functions.addStudent()
        clearInputs()
    },
    "reload-btn":()=>{
        
        functions.displayStudents();

    }
}

function clearInputs(){
    formInputs.firstName().value="";
    formInputs.lastName().value="";
    formInputs.facultyNumber().value="";
    formInputs.grade().value="";
}

document.addEventListener("click",function (e){
    e.preventDefault();
    
    
    
    
    
    if(typeof actions[e.target.id]==="function"){
            
        
        actions[e.target.id]()
    }
   
        
    
})

function clearTBody(){
    tableResult.tbody().innerHTML="";
}