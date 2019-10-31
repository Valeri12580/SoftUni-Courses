class ChekingAccount {

    
    constructor(clientId, email, firstName, lastName) {
        this.setClientId=clientId
        this.setEmail=email;
        this.setFirstName=firstName
        this.setLastName=lastName
    }

    set setClientId(clientId) {
        if (clientId.length < 6 || clientId.length > 6 || typeof clientId.match("[A-Za-z]")===null) {
            throw new TypeError("Client ID must be a 6-digit number")
        }
        this.clientId = clientId
    }
    set setEmail(email){
        let regex=new RegExp("^[A-Za-z]+@[A-Za-z]+.+[A-Za-z]+$")
        if(!regex.test(email)){
            throw new TypeError("Invalid e-mail")
        }
        this.email=email
    }
    set setFirstName(firstName){
        let pat=new RegExp("^[A-Za-z]+$")
        if(firstName.length<3 || firstName.length>20){
            
            throw new TypeError("First name must be between 3 and 20 characters long")
        }else if (!pat.test(firstName)){
            throw new TypeError("First name must contain only Latin characters")
        }
        this.firstName=firstName
        
    }

    set setLastName(lastName){
        let pat=new RegExp("^[A-Za-z]+$")
        if(lastName.length<3 || lastName.length>20){
            
            throw new TypeError("Last name must be between 3 and 20 characters long")
        }else if (!pat.test(lastName)){
            throw new TypeError("Last name must contain only Latin characters")
        }
        this.lastName=lastName
        
    }
}

let accOne=new ChekingAccount("231d32","iv@some.com","Valeri","Stoqdsadsadsadsadsadsadqnov")
