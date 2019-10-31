class List{
    list=[]
    size=0;
    constructor(){
       
    }

    add(element){
        this.list.push(element)
        this.list.sort((p1,p2)=>p1-p2)
        this.size++
        return this.arr
        
    }
    remove(index){
       if(index >=0 && index< this.list.length) {
            this.list.splice(index, 1);
            this.list.sort((a,b) => a-b);
            this.size--;
            return this.list;
        }
    }
    get(index){
        if(index >= 0 && index < this.list.length){
            return this.list.slice(index,index+1)[0];
        }
        
    }
    get size(){
        return this.list.length
    }
    
}


let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));


