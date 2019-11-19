//znam che kodut ne e dobre strukturiran,no nqmah vreme
function attachEvents() {

    domElements().loadBtn().addEventListener("click", loadContent)
    domElements().addBtn().addEventListener("click", addContent)
}

attachEvents();


async function addContent() {
    let angler = document.querySelector("#addForm > input.angler").value;
    let weight = document.querySelector("#addForm > input.weight").value;
    let species = document.querySelector("#addForm > input.species").value;
    let location = document.querySelector("#addForm > input.location").value;
    let bait = document.querySelector("#addForm > input.bait").value;
    let captureTime = document.querySelector("#addForm > input.captureTime").value;
    let body = {
        angler,
        weight,
        species,
        location,
        bait,
        captureTime
    }
    fetchData().addData(body)


}

async function loadContent() {
    Array.from(document.getElementById("catches").children).slice(1).forEach(e=>e.remove())
    let data = await fetchData().loadData();



    Object.keys(data).forEach(key => {
        let copyOfCatch = document.querySelector("#catches > div").cloneNode(true);
        copyOfCatch.setAttribute("data-id", key);

        Object.keys(data[key]).forEach(prop => {

            copyOfCatch.querySelector(`input.${prop}`).value = data[key][prop]
        });

        attachEventListenersToCatches(copyOfCatch);


        domElements().divCatch().appendChild(copyOfCatch)
    })
    function attachEventListenersToCatches(copyOfCatch) {
        copyOfCatch.children[18].addEventListener("click", function (e) {
            fetchData().updateData(copyOfCatch.getAttribute("data-id"))
        })

        copyOfCatch.children[19].addEventListener("click", function (e) {
            fetchData().deleteData(copyOfCatch.getAttribute("data-id"))
            copyOfCatch.remove().catch(e=>console.error)
        })
    }
}


function fetchData() {
    const basicUrl = "https://fisher-game.firebaseio.com/catches";

    return {
        loadData: () => fetch(basicUrl + ".json").then(e => e.json()),
        addData: (body) => {
            fetch(basicUrl + ".json", {
                method: "POST",
                body: JSON.stringify(body),
                headers: {
                    "Content-Type": "application/json"
                }

            }).then(e => e.json()).catch(e=>console.error)
        },
        deleteData: (id) => {
            fetch(basicUrl + `/${id}.json`, {
                method: "DELETE"
            }).catch(e=>console.error)

        },
        updateData: (id) => {
            let inputs = document.querySelectorAll(`[data-id=${id}]`)[0].getElementsByTagName('input');

            let newContent = {
                angler: inputs[0].value,
                weight: inputs[1].value,
                species: inputs[2].value,
                location: inputs[3].value,
                bait: inputs[4].value,
                captureTime: inputs[5].value
            };
            fetch(basicUrl + `/${id}.json`, {
                method: "PUT",
                body: JSON.stringify(newContent)
            }).catch(e=>console.error)
        }

    }

}

function domElements() {
    return {
        loadBtn: () => document.querySelector("body > aside > button"),
        divCatch: () => document.querySelector("#catches"),
        addBtn: () => document.querySelector("#addForm > button"),


    }
}



