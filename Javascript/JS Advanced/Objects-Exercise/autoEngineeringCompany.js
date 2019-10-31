function solve(arr) {

    let obj = {}

    arr.forEach(e => {
        e = e.split(" | ")
        let [brand, model, amount] = [e[0], "###" + e[1], +e[2]]
        if (!obj.hasOwnProperty(brand)) {
            obj[brand] = new Map();

        }
        if (!obj[brand].has(model)) {
            obj[brand].set(model, amount)

        } else {
            let newValue = obj[brand].get(model) + amount
            obj[brand].set(model, newValue)
        }
    });
    

    for (const brand in obj) {
        console.log(brand)
       
    
        obj[brand].forEach((v,k)=>{
            console.log(`${k} - > ${v}`)
        })
        
        
    }
    



}


solve(['Audi | Q7 | 1000',

    'Audi | Q6 | 100',

    'BMW | X5 | 1000',

    'BMW | X6 | 100',

    'Citroen | C4 | 123',

    'Volga | GAZ-24 | 1000000',

    'Lada | Niva | 1000000',

    'Lada | Jigula | 1000000',

    'Citroen | C4 | 22',

    'Citroen | C5 | 10'
])