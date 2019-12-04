const username = "Valeri";
const password = "1234";
const appKey = "kid_rJUIE00hB";
const appSecret = "48518482bcc94b2b9f5fdbe055e7b411";
const baseUrl = "https://baas.kinvey.com"

function makeHeaders(type,httpMethod, data) {
    const header = {
        method: httpMethod,
        headers: {
            "Authorization": createAuthorization(type),
            "Content-Type": "application/json"
        }


    };
    if (httpMethod === "POST" || httpMethod === "PUT") {
        header.body = JSON.stringify(data)
    }
    return header
}

function createAuthorization(type) {
    return type === 'Basic'
        ? `Basic ${btoa(`${appKey}:${appSecret}`)}`
        : `Kinvey ${sessionStorage.getItem('authtoken')}`
}


function handleErrors(e) {
    if (e.ok) {
        throw  new Error("Error!")
    }
    return e;
}

function serializelizeData(x) {
    if(x.status===204){
        return x
    }
    return x.json();
}

export function get(kinveyModule, endpoint,type) {
    const header = makeHeaders(type,"GET");
    const url = `${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;

    return fetch(url, header).then(serializelizeData).then(handleErrors);
}

export function put(kinveyModule, endpoint, data,type) {
    const header = makeHeaders(type,"PUT", data);
    const url = `${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}
export  function  post(kinveyModule,endpoint,data,type) {
    const  header=makeHeaders(type,"POST",data)
    let url=`${baseUrl}/${kinveyModule}/${appKey}/${endpoint}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}
export  function  del(kinveyModule,endpoint,id,type) {
    const header=makeHeaders(type,"DELETE");
    let url=`${baseUrl}/${kinveyModule}/${appKey}/${endpoint}/${id}`;
    return fetch(url, header).then(serializelizeData).then(handleErrors);
}