function solve(input){
    let collection=[]

    let commandInterpeter={
      
        add:(name)=>{
            collection.push(name)
        },
        remove:(name)=>{
           collection=collection.filter(e=>e!==name);
        },
        print:()=>{
            console.log(collection.join(","));
            
        }
    }

    input.forEach(e=>{
        let [command,name]=e.split(" ")
        commandInterpeter[command](name)
    })
}


solve(['add pesho', 'add george', 'add peter', 'remove peter','print'])
