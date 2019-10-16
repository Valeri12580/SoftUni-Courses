function subtract() {
        let firstInput=document.getElementById("firstNumber")
        let secondInput=document.getElementById("secondNumber")
        
        let distractedNumbers=Number(firstInput.value)-Number(secondInput.value)

        document.getElementById("result").textContent=distractedNumbers
}