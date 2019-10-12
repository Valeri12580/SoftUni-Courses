function solve() {
    let calculatedHeigth = arguments[3] / 100
    let bmi = Math.round(arguments[2] / (calculatedHeigth * calculatedHeigth))

    let obj = {
        name: arguments[0],
        personalInfo: {
            age: arguments[1],
            weight: arguments[2],
            height: arguments[3]
        },
        BMI: bmi


    }
    calculateStatus(bmi)
    function calculateStatus(bmi) {
        if (bmi < 18.5) {
            obj.status = "underweight"
        } else if (bmi < 25) {
            obj.status = "normal"
        } else if (bmi < 30) {
            obj.status = "overweight"
        } else {
            obj.recommendation = "admission required"
            obj.status = "obese"


        }





    }
    return obj


}



console.log(solve("Honey Boo Boo", 9, 57, 137));
