const expect  = require("chai").expect
const sum = require("../exercises/subSum")

describe("unit testing ", function() {
    it("[1,1]=>2", function () {
        expect(sum([1, 1])).to.equal(2)
    })
    it("([1,1,1],2)=>9",()=>{
        expect(sum([1,1,1],1)).to.equal(2)
    })
    it("([1,1,1,1],2)=>9",()=>{
        expect(sum([1,1,1,1],1,2)).to.equal(2)
    })
    it("([1,1,1,1,1],2,9)=>9",()=>{
        expect(sum([1,1,1,1,1],2,9)).to.equal(3)
    })
    it("([1,1,1,1,1],-1,1)=>2",()=>{
        expect(sum([1,1,1,1,1],-1,1)).to.equal(2)
    })
    it("(\"Valeri\",-1,1)=>NaN",()=>{
        expect(isNaN(sum("valeri",1,1))).to.equal(true)
    })
    it("([1,Valeri,1],0,2)=>NaN",()=>{
        expect(Number.isNaN(sum([10, 'twenty', 30, 40], 0, 2))).to.equal(true)
    })
})
