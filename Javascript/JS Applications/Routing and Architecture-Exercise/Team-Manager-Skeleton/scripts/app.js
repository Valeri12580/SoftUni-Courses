import {post,get,del,put} from "./requester.js"

(()=>{
    let commonPartials={
        header:"./templates/common/header.hbs",
        footer:"./templates/common/footer.hbs"

    }
    function credentials(ctx){
        ctx.loggedIn=sessionStorage.getItem("authtoken")!==null
        ctx.username=sessionStorage.getItem("username")
        ctx.password=sessionStorage.getItem("password")
    }

    const app = Sammy("#main",function(e){
        this.use("Handlebars","hbs")
        
        this.get("#/register",function(ctx){
            commonPartials["registerForm"]="./templates/register/registerForm.hbs"
            this.loadPartials(commonPartials).then(function(){
                
                this.partial("./templates/register/registerPage.hbs")
                
            })
        })
       
        this.get("#/home",loadHome)
        this.get("#/",loadHome)
           
            
        this.get("#/login",function(ctx){
            commonPartials["loginForm"]="./templates/login/loginForm.hbs"
           this.loadPartials(commonPartials).then(function(){
                this.partial("./templates/login/loginPage.hbs")
               
               
           })

            
        })
        this.get("#/logout",function(ctx){
            sessionStorage.clear()
            ctx.redirect("#/")
        })

        this.get("#/catalog",function(ctx){
            commonPartials["team"]="./templates/catalog/team.hbs";
            get("appdata","teams","Kinvey").then((data)=>{
                ctx.teams=data;
                console.log(data);
                

                this.loadPartials(commonPartials).then(function (){
                    this.partial("./templates/catalog/teamCatalog.hbs")
                })
            })

        })

        this.get("#/catalog/:id",function(ctx){
            let id=ctx.params.id
            commonPartials["teamMember"]="./templates/catalog/teamMember.hbs"
            commonPartials["teamControls"]="./templates/catalog/teamControls.hbs"

            get("appdata",`teams/${id}`,"Kinvey").then((data)=>{
                console.log(data);
                
                ctx.name=data.name;
                ctx.description=data.description;
                this.loadPartials(commonPartials).then(function(){
                    this.partial("./templates/catalog/details.hbs")
                })

            }).catch(console.error)
        })


        this.get("#/create",function(cthx){
            commonPartials["createForm"]="./templates/create/createForm.hbs"

            this.loadPartials(commonPartials).then(function(){
                this.partial("./templates/create/createPage.hbs")
            })
        })

        this.get("#/about",function(ctx){
            credentials(ctx)
            this.loadPartials(commonPartials).then(function(){
                this.partial("./templates/about/about.hbs")
            })
        })
        this.post("#/create",function(ctx){
            const {name,description}=ctx.params;
            post("appdata","teams",{name,description},"Kinvey").then((data)=>{
                ctx.redirect("#/catalog")
            }).catch(console.error)
        })

        this.post("#/register", function(ctx){
            let {username,password,repeatPassword}=ctx.params
            
            
            
            if(password!==repeatPassword){
                alert("The repeated password in not the same!")
            }else{
                post("user","",{username,password},"Basic").then(data=>{
                    console.log(data);
                    
                    ctx.redirect("#/login")
                }).catch(console.error)
            }
        
        })

        this.post("#/login",function(ctx){
            let {username,password}=ctx.params;
            console.log(username,password);
            
            post("user","login",{username,password},"Basic").then(data=>{
                console.log(data);
                
                    sessionStorage.setItem("authtoken",data._kmd.authtoken)
                    sessionStorage.setItem("username",data.username)
                    ctx.redirect("#/")
            }).catch(console.error)
        })

        
    })
   

    function loadHome(ctx){
 
      //ctx i this sa edno i sushto
    credentials(ctx)
    
        
       this.loadPartials(commonPartials).then(function(e){
           
           this.partial("./templates/home/home.hbs")
       })
    }



    app.run();



})()
