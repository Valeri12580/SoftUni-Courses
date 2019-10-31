function result(){
    let arr=[]
    function solve(area, vol, input) {
           JSON.parse(input).map(e=>{
            return{
                area:Math.abs(area.call(e)),
                volume:Math.abs(vol.call(e))
            }
            
        }).forEach(e=>arr.push(e) )
      
      return arr
          
      
      }
      function vol() {
          return this.x * this.y * this.z;
      };
      
      
      
      function area() {
          return this.x * this.y;
      };
      
      
      console.log(solve(area, vol, '[{"x":"1","y":"2","z":"10"},{"x":"7","y":"7","z":"10"},{"x":"5","y":"2","z":"10"}]'));
      
}
program()

