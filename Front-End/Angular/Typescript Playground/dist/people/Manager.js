"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Manager = void 0;
const Employee_1 = require("./Employee");
class Manager extends Employee_1.Employee {
    constructor(name, age, salary) {
        super(name, age, salary);
        this.dividend = 0;
        this.tasks.push("Izmuchva raboticite");
    }
    getSalary() {
        return this.salary + this.dividend;
    }
}
exports.Manager = Manager;
//# sourceMappingURL=Manager.js.map