import {Employee} from "./Employee";

export class  Manager extends Employee{
    dividend:number;
    constructor(name: string, age: number,salary:number) {
        super(name, age,salary);
        this.dividend=0;
        this.tasks.push("Izmuchva raboticite")
    }


    getSalary(): number {
        return this.salary+this.dividend;
    }
}