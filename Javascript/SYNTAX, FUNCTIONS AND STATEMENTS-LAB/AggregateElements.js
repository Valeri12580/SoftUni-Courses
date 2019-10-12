
function solve(...params) {

    console.log(params.reduce(sum))
    console.log(params.join(""))
    
    function sum() {
        let sum =0;
        for (let i = 0; i < params.length; i++) {
            sum+=params[i];
        }
        return sum;

    }
    
}

solve(1,2,3)