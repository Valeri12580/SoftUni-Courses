import {post,get,put,del} from "./requester.js"

/*sessionStorage.setItem("username",e.username);
                    sessionStorage.setItem("password",e.password)
                    sessionStorage.setItem("authtoken",e._kmd.authtoken)
                    sessionStorage.setItem("_id",e._id) 

*/
let commonTemplates={

    header:"../templates/common/header.hbs",
    footer:"../templates/common/footer.hbs"
}
function displayError(){
    alert("Something is wrong!")
}

function setCredentials(ctx){
    ctx.isLogged=sessionStorage.getItem("authtoken")!==null;
    ctx.username=sessionStorage.getItem("username")
    ctx._id=sessionStorage.getItem("_id");
}
let app =Sammy("body",function(e){
    this.use("Handlebars","hbs")

    this.get("#/",function(ctx){
        setCredentials(ctx)

        get("appdata","treks","Kinvey").catch(console.error).then(e=>{
          
            
            ctx.treks=e;
            
            this.loadPartials(commonTemplates).partial("../templates/home.hbs")
        }).catch(console.error)
        
    })

    this.get("#/login",function(ctx){
        this.loadPartials(commonTemplates).partial("../templates/login.hbs")
    })

    this.post("#/login",function(ctx){
        let {username,password}=ctx.params;
        
        post("user","login",{username,password},"Basic").then(e=>{
            sessionStorage.setItem("username",e.username);
                    sessionStorage.setItem("password",e.password)
                    sessionStorage.setItem("authtoken",e._kmd.authtoken)
                    sessionStorage.setItem("_id",e._id) 

                    ctx.redirect("#/")
        }).catch(displayError)
        
    })

    this.get("#/register",function(ctx){
        this.loadPartials(commonTemplates).partial("../templates/register.hbs")
    })
    this.post("#/register",function(ctx){
        let {username,password,rePassword}=this.params;
        //vij go posle
        if(username.length<3 ||password.length<6 || password!==rePassword){
            alert("Your credentials are invalid!")
        }else{
            post("user","",{username,password},"Basic").then(e=>{
                sessionStorage.setItem("username",e.username);
                sessionStorage.setItem("password",e.password)
                sessionStorage.setItem("authtoken",e._kmd.authtoken)
                sessionStorage.setItem("_id",e._id)

                ctx.redirect("#/")
            })
        }
    })

    this.get("#/logout",function(ctx){
        post("user","_logout",{},"Kinvey").then(e=>{
            sessionStorage.clear();
            ctx.redirect("#/")
        })
    })


    this.get("#/create",function(ctx){
        setCredentials(ctx)
        this.loadPartials(commonTemplates).partial("../templates/create.hbs")
    })

    this.post("#/create",function(ctx){
        let {location,dateTime,description,imageURL}=this.params;
        let date=dateTime;
        let organizer=sessionStorage.getItem("username");
        let likes=0;
        if(location.length<6 || description.length<10){
           alert("Location must be a at least 6 characters long and description must be a at least 10 characters long!")
        }else{
            post("appdata","treks",{location,date,description,imageURL,organizer,likes}).then(e=>{
                ctx.redirect("#/")
            })
        }
    })

    this.get("#/details/:id",function(ctx){
        let id =this.params.id;
        setCredentials(ctx)
        get("appdata",`treks/${id}`,"Kinvey").then(e=>{
            if(e._acl.creator===sessionStorage.getItem("_id")){
                ctx.isCreator=true;
            }else{
                ctx.isCreator=false;
            }
            ctx.treck=e;
            
            
            this.loadPartials(commonTemplates).partial("../templates/details.hbs")
        })
    })

    this.get("#/edit/:id",function(ctx){
        setCredentials(ctx);
        let id =this.params.id;

        get("appdata",`treks/${id}`,"Kinvey").then(e=>{
            ctx.treck={

            }

            ctx.treck.location=e.location;
            ctx.treck.date=e.date;
            ctx.treck.description=e.description
            ctx.treck.imageURL=e.imageURL;
            ctx.treck._id=id
            ctx.treck.likes=e.likes;
            ctx.treck.organizer=e.organizer

            this.loadPartials(commonTemplates).partial("../templates/edit.hbs")

        })

    })

    this.post("#/edit/:id",function(ctx){
        let id =this.params.id;
      
        
        let {location,dateTime,description,imageURL,organizer,likes}=this.params;
        let date=dateTime;

        put("appdata",`treks/${id}`,{location,date,description,imageURL,organizer,likes},"Kinvey").then(e=>{
            
            
            ctx.redirect("#/")
        }).catch(console.error)

    })

    this.get("#/like/:id",function(ctx){
        let id =this.params.id;

        get("appdata",`treks/${id}`,"Kinvey").then(e=>{
            e.likes=+e.likes+1;

            put("appdata",`treks/${id}`,e,"Kinvey").then(e=>{

                ctx.redirect(`#/details/${id}`)
            })
        })
    })

    this.get("#/delete/:id",function(ctx){
        let id =this.params.id;
        del("appdata",`treks/${id}`,"Kinvey").then(e=>{
            ctx.redirect("#/")
        })
    })

    this.get("#/profile/:id",function(ctx){
        let id=this.params.id;
        setCredentials(ctx)
        get("appdata","treks","Kinvey").then(e=>{
            let createdByThisUser=e.filter((e)=>e._acl.creator===id)
            ctx.count =createdByThisUser.length;
            ctx.treks=createdByThisUser;
            
            
            
            this.loadPartials(commonTemplates).partial("../templates/user.hbs")
        })
       
        
    })



})


app.run()