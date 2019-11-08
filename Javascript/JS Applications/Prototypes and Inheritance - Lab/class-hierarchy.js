function classes(){
    class Figure{
        units={
            m:0.01,
            cm:1,
            mm:10
        }
        defaultUnit
        constructor(unit){
            this.defaultUnit=unit
        }
    
        get area(){
            return 0;
        }
        toString(){
            
            
            return `Figures units: ${this.defaultUnit} Area: ${this.area} - `;
        }
    
        changeUnits(unit){
            this.defaultUnit=unit
        }
    }
    
    class Circle extends Figure{
        radius=0;
    
        constructor(radius,unit="cm"){
            super(unit)
            this.radius=radius;
        }
        get area(){
            return Math.PI*this.getRadius*this.getRadius
        }
        get getRadius(){
            return this.radius*this.units[this.defaultUnit]
        }
        toString(){
            return super.toString()+`radius: ${this.radius}`
        }
    }
    
    class Rectangle extends Figure{
        w;
        h;
    
        constructor(w,h,unit="cm"){
            super(unit)
            this.w=w;
            this.h=h
        }
    
        get wget(){
            return this.w*this.units[this.defaultUnit]
        }
        get hget(){
            return this.h*this.units[this.defaultUnit]
        }
        get area(){
            return this.wget*this.hget
        }
        toString(){
            return super.toString()+`width: ${this.wget}, height: ${this.hget}`
        }
    }

    return{
        Figure,Rectangle,Circle
    }
}



let Figure = classes().Figure;
let Rectangle = classes().Rectangle;
let Circle = classes().Circle;

let c =new Circle(5);
console.log(c.area); // 78.53981633974483
console.log(c.toString()); // Figures units: cm Area: 78.53981633974483 - radius: 5

let r = new Rectangle(3, 4, 'mm');
console.log(r.area); // 1200 
console.log(r.toString()); //Figures units: mm Area: 1200 - width: 30, height: 40

r.changeUnits('cm');
console.log(r.area); // 12
console.log(r.toString()); // Figures units: cm Area: 12 - width: 3, height: 4

c.changeUnits('mm');
console.log(c.area); // 7853.981633974483
console.log(c.toString()) // Figures units: mm Area: 7853.981633974483 - radius: 50