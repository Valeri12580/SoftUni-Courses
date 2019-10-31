

function solve(input){
    
    let pattern=new RegExp("[^A-Za-z0-9_]+")
    let object={}

    for (let index = 0; index < input.length; index++) {
        let currentValues=input[index];
        
        currentValues=currentValues.split(pattern).filter(e=>e!=="")

        for(let i =0;i<currentValues.length;i++){
            let singleValue=currentValues[i]
           if(object.hasOwnProperty(singleValue)){{
               object[singleValue]+=1;
               continue;
           }

           }
           object[singleValue]=1
        }
     
        
    
    }
    console.log(JSON.stringify(object));
    
    





}


solve(['JS devs use Node.js for server-side JS.-- JS for devs','Far too slow, you\'re far too slow.'])