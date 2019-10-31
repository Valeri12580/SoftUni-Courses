const  isOddOrEven=require("../evenOrOdd/isOddOrEven")
let expect=require("chai").expect;

describe("testing oddOrEven",()=>{
    it("input data is not string should return undefind",()=>{
        expect(isOddOrEven(321)).to.be.undefined
    })
    it("the function must return even if the input string's length is even",()=>{
        expect(isOddOrEven("da")).to.equal("even")
    })
    it("the function must return odd if the input string's length is odd",()=>{
        expect(isOddOrEven("dad")).to.equal("odd")
    })

})