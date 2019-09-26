function solve(input){
    let pattern=new RegExp("[\/, +]")
    let objects=[]
   
    for (let i = 0; i < input.length; i++) {
        let object={}
        let currentElement=input[i]
        currentElement=currentElement.split(pattern).filter(e=>e!=="")
        object["name"]=currentElement[0];
        object["level"]=+currentElement[1]
        object["items"]=[]
        let k=0
        for (let j = 2; j < currentElement.length; j++) {
            
            object["items"][k]=currentElement[j]
            k++
            
        }
        objects.push(object)
        
    }
    console.log(JSON.stringify(objects))
    



}

solve(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']);