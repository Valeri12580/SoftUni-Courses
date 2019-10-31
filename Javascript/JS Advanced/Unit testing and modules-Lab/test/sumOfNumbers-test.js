const expect  = require("chai").expect
const sum = require("../exercises/sumOfNumbers")

describe("Unit testing Sum of Numbers",()=>{
    it("[1,2,3]=>6",()=>{
        expect(sum([1,2,3])).to.equal(6)
    })
    it("[1,1,1]=>3",()=>{
        expect(sum([1,1,1])).to.equal(3)
    })
    it("[-1,2,3]=>4",()=>{
        expect(sum([-1,2,3])).to.equal(4)
    })




})
