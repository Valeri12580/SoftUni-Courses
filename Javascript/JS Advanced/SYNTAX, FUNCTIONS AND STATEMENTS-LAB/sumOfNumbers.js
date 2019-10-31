parseNumbers("1", "12");




function parseNumbers(n, m) {
    let num1 = parseInt(n);
    let num2 = parseInt(m);
    let result = 0;
    for (let i = num1; i <= num2; i++) {

        result += i
    }
    console.log(result)


}



