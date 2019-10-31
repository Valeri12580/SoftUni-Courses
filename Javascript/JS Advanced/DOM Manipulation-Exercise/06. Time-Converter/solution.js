function attachEventsListeners() {
    letConvertFrom={
        "days":(v)=>{
            let hours=v*24;
            let minutes=hours*60
            let seconds=minutes*60;

            return [hours,minutes,seconds]
        },
        "hours":(v)=>{
            let days=v/24;
            let minutes=v*60;
            let seconds=minutes*60
            return [days,minutes,seconds]
        },
        "minutes":(v)=>{
            let seconds=v*60;
            let hours=v/60;
            let days=hours/24;
            return [hours,days,seconds]
        },
        "seconds":(v)=>{
            let minutes=v/60;
            let hours=minutes/60
            let days=hours/24
            return[minutes,hours,days]
        }
    }


    let daysInput=document.getElementById("days")
    let hoursInput=document.getElementById("hours")
    let minutesInput=document.getElementById("minutes")
    let secondsInput=document.getElementById("seconds")

    let buttons=document.querySelectorAll('input[type=button]')

    Array.from(buttons).map(x=>x.addEventListener("click",function convert(){
        if(this.id==="daysBtn"){
            handInformation("days",daysInput.value,hoursInput,minutesInput,secondsInput)
        }else if (this.id==="hoursBtn"){
           handInformation("hours",hoursInput.value,daysInput,minutesInput,secondsInput)
        }else if (this.id==="minutesBtn"){
            handInformation("minutes",minutesInput.value,hoursInput,daysInput,secondsInput)
        }else{
            handInformation("seconds",secondsInput.value,minutesInput,hoursInput,daysInput)
        }
    }))


    function handInformation(type,value,firstI,secondI,thirdI){
        [firstUnit,secondUnit,thirdUnit]=letConvertFrom[type](value)
        firstI.value=firstUnit
        secondI.value=secondUnit;
        thirdI.value=thirdUnit;
    }
}