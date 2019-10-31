function solution(){
    str=""
    function  fuck (){
            console.log("ti si idiot");
            
    }
    return  {
       
        "append":(s)=>str+=s,
        "removeStart":(n)=>str=str.substring(n),
        "removeEnd":(n)=>str=str.substring(0,str.length-n),
        "print":()=>console.log(str)
    }
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print()
