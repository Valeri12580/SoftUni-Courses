
//pomisli kak da gi vkarash vutre
function growingWord() {
  const colorMap=['rgb(91, 136, 189)', 'rgb(143, 248, 151)', 'rgb(164, 0, 20)']

  let text=document.querySelector("#exercise p")

  
  
  
  text.style.fontSize=text.style.fontSize===""?"2px":Number(text.style.fontSize.replace("px",""))*2+"px"
  
  if( text.style.color===""){
    text.style.color=colorMap[0]
  }else if ( text.style.color===colorMap[0]){
    text.style.color=colorMap[1]
  }else if ( text.style.color===colorMap[1]) {
    text.style.color=colorMap[2]
  }else{
    text.style.color=colorMap[0]
  }
 

  
 

 
  

 
  
}