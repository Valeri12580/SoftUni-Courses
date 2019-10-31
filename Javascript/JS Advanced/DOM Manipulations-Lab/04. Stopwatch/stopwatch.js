//reshenieto si raboti,no judje ne go priema zaradi date

function stopwatch() {
    let interval;
   let date=createDate()
    let startBtn = document.getElementById("startBtn")
    let stopBtn = document.getElementById("stopBtn")
    
 
    stopBtn.addEventListener("click", stopTimer)

    startBtn.addEventListener("click",startTimer)





    function stopTimer() {

        clearInterval(interval)
        document.getElementById("time").innerText = "00:00"
        date.setSeconds("0")
        date.setMinutes("0")
        stopBtn.disabled = true;
        startBtn.disabled = false
    }


    function startTimer() {

        stopBtn.disabled = false;
        startBtn.disabled = true;
        interval = setInterval(() => {

            date.setSeconds(date.getSeconds() + 1)
            let defaultPattern = `${date.getMinutes()}:${date.getSeconds()}`
            if (date.getMinutes() < 10) {
                defaultPattern = defaultPattern.replace(`${date.getMinutes()}`, `0${date.getMinutes()}`)
            }
            if (date.getSeconds() < 10) {
                defaultPattern = defaultPattern.replace(`${date.getSeconds()}`, `0${date.getSeconds()}`)
            }

            document.getElementById("time").innerText = defaultPattern

        }, 1000)

    }

    function createDate() {
        let date = new Date()
        date.setMinutes("0")
        date.setSeconds("0")
        return date
    }




}

//  document.getElementById("time").innerText=`${date.getMinutes()}:0${date.getSeconds()}`