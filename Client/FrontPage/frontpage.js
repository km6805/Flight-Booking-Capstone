const baseURL = "http://localhost:8080";

const flightListTable = document.getElementById("flight-list");
//const deleteBtn = document.getElementsByTagName("button")
let list = new Array();

const getList = () => {
  axios.get(`${baseURL}/api/flights`).then(({ data }) => {
    list = data;
    displayList();
  });
};

const displayList = () => {
  flightListTable.innerHTML = "";
  
  list.forEach((row) => {
    flightListTable.innerHTML += makeFlight(row);
  });
};

const addToFavorites = (e, sku) => {
  let body = {
    sku: sku,
    quantity: 1,
  };
  const id = localStorage.getItem("flightBookId");
  axios.post(`${baseURL}/api/flight-book/${id}`, body).then(({ data }) => {});
};

const makeFlight = (flight) => {
  return `
        <tr>
            <td>${flight.sku}</td>
            <td align="center">${flight.airline}</td>
            <td align="center">${flight.departure}</td>
            <td align="center">${flight.arrival}</td>
            <td align="center">${flight.date}</td>
            <td align="center">${flight.time}</td>
            <td align="center">$${flight.price}</td>
            <td align="center"><button onclick="addToFavorites(this, ${flight.sku})">Add to Favorites</button></td>
        </tr>`;
};

window.onload = function () {
  localStorage.setItem("flightBookId", 1);
};

getList();
