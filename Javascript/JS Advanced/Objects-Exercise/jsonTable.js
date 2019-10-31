function solve(arr){
    String.prototype.escape = function() {
        var tagsToReplace = {
            '&': '&amp;',
            '<': '&lt;',
            '>': '&gt;'
        };
        return this.replace(/[&<>]/g, function(tag) {
            return tagsToReplace[tag] || tag;
        });
    };
    let result="<table>\n"
    for (let j = 0; j < arr.length; j++) {
        let parsedArguments=JSON.parse(arr[j])
        
        

   
        let name=parsedArguments["name"]
        name=name.escape()
        let position=parsedArguments["position"]
        position=position.escape()
        let salary=parsedArguments["salary"]
        result+=`    <tr>\n       <td>${name}</td>\n       <td>${position}</td>\n       <td>${salary}</td> \n    </tr>\n`
        
    
        
    }
    
    result+="</table>"

    console.log(result)








}

solve([
    '{"name":"Pesho","position":"Promenliva","salary":100000}',
    '{"name":"Teo","position":"Lecturer","salary":1000}',
    '{"name":"Georgi","position":"Lecturer","salary":1000}'
  ])


