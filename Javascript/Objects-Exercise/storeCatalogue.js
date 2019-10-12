function solve(arr){
    arr=arr.sort()
    let categories=Array.from(arr)
    
    categories=categories.map(e=>e.charAt(0)).filter((value,index,self)=>{
        return self.indexOf(value)===index
    }).sort()
    

   for (let i = 0; i < categories.length; i++) {
       let currentCategory=categories[i];
       console.log(currentCategory);
       for (let j = 0; j < arr.length; j++) {
           let split=arr[j].split(" : ")
        let obj={
            name:split[0],
            price:+split[1]}
           if(currentCategory===arr[j].charAt(0)){
               console.log(obj.name+": "+obj.price);
           }
           
       }
       
   }
    



}

solve(['Appricot : 20.4',

'Fridge : 1500',

'TV : 1499',

'Deodorant : 10',

'Boiler : 300','Apple : 1.25', 'Anti-Bug Spray : 15', 'T-Shirt : 10'])