export abstract class Employee {
    name: string;
    age: number;
    salary: number;
    tasks: string[];

    protected constructor(name: string, age: number,salary:number) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.tasks = [];
    }

    work() {
        let result = this.tasks.shift();
        this.tasks.push(result)
        console.log(this.name+result);
    }


    getSalary(){
        return this.salary;
    }

    collectSalary() {
        return `${this.name} received ${this.getSalary()} this month.`;
    }
}