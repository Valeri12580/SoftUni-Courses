function findGCD(x,y){
    while(y){
        let temp=y;
        y=x%y;
        x=temp
    }
    console.log(x)

    


}

findGCD(48,18)