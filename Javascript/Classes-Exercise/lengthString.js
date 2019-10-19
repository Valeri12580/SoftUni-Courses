class Stringer{
    constructor(string, length){
        this.innerString = string;
        this.innerLength = length;
    }
    decrease(length){
        this.innerLength -= length;
        if(this.innerLength <= 2){
            this.innerLength = 0;
        }
    }

    toString(){
        if(this.innerLength === 0){
            return "...";
        }

        if(this.innerString.length > this.innerLength){
            this.innerString = this.innerString.substr(0, this.innerLength) + "...";
        }
        return this.innerString;
    }

    increase(length){
        this.innerLength += length;
        if(this.innerLength <= 2){
            this.innerLength = 0;
        }
    }

    
    
}