function  getFibonator() {
    let number=0;
   let array=[0,0] //0,0,1,1,2,3,5,8
    return function fib(){
        if(array.length===2){
            array.push(1)
            return 1
        }
        number=array[array.length-1]+array[array.length-2]
        array.push(number)
        return number ;
    }
    
}
let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13

