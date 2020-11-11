class DataRequest{
    method:string;
    uri:string;
    version:string;
    message:string;
    response:string;
    fulfilled:boolean;

    constructor(method:string,uri:string,version:string,message:string){
        this.method=method;
        this.uri=uri;
        this.version=version;
        this.message=message;
    }

    print():string{
        return `Method:${this.method}\nUri:${this.uri}\nVersion:${this.version}\nMessage:${this.message}\nResponse:${this.response}\n
        Fulfilled:${this.fulfilled}`
    }
}



let response=new DataRequest("POST","www.test.com.","HTTP 1.1","This is a test message")
console.log(response.print())


