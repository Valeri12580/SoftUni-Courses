function solve(input){
    function print(objects){
        for (const key in objects) {
          console.log(key+" :",objects[key])
           
        }


    }
    let objects={}
    let pattern=new RegExp(" <-> ")

    for(let i =0;i<input.length;i++){
        let currentTown=input[i].split(pattern)
        let town=currentTown[0]
        let population=+currentTown[1]
        if(objects.hasOwnProperty(town)){
            objects[town]=objects[town]+population

        }else{
            objects[town]=population
        }

    }

    print(objects)
    
    





}

solve(
    ['Sofia <-> 1200000',

    'Montana <-> 20000',
    
    'New York <-> 10000000',
    
    'Washington <-> 2345000',
    
    'Las Vegas <-> 1000000']
)


