function test(){



    fetch("https://blog-apps-c12bf.firebaseio.com/posts.json").then(data=>data.json()).then(console.log);
    console.log(1)
}