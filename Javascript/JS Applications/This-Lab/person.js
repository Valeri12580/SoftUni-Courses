class Person{
    _first
    _last
    constructor(firstName,lastName){
        this._first=firstName;
        this._last=lastName;

    }

    get firstName(){
        return this._first
    }
    set firstName(name){
        this._first=name
    }


    get lastName(){
        return this._last
    }
    set lastName(name){
        this._last=name
    }

    get fullName(){
        return `${this.firstName} ${this.lastName}`
    }

    set fullName(name){
        let split=name.split(" ")
        if(split.length===2){
            this.firstName=split[0]
            this.lastName=split[1]
        }
    }
}
let person = new Person("Peter", "Ivanov");
console.log(person.fullName);//Peter Ivanov
person.firstName = "George";
console.log(person.fullName);//George Ivanov
person.lastName = "Peterson";
console.log(person.fullName);//George Peterson
person.fullName = "Nikola Tesla";
console.log(person.firstName)//Nikola
console.log(person.lastName)//Tesla
