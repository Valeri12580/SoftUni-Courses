function solve(array) {
    let number=Number (array[0]);

    for (let i = 1; i < array.length; i++) {
        number=doing(number,array[i])
        console.log(number)
    }
    function doing(number,command){
        switch (command) {
            case "chop":
                return number/=2;
                break;

            case "dice":
                return Math.sqrt(number)
                break;

            case "spice":
                return  number+=1;
                break;
            case "bake":
                return  number*=3;
                break;

            case "fillet":
                return  number-=number*0.20
                break;
        }



    }


}

solve(['32', 'chop', 'chop', 'chop', 'chop', 'chop'])