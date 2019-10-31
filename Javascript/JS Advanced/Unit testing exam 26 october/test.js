let SkiResort = require("../Unit testing exam 26 october/solution")
let assert = require("chai").assert


describe("test for ski resort", () => {
    let res = new SkiResort("Some")
    beforeEach(() => {
        res = new SkiResort("Some")
    })
    it("constructor should create instantion properly and successful", () => {
        assert.equal(res.name, "Some")
        assert.equal(res.voters, 0)
        assert.deepEqual(res.hotels, [])
    })



    it("should return proper message if the are no hotels", () => {
        res.build("Sun", 10)
        assert.equal(res.bestHotel, "No votes yet");
    })
    it("should return best hotel", () => {
        res.build("Sun", 10)
        res.book('Sun', 5)
        res.leave('Sun', 3, 1)
        res.build("Avenue", 10)
        res.book('Avenue', 5)
        res.leave('Avenue', 5, 3)


        assert.equal(res.bestHotel, "Best hotel is Avenue with grade 15. Available beds: 10")
    })



    //testvai ako iska po podrobno da se testva za vkarvaneto na hoteli
    it("build should throw error if name is invalid", () => {
        assert.throw(() => {
            res.build("", 5)
        }, Error, "Invalid input")
    })
    it("build should error if beds are invalid", () => {
        assert.throw(() => {
            res.build("Klisura", 0)
        }, Error, "Invalid input")
    })
    it("build should return message when w given parameters are true", () => {
        res.build("Klisura", 5)
        assert.equal(res.build("Klisura", 5), "Successfully built new hotel - Klisura")
    })


    it("if input parameters are invalid,must throw error", () => {
        res.build("Klisura", 10)
        assert.throw(() => {
            res.book("", 10)
        }, Error, "Invalid input")
        assert.throw(() => {
            res.book("Klisura", 0)
        }, Error, "Invalid input")
    })
    it("should throw error if there is no such hotel", () => {
        assert.throw(() => {
            res.book("rozino", 5)
        }, Error, "There is no such hotel")
    })
    it("should throw error if there is no free beds", () => {
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        assert.throw(() => {
            res.book("Klisura", 3)
        }, Error, "There is no free space")
    })
    it("should return proper message if everything is correct", () => {
        res.build("Klisura", 4);
        assert.equal(res.book("Klisura", 4), "Successfully booked")
    })

    it("if invalid parameters are given to leave, must throw error", () => {
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        assert.throw(() => {
            res.leave("", 5, 5)
        }, Error, "Invalid input")
        assert.throw(() => {
            res.leave("klisura", 0, 5)
        }, Error, "Invalid input")
    })

    it ("if name of hotel is not in the list,must throw error", () => {
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        assert.throw(() => {
            res.leave("Rozino", 5, 1)
        }, Error, "There is no such hotel")
    })
    it("if everything is alright,leave must remove clients with proper message",()=>{
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        assert.equal(res.leave("Klisura",2,2),"2 people left Klisura hotel")
    })

    it("if everything is alright,leave must remove clients ",()=>{
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        res.leave("Klisura",2,2)
        assert.equal(res.hotels[0].beds,4)
    })

    it("average should return proper message if there are no voters",()=>{
        assert.equal(res.averageGrade(),"No votes yet")
    })

    it("average should return averageGrade if everything is okay",()=>{
        res.build("Klisura", 4);
        res.book("Klisura", 2)
        res.leave("Klisura",2,2)
        assert.equal(res.averageGrade(),"Average grade: 2.00")
    })



})

 //res.build("Klisura", 4);
// res.book("Klisura", 2)