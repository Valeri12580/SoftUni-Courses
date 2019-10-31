function solve() {
   document.getElementById("searchBtn").addEventListener("click",search)

   let tbody=document.getElementsByTagName("tbody")[0]
   let tr=tbody.getElementsByTagName("tr")
   
   function search(){
      Array.from(tr).forEach(e=>e.className="")
      let criteria=document.getElementById("searchField").value
      for (let i = 0; i < tr.length; i++) {
         let tdName=tr[i].getElementsByTagName("td")[0].textContent;
         let tdEmail=tr[i].getElementsByTagName("td")[1].textContent;
         let tdCourse=tr[i].getElementsByTagName("td")[2].textContent.toLowerCase();
         
         if(tdName.includes(criteria)||tdEmail.includes(criteria)|| tdCourse.includes(criteria) ){
            tr[i].className="select"
         }
      
      }
      document.getElementById("searchField").value=""
    
     
      
      
    
      

   }
}