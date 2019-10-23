const StringBuilder = require("../StringBuilder/string-builder")
const assert = require("chai").assert

describe("tests for StringBuilder class", () => {

    describe("check if validation function is working", () => {

        it("Checking validation func", () => {
            assert.throw(() => new StringBuilder(15), "Argument must be string")






        })

    })
    describe("test instantion", () => {
        it("if the param is undefined  ,inner property must be empty array", () => {
            stringBuilderObject = new StringBuilder(undefined)
            assert.isArray(stringBuilderObject._stringArray)
            assert.isEmpty(stringBuilderObject._stringArray)
        })
        it("if the param is empty  ,inner property must be empty array", () => {
            stringBuilderObject = new StringBuilder()
            assert.isArray(stringBuilderObject._stringArray)
            assert.isEmpty(stringBuilderObject._stringArray)
        })
        it("if the param is string  ,inner property must the same string as array", () => {
            stringBuilderObject = new StringBuilder("valeri")
            assert.deepEqual(stringBuilderObject._stringArray, ["v", "a", "l", "e", "r", "i"])
        })

    })
    let stringBuilderObject;
    beforeEach(() => {
        stringBuilderObject = new StringBuilder("v")
    })
    describe("tests for append function", () => {

        it("append should add parameter to the end in the storage", () => {
            stringBuilderObject.append("hello")
            assert.deepEqual(stringBuilderObject._stringArray, ["v", "h", "e", "l", "l", "o"])
            assert.throw(() => stringBuilderObject.append(52), "Argument must be string")

        })
    })
    describe("test for prepend function", () => {
        it("prepend should add parameter to the begining of the storage", () => {

            stringBuilderObject.prepend("a")
            assert.deepEqual(stringBuilderObject._stringArray, ["a", "v"])
            assert.throw(() => stringBuilderObject.prepend(52), "Argument must be string")

        })
    })
    describe("test for insertAt function", () => {
        it("insertAt should add parameter to the given index in the storage", () => {

            stringBuilderObject.append("a")
            stringBuilderObject.insertAt("k", 1)
            assert.deepEqual(stringBuilderObject._stringArray, ["v", "k", "a"])
            describe("tests for StringBuilder class", () => {

                describe("check if validation function is working", () => {

                    it("Checking validation func", () => {
                        assert.throw(() => new StringBuilder(15), "Argument must be string")






                    })

                })
                describe("test instantion", () => {
                    it("if the param is undefined  ,inner property must be empty array", () => {
                        stringBuilderObject = new StringBuilder(undefined)
                        assert.isArray(stringBuilderObject._stringArray)
                        assert.isEmpty(stringBuilderObject._stringArray)
                    })
                    it("if the param is empty  ,inner property must be empty array", () => {
                        stringBuilderObject = new StringBuilder()
                        assert.isArray(stringBuilderObject._stringArray)
                        assert.isEmpty(stringBuilderObject._stringArray)
                    })
                    it("if the param is string  ,inner property must the same string as array", () => {
                        stringBuilderObject = new StringBuilder("valeri")
                        assert.deepEqual(stringBuilderObject._stringArray, ["v", "a", "l", "e", "r", "i"])
                    })

                })
                let stringBuilderObject;
                beforeEach(() => {
                    stringBuilderObject = new StringBuilder("v")
                })
                describe("tests for append function", () => {

                    it("append should add parameter to the end in the storage", () => {
                        stringBuilderObject.append("hello")
                        assert.deepEqual(stringBuilderObject._stringArray, ["v", "h", "e", "l", "l", "o"])
                        assert.throw(() => stringBuilderObject.append(52), "Argument must be string")

                    })
                })
                describe("test for prepend function", () => {
                    it("prepend should add parameter to the begining of the storage", () => {

                        stringBuilderObject.prepend("a")
                        assert.deepEqual(stringBuilderObject._stringArray, ["a", "v"])
                        assert.throw(() => stringBuilderObject.prepend(52), "Argument must be string")

                    })
                })
                describe("test for insertAt function", () => {
                    it("insertAt should add parameter to the given index in the storage", () => {

                        stringBuilderObject.append("a")
                        stringBuilderObject.insertAt("k", 1)
                        assert.deepEqual(stringBuilderObject._stringArray, ["v", "k", "a"])
                        assert.throw(() => stringBuilderObject.insertAt(2, 1), "Argument must be string")

                    })
                })
                describe("test for remove function", () => {
                    it("remove should remove elements from given positivon", () => {

                        stringBuilderObject.append("a")
                        stringBuilderObject.append("b")
                        stringBuilderObject.append("c")
                        stringBuilderObject.remove(1, 1)
                        assert.deepEqual(stringBuilderObject._stringArray, ["v", "b", "c"])

                    })
                })
                describe("test for toString Function", () => {
                    it("toString should work correct", () => {

                        stringBuilderObject.append("a")
                        stringBuilderObject.append("b")
                        stringBuilderObject.append("c")

                        assert.equal(stringBuilderObject.toString(), "vabc")

                    })
                    it("_vrfyParam with number", function() {
                        assert.throws(() => StringBuilder._vrfyParam(3), TypeError, `Argument must be string`);
                        });
                })
            })

        })
    })
    describe("test for remove function", () => {
        it("remove should remove elements from given positivon", () => {

            stringBuilderObject.append("a")
            stringBuilderObject.append("b")
            stringBuilderObject.append("c")
            stringBuilderObject.remove(1, 1)
            assert.deepEqual(stringBuilderObject._stringArray, ["v", "b", "c"])

        })
    })
    describe("test for toString Function", () => {
        it("toString should work correct", () => {

            stringBuilderObject.append("a")
            stringBuilderObject.append("b")
            stringBuilderObject.append("c")

            assert.equal(stringBuilderObject.toString(), "vabc")

        })
    })
})
