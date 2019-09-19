calculate(5,6,"+");




function calculate(firstNumber,secondNumber,operand){
    var sum;
    switch (operand) {
        case "+":
            sum=firstNumber+secondNumber;

            break;
        case "-":
            sum=firstNumber-secondNumber;
            break;

        case "*":
            sum=firstNumber*secondNumber;
            break;

        case "/":

            sum=firstNumber/secondNumber;
            break;

        case "%":

            sum=firstNumber%secondNumber;

            break;

        case "**":
            sum=firstNumber**secondNumber;

            break;
    }
    console.log(sum);

}   