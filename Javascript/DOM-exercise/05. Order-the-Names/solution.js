function solve() {
    
    let button=document.getElementsByTagName("button")[0]
    button.addEventListener("click",add)
    let ol=document.getElementsByTagName("ol")[0]
    let li =ol.getElementsByTagName("li")

    let db={
        A:[],
        B:[],
        C:[],
        D:[],
        E:[],
        F:[],
        G:[],
        H:[],
        I:[],
        J:[],
        K:[],
        L:[],
        M:[],
        N:["Nixon"],
        O:[],
        P:["Peterson"],
        Q:[],
        R:[],
        S:[],
        T:[],
        U:[],
        v:[],
        W:[],
        X:[],
        Y:[],
        Z:[],

    }


    function add(){
        let input=document.getElementsByTagName("input")[0].value.toLowerCase();
        input=input.replace(input.charAt(0),input.charAt(0).toUpperCase())
        db[input.charAt(0)].push(input)
       let index =Object.keys(db).indexOf(input.charAt(0))
       li[index].innerHTML=db[input.charAt(0)].join(", ")
        
    }
   

    
    

    
}