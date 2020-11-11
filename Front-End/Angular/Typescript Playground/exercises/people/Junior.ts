import {Employee} from "./Employee";

export class Junior extends Employee{

    constructor(name: string, age: number,salary:number) {
        super(name, age,salary);
        this.tasks.push(" working on HTML CSS")
    }



}
