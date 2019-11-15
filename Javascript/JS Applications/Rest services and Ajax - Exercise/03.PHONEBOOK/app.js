function attachEvents() {
    let loadBtn=document.querySelector("#btnLoad");
    let phonebookContacts=document.querySelector("#phonebook");
    let personInput=document.querySelector("#person")
    let phoneInput=document.querySelector("#phone")
    let createBtn=document.querySelector("#btnCreate")
    
    loadBtn.addEventListener("click",()=>{
       loadData()
    })

    createBtn.addEventListener("click",()=>{
        let person=personInput.value;
        let number=phoneInput.value;

        let header={
            method:"POST",
            header:{
                "content-type":"application/json"
            },
            body:JSON.stringify({person,number})
        }
        sendData(header)




    })

    function sendData(header){

        fetch("https://phonebook-nakov.firebaseio.com/phonebook.json",header).then(()=>{
            personInput.value="";
            phoneInput.value="";
            loadData()
        })
    }

    function loadData(){
        fetch("https://phonebook-nakov.firebaseio.com/phonebook.json")
        .then(e=>e.json())
        .then(data=>{
            phonebookContacts.textContent=""
            Object.entries(data).forEach(([phoneId,phonebookData])=>{
                let {number,person}=phonebookData;

                let deleteBtn=document.createElement("button");
                deleteBtn.textContent="Delete"
                deleteBtn.setAttribute("data-target",phoneId)
                deleteBtn.addEventListener("click",deleteElement)
              

                let li=document.createElement("li");
                li.textContent=`${person}: ${number} `
               
                li.appendChild(deleteBtn)
                phonebookContacts.appendChild(li)

            });
            
            


        })
    }


    function deleteElement(e){
        let phoneId=this.getAttribute("data-target")
        let header={
            method:"DELETE",

        }
        fetch(`https://phonebook-nakov.firebaseio.com/phonebook/${phoneId}.json`,header)
        sendData()
        
    }
}

attachEvents();