function getInfo() {
    let stopId=document.getElementById("stopId").value;
    let stopName=document.getElementById("stopName");
    let listBuses=document.getElementById("buses");

    stopName.textContent="";
    listBuses.textContent=""
    fetch(`https://judgetests.firebaseio.com/businfo/${stopId}.json`)
    .then(data=>data.json()).then(data=>{
    let {name,buses}=data
    stopName.append(name)
    Object.entries(buses).forEach(([numOfStop,minutes])=>{
        let li=document.createElement("li");
        li.textContent=`Bus ${numOfStop} arrives in ${minutes}`
        listBuses.appendChild(li)
    })
        
        
        
    }).catch((err)=>{
        stopName.textContent="Error"
    });


}
    