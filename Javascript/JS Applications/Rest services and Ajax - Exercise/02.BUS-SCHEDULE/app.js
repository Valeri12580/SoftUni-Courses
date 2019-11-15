function solve() {
    let status =document.querySelector("#info > span");
    
    let nextStop="depot";
    let stopName=""
    let departBtn=document.querySelector("#depart");
    let arriveBtn=document.querySelector("#arrive")

    function depart() {
        fetch(`https://judgetests.firebaseio.com/schedule/${nextStop}.json`)
        .then(e=>e.json())
        .then(data=>{
            const {name,next}=data
            
            
            
            stopName=name;
            nextStop=next
            status.textContent=`Next stop ${stopName}`
            departBtn.disabled=true;
            arriveBtn.disabled=false;
        })

       
        

    }

    function arrive() {

        departBtn.disabled=false;
        arriveBtn.disabled=true;
        status.textContent=`Arriving at ${stopName}`

        
    }

    return {
        depart,
        arrive
    };
}

let result = solve();