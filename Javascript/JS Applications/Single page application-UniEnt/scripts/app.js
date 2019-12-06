import {get,post,put,del} from "./requester.js";




(()=>{


    function displaySuccess(message){
        let div=document.querySelector("#successBox");
        div.style.display="block";
        div.textContent=message;
        setTimeout(()=>{
            div.style.display="none"
        },5000)
    }
    function displayError(message){
        let div=document.querySelector("#errorBox");
        div.style.display="block";
        div.textContent=message;
        setTimeout(()=>{
            div.style.display="none"
        },5000)
    }


    let commonPartials={
        header:"../templates/common/header.hbs",
        footer:"../templates/common/header.hbs",
        notifications:"../templates/notifications.hbs"
    }

    function setHeaderInfo(ctx){
        ctx.isLogged=sessionStorage.getItem("authtoken")!==null;
        ctx.username=sessionStorage.getItem("username");
        ctx._id=sessionStorage.getItem("_id");
    }
   

    let app=Sammy("#root",function(e){
        this.use("Handlebars","hbs")

        this.get("/",function(ctx){
           
            setHeaderInfo(ctx)

            get("appdata","events","Kinvey").catch(console.error).then(e=>{
                ctx.events=e;
                
                this.loadPartials(commonPartials).partial("../templates/home.hbs")
            }).catch(console.error)
            
           

        })

        this.get("/login",function(ctx){
            

            this.loadPartials(commonPartials).partial("../templates/login.hbs")
        })

        this.post("/login",function(ctx){
            let {username,password}=ctx.params;

            post("user","login",{username,password},"Basic").then(e=>{
                sessionStorage.setItem("username",e.username);
                    sessionStorage.setItem("password",e.password)
                    sessionStorage.setItem("authtoken",e._kmd.authtoken)
                    sessionStorage.setItem("_id",e._id)
                    displaySuccess("Login is successful!Redirecting after 5 seconds...")
                   setTimeout(()=>{
                    ctx.redirect("/")
                   },5000) 

                    
                   
            }).catch(displayError("Error!")) //tuk displayvame errorite sled validaciite
        })



        this.get("/register",function(ctx){

            this.loadPartials(commonPartials).partial("../templates/register.hbs")
        })


        //tuk cathvame error 
        this.post("/register",function(ctx){
            let {username,password,rePassword}=this.params;
            try{
                if(password!==rePassword){
                    throw new Error("Passwords are not the same")
                 }else{
                     post("user","",{username,password},"Basic").then(e=>{
                         
                         
                         sessionStorage.setItem("username",e.username);
                         sessionStorage.setItem("password",e.password)
                         sessionStorage.setItem("authtoken",e._kmd.authtoken)
                         sessionStorage.setItem("_id",e._id)
                         displaySuccess("Register is successful!Redirecting after 5 seconds...")
                        setTimeout(()=>{
                         ctx.redirect("/")
                        },5000) 
                             
                         })
                 }
            }catch(e){
                displayError(e.message)
            }

            
            
        })
        this.get("/logout",function(ctx){
            post("user","_logout",{},"Kinvey").then(e=>{
                sessionStorage.clear();
                ctx.redirect("/")
            })
            
            
        })


        this.get("/create",function(ctx){

            this.loadPartials(commonPartials).partial("../templates/create.hbs")
        })

        this.post("/create",function(ctx){
            let {name,date,description,imageURL}=ctx.params;
            let event={
                name,
                date,
                description,
                imageURL,
                organizer:sessionStorage.getItem("username"),
                peopleInterestedIn:0
            }
            post("appdata","events",event,"Kinvey").then(e=>{
                
                displaySuccess("The event is created successful!Redirecting after 5 seconds...")
                setTimeout(()=>{
                 ctx.redirect("/")
                },5000) 
                
            })
        })


        this.get("/details/:id",function(ctx){
            setHeaderInfo(ctx)
            
            let id =ctx.params.id;
            get("appdata",`events/${id}`,"Kinvey").then(e=>{
            

                if(e._acl.creator===sessionStorage.getItem("_id")){
                    e.isCreator=true;
                }else{
                    e.isCreator=false;
                }
                ctx.event=e
                this.loadPartials(commonPartials).partial("../templates/details.hbs")
                
            })
        })

        this.get("/edit/:id",function(ctx){
            setHeaderInfo(ctx);
            let _id =ctx.params.id
           
            get("appdata",`events/${_id}`,"Kinvey").then(data=>{
               
                ctx.event={

                }
              
                
                ctx.event.name=data.name;
                ctx.event.description=data.description;
                ctx.event.date=data.date;
                ctx.event.imageURL=data.imageURL;
                ctx.event._id=_id;
                ctx.event.peopleInterestedIn=data.peopleInterestedIn;
                ctx.event.organizer=data.organizer;
                
                
                this.loadPartials(commonPartials).partial("../templates/edit.hbs")
            })

        })

        this.post("/edit/:id",function(ctx){
            let _id =this.params.id;
            let {name,date,description,imageURL,peopleInterestedIn,organizer}=this.params;
            let editedEvent={
                name,date,description,imageURL,peopleInterestedIn,organizer
            }
            
            
            
            put("appdata",`events/${_id}`,editedEvent,"Kinvey").then(e=>{
                
                displaySuccess("Edited!Redirecting after 5 seconds...")
                   setTimeout(()=>{
                    ctx.redirect("/")
                   },5000) 
                
            })
        })
        
        this.get("/close/:id",function(ctx){
            del("appdata",`events/${this.params.id}`,"Kinvey").then(e=>{
                
                displaySuccess("Deleted!!Redirecting after 5 seconds...")
                   setTimeout(()=>{
                    ctx.redirect("/")
                   },5000) 
                
            })
        })

        this.get("/join/:id",function(ctx){
            let id =this.params.id
                get("appdata",`events/${id}`,"Kinvey").then(e=>{
                    e.peopleInterestedIn=+e.peopleInterestedIn+1
                    
                    
                    put("appdata",`events/${id}`,e,"Kinvey").then(data=>{
                        displaySuccess("You are joined !Redirecting after 5 seconds...")
                   setTimeout(()=>{
                    ctx.redirect(`/details/${id}`)
                   },5000) 
                       
                        
                    })
                    
                })

        })

        this.get(`/profile/:id`,function(ctx){
            let id=this.params.id;
            setHeaderInfo(ctx)
            get("appdata","events","Kinvey").then(e=>{
                let createdByThisUser=e.filter((e)=>e._acl.creator===id)
                ctx.count =createdByThisUser.length;
                ctx.eventsByUser=createdByThisUser;
                
                
                
                this.loadPartials(commonPartials).partial("../templates/profile.hbs")
            })

        })



    })




    app.run()





})()