function solve(array){
    let object={}
    for (let i = 0; i <array.length ; i+=2) {
        let element=array[i]
        let value=Number(array[i+1])
        object[element]=value;
    }
    console.log(object)
}

solve(['Yoghurt', 48, 'Rise', 138, 'Apple', 52])