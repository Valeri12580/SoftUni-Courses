const lookupChar=require("../charLookUp/charLookUp")
const assert=require("chai").assert;

describe("unit tests for charLookup",()=>{
    it("the function  should return undefined if the first parameter is not a string ",()=>{
        assert.isUndefined(lookupChar(5,0))
    })
    it("the function should return undefined if the second parameter is not a inteter",()=>{
        assert.isUndefined(lookupChar("informatika",{}))
    })
    it("the function should return \"Incorect Index\" if both parameters are of valid types but the integer is  below 0 or >legth",()=>{
        assert.strictEqual(lookupChar("valeri",6),"Incorrect index")
        assert.strictEqual(lookupChar("valeri",-1),"Incorrect index")
    })
    it("if the both parameters are valid,return a character at  specific index",()=>{
        assert.strictEqual(lookupChar("valeri",2),"l")
        
    })
    it("The function should return undefind if the second param is float-point number",()=>{
        assert.isUndefined(lookupChar("valeri",2.5))
        
    })
})