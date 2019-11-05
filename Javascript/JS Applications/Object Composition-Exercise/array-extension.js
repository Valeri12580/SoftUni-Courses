(function solve(){

        Array.prototype.last=function(){
            return this[this.length-1]
        }

        Array.prototype.skip=function(n){
            return this.slice(n)
        }
        Array.prototype.take=function(n){
            return this.slice(0,n)
        }
        Array.prototype.sum=function(){
            return this.reduce((a,b)=>a+b,0)
        }
        Array.prototype.average=function(){
            return this.reduce((a,b)=>a+b,0)/this.length
        }

}())


let arr=[1,2,3,4]
console.log(arr.last());
console.log(arr.skip(1));
console.log(arr.take(2));
console.log(arr.sum(2));
console.log(arr.average());



