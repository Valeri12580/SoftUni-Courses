let personOne={name:"Valeri"
,age:19,
printName:function (){
    
    
    console.log(this.name);
    
}}
personOne.printName()


let numbers=[1,2,3]
console.log(...numbers);



let personTwo=personOne;
personTwo.name="Ciganin"
console.log(personOne);
console.log(personTwo);

let personThree=personOne;
console.log(personThree);
personThree.name="Ivan"
console.log(personOne);
console.log(personTwo);
console.log(personThree);
let personFour={...personOne}
personFour.name="Pesho";
console.log(personFour);
console.log(personOne);
console.log(personTwo);
console.log(personThree);

class test{

}

let test2=new test();

console.log(typeof test2);



function cha(){
    console.log("cha");
    
}

console.log({cha});


let obj={
    setName:function(){
        this.name="valeri"
    }
}

obj.setName()
console.log(obj);







