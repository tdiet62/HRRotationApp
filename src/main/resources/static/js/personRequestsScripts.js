function searchTable(event) {
    //Splitting the search string by space to return an array the values as single words
    let searchStringArray = event.target.value.split(" ");
    let filtered = personRequestsJsonPayload.filter(function (currentPersonRequest) {
        let searchStringArrayClone = [].concat(searchStringArray);
        Object.keys(currentPersonRequest).forEach(currentKey => {

            searchStringArray.forEach(function (searchTerm) {
                if (currentPersonRequest[currentKey].toLowerCase().includes(searchTerm.toLowerCase())) {
                    let searchTermIndex = searchStringArrayClone.indexOf(searchTerm);
                    if (searchTermIndex > -1) {
                        searchStringArrayClone.splice(searchTermIndex, 1);
                    }
                }
            })
        });

        return searchStringArrayClone.length === 0;
    });

    createTableFromJSON(filtered);
}

function getPersonRequests() {
    const urlToGetPersonRequestsFrom = '/rest/person-requests/all';
    return fetch(urlToGetPersonRequestsFrom)
        .then(response => response.json())
        .then(data => {
            return data;
        }).catch(function () {
            let errorMessage = document.createElement("h2");
            errorMessage.innerText = "It looks like there is an issue, please contact vinay.dogra@capgemini.com";
            appendToDom(errorMessage);
        })
}

function formatColumnTitle(text) {
    let result = text.replace(/([A-Z])/g, " $1");
    return result.charAt(0).toUpperCase() + result.slice(1);
}

function createTableFromJSON(personRequests) {

    // EXTRACT VALUE FOR HTML HEADER.
    let col = [];
    for (let i = 0; i < personRequests.length; i++) {
        Object.keys(personRequests[i]).forEach(key => {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        })
    }

    // CREATE DYNAMIC TABLE.
    const table = document.createElement("table");
    table.id = "personRequestsTable";
    // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

    let tr = table.insertRow(-1);                   // TABLE ROW.
    for (let i = 0; i < col.length; i++) {
        const th = document.createElement("th");      // TABLE HEADER.
        th.innerHTML = formatColumnTitle(col[i]);
        tr.appendChild(th);
    }

    // ADD JSON DATA TO THE TABLE AS ROWS.
    for (let i = 0; i < personRequests.length; i++) {
        tr = table.insertRow(-1);
        for (let j = 0; j < col.length; j++) {
            let tabCell = tr.insertCell(-1);
            tabCell.innerHTML = personRequests[i][col[j]];
        }
    }

    appendToDom(table);
}

function appendToDom(elementToAppend) {
    const divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(elementToAppend);
}

let personRequestsJsonPayload;
function initTable() {
    const personRequests = getPersonRequests();

    personRequests.then(function (json) {
        personRequestsJsonPayload = json;

        return personRequestsJsonPayload;
    }).then(createTableFromJSON);
}


