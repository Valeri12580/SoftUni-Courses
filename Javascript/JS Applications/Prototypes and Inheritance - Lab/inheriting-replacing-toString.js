function solve(){

    class Person{
        constructor(name,email){
            this.name=name;
            this.email=email;
        }

        
        
    }
    Person.prototype.toString=function(){
        
      
        if(this instanceof Student){
        
            
            return`Student (name: ${this.name}, email: ${this.email}, course: ${this.course})` 
        }else if (this instanceof Teacher){
           
            return  `Teacher (name: ${this.name}, email: ${this.email}, subject: ${this.subject})`
        }else if (this instanceof Person){
            return   `Person (name: ${this.name}, email: ${this.email})` 
        }
       }
    

    
    class Teacher extends Person{
        constructor(name,email,subject){
            super(name,email)
            this.subject=subject
        }
        
        
       
    }


    class Student extends Person{
        constructor(name,email,course){
            super(name,email);
            this.course=course;
        }
    }

    return {
        Person,Teacher,Student
    }


    
    
   

   
    
}

let Student=solve().Student;
let Teacher=solve().Teacher;
let Person=solve().Person;
let uchenik=new Student("Valeri","valsdasd","Js");
console.log(uchenik.toString());


