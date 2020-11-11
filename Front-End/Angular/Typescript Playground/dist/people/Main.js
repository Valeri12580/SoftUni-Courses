"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Junior_1 = require("./Junior");
const Manager_1 = require("./Manager");
let junior = new Junior_1.Junior("Valeri", 20, 15000);
junior.work();
console.log(junior.salary);
let manager = new Manager_1.Manager("kacho", 15, 552);
manager.dividend = 100000;
console.log(manager.collectSalary());
//# sourceMappingURL=Main.js.map