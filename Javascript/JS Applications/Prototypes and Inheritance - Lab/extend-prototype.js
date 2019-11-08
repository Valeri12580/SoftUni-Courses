function  solve(Class) {
    Class.prototype.species="Human";
    Class.prototype.toSpeciesString=function(){
        return `I am a ${Class.prototype.species}. ${this.toString()}`
    }
}

let obj={
    name:"valeri"
}
console.log(obj);
