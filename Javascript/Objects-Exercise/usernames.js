function solve(arr){
    arr.sort((e1,e2)=>{
        let comp=e1.length-e2.length
        if(comp===0){
            comp=e1.localeCompare(e2)
        }
        return comp
    })
    let result=new Set(arr)
    result.forEach((e1,e2,result)=>{
        console.log(e2)
    })


}

solve(['Ashton',

'Kutcher',

'Ariel',

'Lilly',

'Keyden',

'Aizen',

'Billy',

'Braston'])