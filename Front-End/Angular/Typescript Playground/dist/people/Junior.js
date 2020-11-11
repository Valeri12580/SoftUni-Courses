"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Junior = void 0;
const Employee_1 = require("./Employee");
class Junior extends Employee_1.Employee {
    constructor(name, age, salary) {
        super(name, age, salary);
        this.tasks.push(" working on HTML CSS");
    }
}
exports.Junior = Junior;
//# sourceMappingURL=Junior.js.map