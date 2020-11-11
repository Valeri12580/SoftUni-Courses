import {Employee} from "./Employee";

class Senior extends Employee{


    constructor(name: string, age: number,salary:number) {
        super(name, age,salary);
        this.tasks.push("Working on Java project")
    }
}