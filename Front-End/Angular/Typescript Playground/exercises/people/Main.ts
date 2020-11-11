
import {Junior} from "./Junior";
import {Manager} from "./Manager";
let junior=new Junior("Valeri",20,15000);
junior.work()

console.log(junior.salary);
let manager=new Manager("kacho",15,552);
manager.dividend=100000;
console.log(manager.collectSalary());