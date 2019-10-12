function solve(arr) {
    arr = arr.filter(isEven);
    function isEven(e, i) {
        return i % 2 == 0;
    }
    return arr.join(" ");




}

console.log(solve(['20', '30', '40']));