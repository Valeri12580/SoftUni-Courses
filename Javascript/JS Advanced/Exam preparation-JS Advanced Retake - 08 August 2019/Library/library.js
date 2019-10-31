//ne raboti 

class Library{

    constructor(libraryName){
        this.libraryName=libraryName;
        this.subscribers=[];
        this.subscriptionTypes={
            normal:this.libraryName.length,
            special:this.libraryName.length*2,
            vip:Number.MAX_SAFE_INTEGER
        }

    }

       
}

let lib = new Library('Lib');

lib.subscribe('Peter', 'normal');
lib.subscribe('John', 'special');

lib.receiveBook('John', 'A Song of Ice and Fire', 'George R. R. Martin');
lib.receiveBook('Peter', 'Lord of the rings', 'J. R. R. Tolkien');
lib.receiveBook('John', 'Harry Potter', 'J. K. Rowling');
console.log(lib);
