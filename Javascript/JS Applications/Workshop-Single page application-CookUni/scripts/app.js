import {get,post,put,del} from "./requester.js"
(()=>{

   function setHeaderCredentials(ctx){
        ctx.isLogged=sessionStorage.getItem("authtoken")!==null
        ctx.fullName=sessionStorage.getItem("fullName");
        ctx.password=sessionStorage.getItem("password")
        ctx._id=sessionStorage.getItem("_id")
    }
    

    let commonPartials={
        header:"../templates/common/header.hbs",
        footer:"../templates/common/footer.hbs"
    }

        let app=Sammy("#rooter",function(e){
            this.use("Handlebars","hbs")
           
            

            this.get("/",function(ctx){
                setHeaderCredentials(ctx)
                commonPartials["recipes"]="../templates/recipes.hbs"
                if(ctx.isLogged){
                    
                    get("appdata","recipes","Kinvey").then(e=>{
                        console.log(e,"test");
                        ctx.recipes=e
                        
                        
                         this.loadPartials(commonPartials).partial("../templates/home.hbs")
                    })

                }else{
                    this.loadPartials(commonPartials).partial("../templates/home.hbs")
                }
               
            })


            this.get("/register",function(ctx){
                this.loadPartials(commonPartials).partial("../templates/register.hbs")
            })

            //proveri q 
            this.post("/register",function(ctx){
                let {username,password,firstName,lastName}=ctx.params
                post("user","",{username,password,firstName,lastName,password},"Basic").then(e=>{
                    ctx.redirect("/login")
                }).catch(console.error)
                

            })

            this.get("/login",function(ctx){
                
                this.loadPartials(commonPartials).partial("../templates/login.hbs")
            })

            this.post("/login",function(ctx){
                let {username,password}=ctx.params;

                post("user","login",{username,password},"Basic").then(e=>{
                    sessionStorage.setItem("_id",e._id);
                    sessionStorage.setItem("fullName",e.firstName+" "+e.lastName);
                    sessionStorage.setItem("authtoken",e._kmd.authtoken);
                    
                    ctx.redirect("/")

                }).catch(console.error)
            })

            this.get("/logout",function(ctx){

                post("user","_logout",{},"Kinvey").then(e=>{
                
                    
                    sessionStorage.clear()

                    ctx.redirect("/")
                })

            })



            this.get("/share",function(ctx){
                this.loadPartials(commonPartials).partial("../templates/share.hbs")
            })


            this.post("/share",function(ctx){
                    let {meal,ingredients,prepMethod,foodImageURL,description,category}=this.params
                    let categories={
                        "Grain Food":"https://cdn.pixabay.com/photo/2014/12/11/02/55/corn-syrup-563796__340.jpg",
                        "Milk, chees, eggs and alternatives":"https://image.shutterstock.com/image-photo/assorted-dairy-products-milk-yogurt-260nw-530162824.jpg",
                        "Lean meats and poultry, fish and alternatives":"https://t3.ftcdn.net/jpg/01/18/84/52/240_F_118845283_n9uWnb81tg8cG7Rf9y3McWT1DT1ZKTDx.jpg",
                        "Vegetables and legumes":"https://cdn.pixabay.com/photo/2017/10/09/19/29/eat-2834549__340.jpg",
                        "Fruits":"https://cdn.pixabay.com/photo/2017/06/02/18/24/fruit-2367029__340.jpg",


                    }
           
                    
                    post("appdata","recipes",{
                        meal,
                        ingredients:ingredients.split(","),
                        prepMethod,
                        description,
                        category,
                        foodImageURL,
                        categoryImageURL:categories[category],
                        likesCounter:0

                    }).then(e=>{
                        ctx.redirect("/")
                    })

                    
                    

            })

            this.get("/recipe/:id",function(ctx){
                setHeaderCredentials(ctx)
                get("appdata",`recipes/${ctx.params.id}`,"Kinvey").then(e=>{
                    e.isCreator=sessionStorage.getItem("_id")===e._acl.creator;
                   
                    console.log(e);
                    
                    ctx.recipe=e
                    this.loadPartials(commonPartials).partial("../templates/info.hbs")
                    
                    
                })
               
            })

            this.get("/edit/:id",function(ctx){
                setHeaderCredentials(ctx)
                get("appdata",`recipes/${ctx.params.id}`,"Kinvey").then(e=>{
                    e.isCreator=sessionStorage.getItem("_id")===e._acl.creator;
                   
                    console.log(e);
                    
                    ctx.recipe=e
                    this.loadPartials(commonPartials).partial("../templates/edit.hbs")
                    
                    
                })
                
             
                
            })

            this.post("/edit/:id",function(ctx){
                let id =this.params.id;
                let {meal,ingredients,prepMethod,foodImageURL,description,category}=this.params
                put("appdata",`recipes/${id}`,{meal,ingredients:ingredients.split(","),prepMethod,foodImageURL,description,category},"Kinvey").then(e=>{
                    ctx.redirect("/")
                });

              
            })

            this.get("/archive/:id",function(ctx){
                let id = this.params.id;
                console.log(id);
                
                del("appdata",`recipes/${id}`,"Kinvey")
                ctx.redirect("/")
            })

            this.get("/like/:id",function(ctx){
                let id =this.params.id;
               get("appdata",`recipes/${id}`,"Kinvey").then(e=>{
               
                let el=document.querySelector("#rooter > div > div > div.recepieInfo > div.actions > a").textContent.slice(0,2);
                e.likesCounter=+el+1
                

                put("appdata",`recipes/${id}`,e,"Kinvey").then(e=>{
                    
                    ctx.redirect(`recipe/${id}`)
                    
                })
                
               })
                
               
            })

        })


        app.run()


})()