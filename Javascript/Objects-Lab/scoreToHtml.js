


function solve(input) {
    let objects = JSON.parse(input)
    let result="<table>\n   <tr><th>name</th><th>score</th></tr>\n";
    String.prototype.escape = function() {
        var tagsToReplace = {
            '&': '&amp;',
            '<': '&lt;',
            '>': '&gt;',
            '"':'&quot;',
            '\'':'&#39;'};
        return this.replace(/[&<>'"]/g, function(tag) {
            return tagsToReplace[tag] || tag;
        });
    };
    
    




    for (let index = 0; index < objects.length; index++) {
        let object=objects[index]
        
        let name=object.name
        let score =object.score

        name=name.escape();
        score=String(score).escape();
        result+=`   <tr><td>${name}</td><td>${score}</td></tr>`
        result+="\n"
        
        
    }
    result+="</table>"



    console.log(result);
 
}
    

solve(['[{"name":"Pesho","score":479},{"name":"Gosho","score":205}]'])