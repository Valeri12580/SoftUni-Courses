"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Employee = void 0;
class Employee {
    constructor(name, age, salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.tasks = [];
    }
    work() {
        let result = this.tasks.shift();
        this.tasks.push(result);
        console.log(this.name + result);
    }
    getSalary() {
        return this.salary;
    }
    collectSalary() {
        return `${this.name} received ${this.getSalary()} this month.`;
    }
}
exports.Employee = Employee;
//# sourceMappingURL=Employee.js.map