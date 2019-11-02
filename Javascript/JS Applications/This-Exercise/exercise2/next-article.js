function getArticleGenerator(articles) {
    let articleArray=articles;
    let current=0;
    let div=document.querySelector("#content")

    return function () {
        if(articleArray[current]){
            let article =document.createElement("article");
            article.textContent=articleArray[current++]
            div.appendChild(article)
        }
        
    }


}
