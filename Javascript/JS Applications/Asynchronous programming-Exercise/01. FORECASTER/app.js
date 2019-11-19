function attachEvents() {

    let getWeatherBtn = document.querySelector("#submit");
    let input=document.querySelector("#location");
    let currentCondition=document.querySelector("#current");
    let upcomingCondition=document.querySelector("#upcoming");

    getWeatherBtn.addEventListener("click",async function () {

        if(  currentCondition.children[1] && upcomingCondition.children[1]){
           clearPreviousResult(currentCondition,upcomingCondition)
        }

        try{
            let rawData=await getData(getUrl().location());
            let code=findCode(input.value,rawData).code;

            currentCondition.appendChild(processCurrentCondition(await getData(getUrl().currentCondition(code))));

            upcomingCondition.appendChild(processThreeDayConditions(await getData(getUrl().threeDayForecast(code))));
            document.querySelector("#forecast").style="";
        }catch(e){
            document.querySelector("#forecast").style="display:none";
            alert(e.message)
        }
    })
}

function  processThreeDayConditions(data) {
        let div=document.createElement("div");
        div.className="forecasts-info";

    for (let i = 0; i < 3; i++) {

        let span=document.createElement("span");
        span.className="upcoming";
        let currentDay=data.forecast[i];

        span.appendChild(createThreeSpansForThreeDayCondition(currentDay));
        div.appendChild(span)
    }
    return div

}
function  clearPreviousResult(currentCondition,upcomingCondition) {
    currentCondition.removeChild(currentCondition.children[1]);
    upcomingCondition.removeChild(upcomingCondition.children[1])
}
function  createThreeSpansForThreeDayCondition(currentDay) {
    let condition=currentDay.condition;
    let {high,low}=currentDay

    let fragment=document.createDocumentFragment();

    for (let i = 0; i <3; i++) {
        let span=document.createElement("span");
        span.className="forecast-data";
        fragment.appendChild(span)
    }

    fragment.children[0].className="symbol";
    fragment.children[0].innerHTML=conditionIcon()[condition];
    fragment.children[1].innerHTML=`${low}${conditionIcon().Degrees}/${high}${conditionIcon().Degrees}`;
    fragment.children[2].textContent=condition;
    return fragment
}

function processCurrentCondition(data) {

   let div=document.createElement("div");
   div.className="forecasts";

   let conditionSymbolSpan=document.createElement("span");
   conditionSymbolSpan.className="condition symbol";
   conditionSymbolSpan.innerHTML=conditionIcon()[data.forecast.condition];

   let conditionSpan=document.createElement("span");
   conditionSpan.className="condition";
   conditionSpan.appendChild(createThreeSpansForCurrentPosition(data));

   div.append(conditionSymbolSpan,conditionSpan);

return div

}

function  createThreeSpansForCurrentPosition(data) {
    let place=data.name;
    let {condition,high,low}=data.forecast;

    let fragment=document.createDocumentFragment();
    for (let i = 0; i <3; i++) {
        let span=document.createElement("span");
        span.className="forecast-data";
        fragment.appendChild(span)
    }
    fragment.children[0].textContent=place;
    fragment.children[1].innerHTML=`${low}${conditionIcon().Degrees}/${high}${conditionIcon().Degrees}`;
    fragment.children[2].textContent=condition;
    return fragment
}

function  conditionIcon() {
    return {
        "Sunny":"&#x2600;",
        "Partly sunny":"&#x26C5;",
        "Overcast":"&#x2601;",
        "Rain":"&#x2614;",
        "Degrees":"&#176;"
    }
}

function findCode(input,rawData) {
    let result=rawData.find(e=>e.name===input);
    if(!result) throw  new Error("Error!")
    return result;
}

function  getUrl() {
    let res= {
        location:()=>"https://judgetests.firebaseio.com/locations.json",
        currentCondition:(code)=>`https://judgetests.firebaseio.com/forecast/today/${code}.json`,
        threeDayForecast:(code)=>`https://judgetests.firebaseio.com/forecast/upcoming/${code}.json`
    }
    return res;

}

function getData(url) {
    return fetch(url).then(data=>{
        if(!data.ok){
            throw  new Error("Error!")
        }
        return data
    }).then(data=>data.json())
}

attachEvents();