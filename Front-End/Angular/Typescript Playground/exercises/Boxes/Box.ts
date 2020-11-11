export class Box<T> {
    private data: T[];


    constructor() {
        this.data = [];
    }


    public add(element: T) {
        this.data.push(element)
    }

    public remove(){
        this.data.pop();
    }

    public count(){
        return this.data.length;
    }

}