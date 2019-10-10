function solve(num) {
    return function (append) {
        return num + append
    }
}



let add5=solve(5);
console.log(add5(2));
console.log(add5(2));


