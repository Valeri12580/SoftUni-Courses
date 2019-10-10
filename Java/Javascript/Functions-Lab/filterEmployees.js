function solve(arr,criteria){
    criteria=criteria.split("-").filter((e)=>e!=="");
  
  
    arr=JSON.parse(arr)
    arr=arr.filter(filterByGivenCriteria)

    function filterByGivenCriteria(e){
        return e[criteria[0]]===criteria[1]
    }
    let result=[]
    
    let currentCount=(function(){
      let counter=0;
      return function(){
        return counter++
      }
    })()


    
    arr.forEach((e)=>{
      result.push(`${currentCount()}. ${e.first_name} ${e.last_name} - ${e.email}`)
      
    })
    

    

    return result.join("\n")
}



console.log(solve(`[{
  "id": "1",
  "first_name": "Kaylee",
  "last_name": "Johnson",
  "email": "k0@cnn.com",
  "gender": "Female"
}, {
  "id": "2",
  "first_name": "Kizzee",
  "last_name": "Johnson",
  "email": "kjost1@forbes.com",
  "gender": "Female"
}, {
  "id": "3",
  "first_name": "Evanne",
  "last_name": "Maldin",
  "email": "emaldin2@hostgator.com",
  "gender": "Male"
}, {
  "id": "4",
  "first_name": "Evanne",
  "last_name": "Johnson",
  "email": "ev2@hostgator.com",
  "gender": "Male"
}]`,
'last_name-Johnson'

));
