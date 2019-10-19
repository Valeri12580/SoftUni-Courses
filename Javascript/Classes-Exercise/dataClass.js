class Request{
  method;
  uri;
  version;
  message;
  response=undefined;
  fulfilled=false


    constructor(m,u,v,msg){
      this.method=m;
      this.uri=u;
      this.version=v;
      this.message=msg
    }


}

let myData = new Request('GET', 'http://google.com', 'HTTP/1.1', '')
console.log(myData);
