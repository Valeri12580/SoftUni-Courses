function attachEvents() {
    let sendBtn=document.querySelector("#submit");
    let refreshBtn=document.querySelector("#refresh")
    let messageContent=document.querySelector("#content")
    let authorName=document.querySelector("#author");
    let textArea=document.querySelector("#messages");

    refreshBtn.addEventListener("click",refreshMessages)

    sendBtn.addEventListener("click",sendMessage)



    function refreshMessages(){
        fetch("https://rest-messanger.firebaseio.com/messanger.json").then(e=>e.json())
        .then(data=>{
           let values=Object.values(data).map(({author,content})=>`${author}: ${content}`);
            textArea.textContent=values.join("\n")
            
            
            
        })
            
        
    }

    function sendMessage(){

        fetch("https://rest-messanger.firebaseio.com/messanger.json",{
            method:"POST",
            header:{
                "content-type":"application/json"
            },
            body:JSON.stringify({
                author:authorName.value,
                content:messageContent.value
            })


        })
        .then(()=>{
            messageContent.value="";
            authorName.value=""
        })
    }
}

attachEvents();