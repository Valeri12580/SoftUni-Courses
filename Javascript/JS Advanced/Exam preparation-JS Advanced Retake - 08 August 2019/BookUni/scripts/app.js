function solve() {
    let newBooksList=document.querySelector("#outputs > section:nth-child(2) > div")
    let oldBooksList=document.querySelector("#outputs > section:nth-child(1) > div");
    let totalStoreProfit=document.querySelector("body > h1:nth-child(3)");
    let totalStoreProfitSum=0;

    let addNewBookBtn=document.getElementsByTagName("button")[0]
    addNewBookBtn.addEventListener("click",function(e){
        e.preventDefault()
        let bookTitle=document.querySelector("body > form > input[type=text]:nth-child(2)").value
        let bookYear=Number(document.querySelector("body > form > input[type=number]:nth-child(4)").value)
        let bookPrice=Number(document.querySelector("body > form > input[type=number]:nth-child(6)").value)
        if(bookTitle!=="" && bookYear>=0 && bookPrice>=0){
            let createDivElement=document.createElement("div")
            createDivElement.className="book"
            let p=document.createElement("p")
            p.textContent=`${bookTitle} [${bookYear}]`
            createDivElement.appendChild(p)

            if(bookYear>=2000){
               
                let buyBtn=document.createElement("button")
                buyBtn.textContent=`Buy it only for ${bookPrice.toFixed(2)} BGN`
                buyBtn.addEventListener("click",function(e){
                    totalStoreProfitSum+=bookPrice;
                    totalStoreProfit.textContent=`Total Store Profit: ${totalStoreProfitSum.toFixed(2)} BGN`
                   
                     e.currentTarget.parentNode.parentNode.removeChild(createDivElement)
                    
                })
                createDivElement.appendChild(buyBtn)

                
                let moveToOldBookSectionBtn=document.createElement("button")
                moveToOldBookSectionBtn.textContent="Move to old section"

                moveToOldBookSectionBtn.addEventListener("click",function(e){
                    let informationInsideDiv=e.currentTarget.parentNode
                    
                    //remove button
                    informationInsideDiv.removeChild(informationInsideDiv.childNodes[2])
                    
                    bookPrice=bookPrice-(bookPrice*0.15)
                   buyBtn.textContent=`Buy it only for ${bookPrice.toFixed(2)} BGN`
                
                    
                    oldBooksList.appendChild(informationInsideDiv)

                    

                })
                createDivElement.appendChild(moveToOldBookSectionBtn)


                newBooksList.appendChild(createDivElement)
    
            }else{
                bookPrice=bookPrice-(bookPrice*0.15)
                let buyBtn=document.createElement("button")
                buyBtn.textContent=`Buy it only for ${bookPrice} BG`
                buyBtn.addEventListener("click",function(e){
                    totalStoreProfitSum+=bookPrice;
                    totalStoreProfit.textContent=`Total Store Profit: ${totalStoreProfitSum.toFixed(2)} BGN`
                   
                     e.currentTarget.parentNode.parentNode.removeChild(createDivElement)
                    
                })
                createDivElement.appendChild(buyBtn)
               


                oldBooksList.appendChild(createDivElement)
                
            }
            



            
        }
        
    })

}