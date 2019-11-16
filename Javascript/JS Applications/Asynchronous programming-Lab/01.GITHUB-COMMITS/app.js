async function loadCommits() {
    document.querySelector("#commits").textContent="";
    let username=document.querySelector("#username");
    let repoName=document.querySelector("#repo");
    let data
    try{
        data=await getData(`https://api.github.com/repos/${username.value}/${repoName.value}/commits`);
        data.forEach(e=>{
            let li=document.createElement("li");
            li.textContent=`${e.commit.author.name} : ${e.commit.message}`
            document.querySelector("#commits").appendChild(li)
        });
    }catch(e){
    let err=JSON.parse(e.message)
        let li=document.createElement("li");
        li.textContent=`Error: ${err.status}(${err.statusText})`
        document.querySelector("#commits").appendChild(li)
    }




}

function getData(url) {

    return fetch(url).then(data => {
        if (!data.ok) {
            throw  new Error(JSON.stringify({
                statusText:data.statusText,
                status:data.status
            }))
        }
        return data
    }).then(data => data.json());


}