function solve(array) {
    let roadType=array[1];
    let speed =array[0]
    let difference=speed;

    if(roadType==="motorway" && speed>130){
        difference-=130;
        console.log(returnedMessage(difference))
    }else if (roadType==="interstate" && speed>90){
        console.log(returnedMessage(difference-=90))
    }else if (roadType==="city" && speed>50){
        console.log(returnedMessage(difference-=50))
    }else if (roadType==='residential' && speed>20){
        console.log(returnedMessage(difference-=20))
    }

    
    

    
}


function returnedMessage(difference) {
    if(difference<=20){
        return "speeding"
    }else if (difference<=40){
        return "excessive speeding"
    }else {
        return "reckless driving"
    }

}


solve([120, 'interstate'])