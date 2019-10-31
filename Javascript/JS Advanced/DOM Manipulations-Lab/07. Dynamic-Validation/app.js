function validate() {
    document.getElementById("email").addEventListener("blur",function check(e){
        if(e.target.value.match(/@/gi)===null||
        e.target.value.match(/\./gi)===null){
           e.target.setAttribute("class","error")
        }else{
            e.target.setAttribute("class","")
        }
        
        
    })
}