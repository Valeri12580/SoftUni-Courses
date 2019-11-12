function solve(){
    class Melon{

        constructor(weight,melonSort){
            if(new.target===Melon){
                throw new TypeError("Abstract class cannot be instantiated directly!")
            }
            this.weight=weight;
            this.melonSort=melonSort;
    
        }
    
      get   elementIndex(){
          return this.weight*this.melonSort.length;
    
      }
    
      toString(){
          return `Element: ${this.element}\nSort: ${this.melonSort}\nElement Index: ${this.elementIndex}`
      }
    
    
    
    }
    class Watermelon extends Melon{
        constructor(weight,melonSort){
            super(weight,melonSort)
            this.element="Water";
        }
    }
    class Firemelon extends Melon{
        constructor(weight,melonSort){
            super(weight,melonSort)
            this.element="Fire";
        }
    }
    class Earthmelon extends Melon{
        constructor(weight,melonSort){
            super(weight,melonSort)
            this.element="Earth";
        }
    }
    class Airmelon extends Melon{
        constructor(weight,melonSort){
            super(weight,melonSort)
            this.element="Air";
        }
    }
    
    class Melolemonmelon extends Watermelon{
        _arrayElements=["Fire","Earth","Air"]
        constructor(weight,melonSort){
            super(weight,melonSort)
          
        }
    
        morph(){
            
            this._arrayElements.push(this.element)
            this.element=this._arrayElements.shift()
    
        }
    }

    return {Melon,Watermelon,Firemelon,Earthmelon,Airmelon,Melolemonmelon}
}



let morph = new Melolemonmelon(12.5, "Kingsize");
console.log(morph.toString());

// Element: Water
// Sort: Kingsize
// Element Index: 100
