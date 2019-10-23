let PaymentPackage=require("../paymentPackage/paymentPackage")
const assert=require("chai").assert

describe("PaymentPackage", function(){
    
 
    it("constructor with valid p", function() {
        var actual = new PaymentPackage("str", 5);
        assert.equal(actual.value, 5);
        assert.equal(actual.name, "str");
        assert.equal(actual.VAT, 20);
        assert.equal(actual.active, true);
    });
 
   
    it("constructor with 2 p", function() {
        let actual = new PaymentPackage("str", 5);
 
        assert.equal("str", actual.name);
        assert.equal(5, actual.value);
        assert.equal(20, actual.VAT);
        assert.equal(true, actual.active)
    });
 
    it("constructor with 1 p", function() {
        assert.throws(() => new PaymentPackage(5), Error, 'Name must be a non-empty string');
    });
 
    it("constructor with no params", function() {
        assert.throws(() => new PaymentPackage(), Error, 'Name must be a non-empty string');
    });
    it("constructor with 1 params", function() {
        assert.throws(() => new PaymentPackage("str"), Error, 'Value must be a non-negative number');
    });
    it("non-string name get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal("str", actual.name);
 
        assert.throws(() => actual.name = true, Error, 'Name must be a non-empty string');
    });
 
    it("name get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal("str", actual.name);
 
        actual.name = "new";
        assert.equal("new", actual.name);
    });
 
    
 
    it("empty name get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal("str", actual.name);
 
        assert.throws(() => actual.name = "", Error, 'Name must be a non-empty string');
    });
 
    it("value get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal(5, actual.value);
 
        actual.value = 10;
        assert.equal(10, actual.value);
    });
 
    it("negative value get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal("str", actual.name);
 
        assert.throws(() => actual.value = -5, Error, 'Value must be a non-negative number');
    });
 
    it("non-number value get/set", function() {
        let actual = new PaymentPackage("str", 5);
        assert.equal("str", actual.name);
 
        assert.throws(() => actual.value = "aa", Error, 'Value must be a non-negative number');
    });
 
    it("zero value get/set", function() {
        let actual = new PaymentPackage("str", 5);
        actual.value = 0;
 
        assert.equal(actual.value, 0);
    });
 
    it("non-number VAL get/set", function() {
        let actual = new PaymentPackage("str", 5);
 
        assert.throws(() => actual.VAT = "a", Error, 'VAT must be a non-negative number');
    });
 
    it("negative VAL get/set", function() {
        let actual = new PaymentPackage("str", 5);
 
        assert.throws(() => actual.VAT = -5, Error, 'VAT must be a non-negative number');
    });
 
    it("zero VAL get/set", function() {
        let actual = new PaymentPackage("str", 5);
        actual.VAT = 0;
 
        assert.equal(actual.VAT, 0);
    });
 
    it("boolean active get/set", function() {
        let actual = new PaymentPackage("str", 5);
        actual.active = false;
        assert.equal(actual.active, false);
    });
 
    it("non-boolean active get/set", function() {
        let actual = new PaymentPackage("str", 5);
 
        assert.throws(() => actual.active = 5, Error, 'Active status must be a boolean');
    });
 
    it("toString() with active", function() {
        let actual = new PaymentPackage("str", 5);
 
        assert.equal(actual.toString(), "Package: str\n- Value (excl. VAT): 5\n- Value (VAT 20%): 6");
    });
 
    it("toString() with inactive", function() {
        let actual = new PaymentPackage("str", 5);
        actual.active = false;
 
        assert.equal(actual.toString(), "Package: str (inactive)\n- Value (excl. VAT): 5\n- Value (VAT 20%): 6");
    });
});