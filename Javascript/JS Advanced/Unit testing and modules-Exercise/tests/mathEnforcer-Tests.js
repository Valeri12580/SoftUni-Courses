const mathEnforcer = require("../Math Enforcer/mathEnforcer")
const expect = require("chai").expect;

describe("tests for math enforcer", () => {
    describe("addFive's tests", () => {
        it("addFive should  return undefined if the input parameter is not a number", () => {
            expect(mathEnforcer.addFive("da")).to.be.undefined
        })
        it("addFive should add 5 to a given parameter(number)", () => {
            expect(mathEnforcer.addFive(5)).to.equal(10)
        })
        it("addFive should add 5 to a given negative  parameter(number)", () => {
            expect(mathEnforcer.addFive(-3)).to.equal(2)
        })
        it("addFive should add 5 to a given floating point  parameter(number)", () => {
            expect(mathEnforcer.addFive(2.5)).to.be.closeTo(7.5,0.01)
        })

    })


    describe(" subtractTen's tests", () => {
        it("subtractTen should return undefined if the input parameter is not a number", () => {
            expect(mathEnforcer.subtractTen({})).to.be.undefined
        })
        it("addFive should subtract 10 to a given parameter(number)", () => {
            expect(mathEnforcer.subtractTen(12)).to.equal(2)
        })
        it("addFive should subtract 10 to a given negative parameter(number)", () => {
            expect(mathEnforcer.subtractTen(-12)).to.equal(-22)
        })
        it("subtractTen should subtract 10 to a given float type parameter(number)", () => {
            expect(mathEnforcer.subtractTen(12.5)).to.be.closeTo(2.5,0.01)
        })
    })

    describe("sum func's tests", () => {
        it("sum function should return undefined if parameter one or parameter two are invalid", () => {
            expect(mathEnforcer.sum(5, "valeri")).to.be.undefined
            expect(mathEnforcer.sum(new Object(), 5)).to.be.undefined
            expect(mathEnforcer.sum([1, 2, 3], "valeri")).to.be.undefined
        })
        it("sum function should work correct with 2 valid integers", () => {
            expect(mathEnforcer.sum(1, 2)).to.equal(3)
        })
        it("sum function should work correct with 2 valid negative integers ", () => {
            expect(mathEnforcer.sum(-1, -2)).to.equal(-3)
        })
        it("sum function should work correct with 2 floating points parameters parameters", () => {
            expect(mathEnforcer.sum(1.75,1.75)).to.be.closeTo(3.5,0.01)
        })
    })


})