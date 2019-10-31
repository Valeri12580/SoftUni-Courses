function solve() {
   let totalPrice = document.querySelector("body > h1:nth-child(4)")
   let totalPriceSum=0;
   let availableProductsUl=document.querySelector("#products > ul")
   let addbtm = document.querySelector("#add-new > button")
   let myProductUl=document.querySelector("#myProducts > ul")
   

   addbtm.addEventListener("click", function (e) {
      e.preventDefault()

      let productName = document.querySelector("#add-new > input[type=text]:nth-child(2)").value;
      let quantity = document.querySelector("#add-new > input[type=text]:nth-child(3)").value
      let price = Number(document.querySelector("#add-new > input[type=text]:nth-child(4)").value);

     
      let li = document.createElement("li")

      let spanLi = document.createElement("span")
      spanLi.textContent = productName;

      let strongLi = document.createElement("strong")
      strongLi.textContent = "Available: " + quantity

      li.appendChild(spanLi)
      li.appendChild(strongLi)

      let div=document.createElement("div")
      let strongDiv=document.createElement("strong")
     
      
      strongDiv.textContent=price.toFixed(2)

      let addToClientListBtn=document.createElement("button")
addToClientListBtn.textContent="Add to Client's List"

      addToClientListBtn.addEventListener("click",function(e){
         totalPriceSum+=price;
         totalPrice.textContent="Total Price: "+totalPriceSum.toFixed(2)

         let li =document.createElement("li")
         let strong=document.createElement("strong")
         strong.textContent=price
         li.textContent=productName;
         li.appendChild(strongDiv)

         quantity=quantity-1


         if(quantity===0){
         let parent=e.currentTarget.parentNode.parentNode
         availableProductsUl.removeChild(parent)
         myProductUl.appendChild(li)
         }else{
            myProductUl.appendChild(li)
            strongLi.textContent="Available: " + quantity
         }
         



         
      })

      div.appendChild(strongDiv)
      div.appendChild(addToClientListBtn)
      li.appendChild(div)

      availableProductsUl.appendChild(li)
   


   })

   let buyBtn=document.querySelector("#myProducts > button")

      buyBtn.addEventListener("click",function(e){
         let parent=e.currentTarget.parentNode
         let childToBeRemoven=Array.from(parent.children[1].children)
        childToBeRemoven.forEach(e=> myProductUl.removeChild(e))
        totalPriceSum=0;
        totalPrice.textContent="Total Price: "+totalPriceSum.toFixed(2)
        

        
      })


      let filterBtn=document.querySelector("#products > div > button")

      filterBtn.addEventListener("click",()=>{
         let criteria=document.querySelector("#filter").value.toLowerCase()
         let childrens=Array.from(document.querySelector("#products > ul").children);
        
            childrens.forEach(e=>{
               if(e.children[0].textContent.toLowerCase().includes(criteria)){
                  e.style.display="block"
               }else{
                  e.style.display="none"
               }
               
               
            })
         
           
        

      })
}