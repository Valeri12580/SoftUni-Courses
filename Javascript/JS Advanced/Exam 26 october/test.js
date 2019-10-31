let arrayOfobjects=[]
arrayOfobjects.push({name:"Valeri",age:18},{name:"Ciganin",age:19})


arrayOfobjects=arrayOfobjects.map(e=>`${e.name}------${e.age}`)

console.log(arrayOfobjects);
