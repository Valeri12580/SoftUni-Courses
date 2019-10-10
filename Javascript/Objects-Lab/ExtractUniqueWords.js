function solve(input){
    let pattern=new RegExp()
    return [...new Set(input
         .join("")
         .toLowerCase()
         .match(/\w+/gim))]
         .join(", ")
 
   
   
    
    
    
     
 
 }


console.log(solve(['Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Pellentesque quis hendrerit dui.','Quisque fringilla est urna, vitae efficitur urna vestibulumfringilla.','Vestibulum dolor diam, dignissim quis varius non, fermentumnon felis.','Vestibulum ultrices ex massa, sit amet faucibus nunc aliquamut.','Morbi in ipsum varius, pharetra diam vel, mattis arcu.','Integer ac turpis commodo, varius nulla sed, elementumlectus.','Vivamus turpis dui, malesuada ac turpis dapibus, congueegestas metus.']))
