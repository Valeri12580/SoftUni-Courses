const username = "Valeri";
const password = "1234";
const appKey = "kid_ByKqubE3H";
const appSecret = "kid_ByKqubE3H";
const baseUrl = "https://baas.kinvey.com"

function makeHeaders(httpMethod, data) {
    const header = {
        method: httpMethod,
        headers: {
            "Authorization": `Basic ${btoa(`${username}:${password}`)}`,
            "Content-Type": "application/json"
        }


    };
    if (httpMethod === "POST" || httpMethod === "PUT") {
        header.body = JSON.stringify(data)
    }
    return header
}

function handleErrors(e) {
    if (e.ok) {
        throw  new Error("Error!")
    }
    return e;
}

function serializelizeData(x) {
    return x.json();
}

export function get(kinveyModule, endpoint) {
    const header = makeHeaders("GET");
    const url = `${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;

    return fetch(url, header).then(serializelizeData).then(handleErrors);
}

export function put(kinveyModule, endpoint, data) {
    const header = makeHeaders("PUT", data);
    const url = `${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}
export  function  post(kinveyModule,endpoint,data) {
    const  header=makeHeaders("POST",data)
    let url=`${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}
export  function  del(kinveyModule,endpoint,id) {
    const header=makeHeaders("DELETE");
    let url=`${baseUrl}/${kinveyModule}/${appKey}/${endpoint}/${id}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}