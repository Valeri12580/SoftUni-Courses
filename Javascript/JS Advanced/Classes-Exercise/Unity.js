class Rat{
    name;
    unitedRats=[];

    constructor(name){
        this.name=name
    }

    unite(rat){
        if(rat instanceof Rat){
            this.unitedRats.push(rat)
        }
    }

    getRats(){
        return this.unitedRats
    }
    toString(){
        let returnedString=`${this.name}\n`
        this.unitedRats.forEach(e=>returnedString+=`##${e.name}\n`)
        return returnedString
    }
}
let firstRat = new Rat("Peter");
console.log(firstRat.toString()); // Peter
 
console.log(firstRat.getRats()); // []

firstRat.unite(new Rat("George"));
firstRat.unite(new Rat("Alex"));
console.log(firstRat.getRats());
// [ Rat { name: 'George', unitedRats: [] },
//  Rat { name: 'Alex', unitedRats: [] } ]

console.log(firstRat.toString());
