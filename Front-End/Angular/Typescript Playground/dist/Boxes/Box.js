"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Box = void 0;
class Box {
    constructor() {
        this.data = [];
    }
    add(element) {
        this.data.push(element);
    }
    remove() {
        this.data.pop();
    }
    count() {
        return this.data.length;
    }
}
exports.Box = Box;
//# sourceMappingURL=Box.js.map