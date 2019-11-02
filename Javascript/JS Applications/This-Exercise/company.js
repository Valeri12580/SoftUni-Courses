class  Company{

    constructor(){
        this.departments=[];
    }
    

    addEmployee(username,salary,position,department){
        this.checkInput(username,salary,position,department)
        let getDepartment=this.departments.find(e=>e.departmentName===department);
        let employee={
            username,
            salary,
            position
        }
        if(!getDepartment){ 

            let obj={
                departmentName:department,
                employees:[],
                averageSalary:function() {
                    return this.employees.reduce((acc,curr)=>{
                        acc+=curr.salary;
                        return acc
                    },0)/obj.employees.length
                }

            }
            obj.employees.push(employee)
            this.departments.push(obj);
           
            
        }else{
            getDepartment.employees.push(employee)
  
        
            
            
        }
        return `New employee is hired. Name: ${username}. Position: ${position}`;
    }


    checkInput(){
    
        if(!arguments[0]  || !arguments[2] || !arguments[3]){
            throw new Error ("Invalid input!")
        }
        if(arguments[1]<0||arguments[1]===""||arguments[1]===undefined || arguments[1]===null){
            throw new Error("Invalid input!")
        }
    }

    

    bestDepartment(){
        let bestDepartment= this.departments.sort((a,b)=>b.averageSalary()-a.averageSalary())[0]
          

        return `Best Department is: ${bestDepartment.departmentName}\nAverage salary: ${bestDepartment.averageSalary().toFixed(2)}\n${bestDepartment.employees.sort((a,b)=>b.salary-a.salary ||a.username.localeCompare(b.username)).map(e=>`${e.username} ${e.salary} ${e.position}`).join("\n")}`
    }

}