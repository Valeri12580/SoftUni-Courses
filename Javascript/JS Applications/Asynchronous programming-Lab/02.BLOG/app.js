function attachEvents() {
    let loadBtn = document.querySelector("#btnLoadPosts");
    let viewBtn = document.querySelector("#btnViewPost");
    let selectMenu = document.querySelector("#posts")
    loadBtn.addEventListener("click", async () => {
        clearPreviousContent.apply(selectMenu)
        let url = getUrl("posts");
        let data = await getData(url)

        Object.keys(data).forEach(e => {
            let opinion = document.createElement("option")
            opinion.textContent = data[e].title;
            opinion.value = e;
            selectMenu.appendChild(opinion);
        })


    })

    viewBtn.addEventListener("click", async () => {
        clearPreviousContent.apply(document.querySelector("#post-comments"))
        let url = getUrl("selectedPost", selectMenu.value)
        let data = await getData(url)
        document.querySelector("#post-title").textContent = data.title;
        document.querySelector("#post-body").textContent = data.body;

        let filteredComments = await findRightComments(data);


        filteredComments.forEach(e => {
            let li = document.createElement("li");
            li.textContent = e.text;
            document.querySelector("#post-comments").appendChild(li)
        })
    })


}

function clearPreviousContent() {

    this.textContent="";
}

async function findRightComments(data) {
    let comments = await findComments();
    comments=Object.keys(comments).reduce((acc, curr) => {

        if (comments[curr].postId === data.id) {
            acc.push(comments[curr])
        }
        return acc

    }, []);
    return comments
}

function findComments() {
    let url = getUrl("comments")
    let data = getData(url)


    return data
}

function getData(url) {

    return fetch(url).then(data => {
        if (!data.ok) {
            throw  new Error("Invalid data!")
        }
        return data
    }).then(data => data.json());


}

function getUrl(type, postId) {
    let url = "https://blog-apps-c12bf.firebaseio.com";
    let typesOfRequest = {
        posts: () => url += "/posts.json",
        selectedPost: () => url += `/posts/${postId}.json`,
        comments: () => url += "/comments.json"
    }

    return typesOfRequest[type]()


}

attachEvents();