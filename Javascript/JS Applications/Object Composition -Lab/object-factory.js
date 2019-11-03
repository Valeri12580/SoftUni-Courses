function composer(input){
let parsed=JSON.parse(input);
let obj={}
parsed.forEach(e=>Object.assign(obj,e))

return obj


}


solve(`[{"canFly": true},{"canMove":true, "doors": 4},{"capacity": 255},{"canFly":true, "canLand": true}]`)