class DataRequest {
    constructor(method, uri, version, message) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
    }
    print() {
        return `Method:${this.method}\nUri:${this.uri}\nVersion:${this.version}\nMessage:${this.message}\nResponse:${this.response}\n
        Fulfilled:${this.fulfilled}`;
    }
}
let response = new DataRequest("POST", "www.test.com.", "HTTP 1.1", "This is a test message");
console.log(response.print());
//# sourceMappingURL=data-class.js.map