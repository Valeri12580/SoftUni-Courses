export abstract class Melon{
    public weight:number;
    public melonSort:string;
    private _elementIndex:number;
    public type:string;


    protected constructor(weight: number, melonSort: string) {
        this.weight = weight;
        this.melonSort = melonSort;
        this._elementIndex=weight*melonSort.length;
    }


    get elementIndex(): number {
        return this._elementIndex;
    }

    toString(){
        return `Element: ${this.type}
    Sort: ${this.melonSort}
    Element Index: ${this._elementIndex}`

    }
}
