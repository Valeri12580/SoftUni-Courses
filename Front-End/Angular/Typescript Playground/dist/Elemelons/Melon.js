"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Melon = void 0;
class Melon {
    constructor(weight, melonSort) {
        this.weight = weight;
        this.melonSort = melonSort;
        this._elementIndex = weight * melonSort.length;
    }
    get elementIndex() {
        return this._elementIndex;
    }
    toString() {
        return `Element: ${this.type}
    Sort: ${this.melonSort}
    Element Index: ${this._elementIndex}`;
    }
}
exports.Melon = Melon;
//# sourceMappingURL=Melon.js.map