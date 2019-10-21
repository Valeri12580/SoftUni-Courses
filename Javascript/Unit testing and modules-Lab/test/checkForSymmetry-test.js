const expect=require("chai").expect;
const isSymmetric=require("../exercises/checkForSymmetry")

describe("Unit tests for checkForSymmetry",()=>{
    it("should return false if input is incorrect",()=>{
        expect(isSymmetric("incorrect")).to.equal(false)
    })
    it("should return true if array is symmetry",()=>{
        expect(isSymmetric([1,2,2,1])).to.equal(true)
    })
    it("should return false if array is not  symmetry",()=>{
        expect(isSymmetric([1,2,24,112])).to.equal(false)
    })
    it("should return true if array  of strings is   symmetry",()=>{
        expect(isSymmetric(["a","b","b","a"])).to.equal(true)
    })
    it("should return false if array  of strings is  not   symmetry",()=>{
        expect(isSymmetric(["a","b","c","a"])).to.equal(false)
    })
    it("should return false for 1,2,2,1", function () {
        expect (isSymmetric(1,2,2,1)).to.be.equal(false);
    });
    it("should return false for [5,'hi',{a:5},new Date(),{X:5},'hi',5]", function () {
        expect(isSymmetric([5,'hi',{a:5},new Date(),{X:5},'hi',5])).to.be.equal(false);
    });
    it("should return true for [-1,2,-1]", function () {
        expect(isSymmetric([-1,2,-1])).to.be.equal(true);
    })
    it("should return true for [1]", function () {
        expect(isSymmetric([1])).to.be.equal(true);
    });
    it("should return false for [1,2]", function () {
        expect(isSymmetric([1,2])).to.be.equal(false);
    });
    it("should return true for [5,'hi',{a:5},new Date(),{a:5},'hi',5]", function () {
        expect(isSymmetric([5,'hi',{a:5},new Date(),{a:5},'hi',5])).to.be.equal(true);
    });
   
})