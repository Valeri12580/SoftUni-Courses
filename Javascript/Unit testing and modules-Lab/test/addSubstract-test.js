const expect=require("chai").expect
const createCalculator=require("../exercises/addSubstract")


describe("unit tests for addSubstract",()=>{
    let obj
    beforeEach(()=>{
        obj= createCalculator()
    })
    
    it("add should add numbers",()=>{
    
      obj.add(5)
      obj.add(10)
        expect(obj.get()).to.equal(15)
         obj.add(10)
         expect(obj.get()).to.equal(25)
    })
    it("subtract should subtract numbers",()=>{
    
        obj.add(5)
        obj.add(10)
        obj.subtract(10)
          expect(obj.get()).to.equal(5)
      })
      it("subtract should parse string number and  subtract  it",()=>{
    
        obj.add(5)
        obj.add(10)
        obj.subtract("10")
          expect(obj.get()).to.equal(5)
      })

      it("add should parse string number and  add  it",()=>{
    
        obj.add(5)
        obj.add("10")
        
          expect(obj.get()).to.equal(15)
      })
      it("get should return internal sum",()=>{
    
        obj.add(5)
        obj.add("10")
        
          expect(obj.get()).to.equal(15)
      })




})