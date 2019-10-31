const BookStore=require("./knigaStore")
const assert=require("chai").assert;

describe("testing KnigaStore",()=>{
    let store;
    beforeEach(()=>{
    store=new BookStore("KnigaLand")
    })
    it("test Initialization",()=>{
     
        assert.equal(store.name,"KnigaLand")
        assert.equal(store._workers.length,0)
        assert.equal(store.books.length,0)
    })

    it("test function hire to add successful if there is no workers with same name ",()=>{
      
        assert.equal(store.hire("Valeri","kasier"),"Valeri started work at KnigaLand as kasier")
    })
    it("hire should throw exception",()=>{
        store.hire("Valeri","kasier")
        assert.throw(()=>{
            store.hire("Valeri","kasier")
        },"This person is our employee")
    })

    it("get workers should return number of workers",()=>{
        let valeriWorker={
                name: "Valeri",
                position: "kasier",
                booksSold: 0
            
        }
        store.hire("Valeri","kasier")
        assert.deepEqual(store.workers[0],valeriWorker)
    })
    it("test fire method for throwing a error if there is no such worker",()=>{
        store.hire("Valeri","kasier")
        assert.throw(()=>{
            store.fire("Ivan")
        },"Ivan doesn't work here")
    })
    it("fire should work correctly if there is a worker with that name",()=>{
        store.hire("Valeri","kasier")
        assert.equal(store.fire("Valeri"),"Valeri is fired")
    })
    it("workers length must be decreased if fire is involved",()=>{
        store.hire("Valeri","kasier")
        store.fire("Valeri")
        assert.equal(store._workers.length,0)
    })
    it("stockbook should add book ",()=>{
        store.stockBooks(['Inferno-Dan Braun', 'Harry Potter-J.Rowling', 'Uncle Toms Cabin-Hariet Stow', 'The Jungle-Upton Sinclear']); 
        assert.equal(store.books.length,4)
        assert.deepEqual()
    })
    it("stockbook should return  books when they are added ",()=>{
        let result=store.stockBooks(['Inferno-Dan Braun']); 
        assert.deepEqual(result[0],{title:"Inferno",author:"Dan Braun"})
    })


    it("sellbook should thrown exception if there is no book with that name",()=>{
        store.hire("valeri","kasier")
        store.stockBooks(['Harry Potter-J.Rowling'])
        assert.throw(()=>{
            store.sellBook("sila i klasa","valeri")
        },"This book is out of stock")
    })
    it("sellbook should thrown exception if there no is worker with that name",()=>{
        store.hire("ivan","ciganin")
        store.stockBooks(['Harry Potter-J.Rowling'])
        assert.throw(()=>{
            store.sellBook("Harry Potter","valeri")
        },"valeri is not working here")
    })
    it("after sellbook,the book must be removed",()=>{
        store.hire("ivan","ciganin")
        store.stockBooks(['Harry Potter-J.Rowling'])
        store.sellBook("Harry Potter","ivan")
        assert.equal(store.books.length,0)
    })
    it("print workers should print correctly",()=>{
        store.hire("ivan","ciganin")

        assert.equal(store.printWorkers(),"Name:ivan Position:ciganin BooksSold:0")
    })
})
