function solve() {
	let input =document.getElementById("input").value 
	let sum=calculateSum(input);
	input=splitInput(input,sum)
	let result=""
	let pattern=/[a-zA-Z]+/gm
	let splitRegex=new RegExp(".{1,8}","g")
	input=input.match(splitRegex)
	input=input.forEach(e=>{
		let asciiSymbol=String.fromCharCode(binaryToDecimal(e))
		let pattern=/[a-zA-Z ]+/gm

		if(pattern.test(asciiSymbol)){
			result+=asciiSymbol
		}
	})
	
	document.getElementById("resultOutput").textContent=result

	function binaryToDecimal(e){
		return parseInt(e,2)
		
		
	}
	function splitInput(input,sum){
		 input =input.substring(sum)
		 input=input.substring(0,input.length-sum)
		 return input
	}


	function calculateSum(input){
		
		while(input.toString().length>1){
			input=spreadSum(input)
		}
		
		return input
		
	}
	function spreadSum(num){
		return Array.from(num.toString()).map(Number).reduce((acc,curr)=>acc+curr)
	}


	
}