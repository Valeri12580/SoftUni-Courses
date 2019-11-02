function test(){

    console.log(this);
    
}



let obj={
    
    test:function (params) {
        console.log(this);
        
    }
    
}
obj.test()
