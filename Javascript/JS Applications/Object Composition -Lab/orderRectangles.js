function solve(input) {
    let result = [];

    input.forEach(e => {
        let width = e[0];
        let height = e[1];
        function area() {
            return this.width * this.height;
        }

        function compareTo(otherObj){
            return otherObj.area() - this.area() || otherObj.width - this.width;
        }

        let obj={
            width,
            height,
            area,
            compareTo
        }
      
        
        result.push(obj)
    })
    return result.sort((a,b)=>a.compareTo(b))

}