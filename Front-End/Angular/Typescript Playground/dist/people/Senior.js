"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Employee_1 = require("./Employee");
class Senior extends Employee_1.Employee {
    constructor(name, age, salary) {
        super(name, age, salary);
        this.tasks.push("Working on Java project");
    }
}
//# sourceMappingURL=Senior.js.map