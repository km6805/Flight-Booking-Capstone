const baseURL = "http://localhost:8080";

const favoriteFlightTable = document.getElementById("favorite-flights");

function getFavoriteFlights() {
  const id = localStorage.getItem("flightBookId");
  getFlights(id);
}

const getFlights = (id) => {
  axios.get(`${baseURL}/api/flight/book/${id}`).then(({ data }) => {
    cart = data;
    displayFavorites();
  });
};

const displayFavorites = () => {
  favoriteFlightTable.innerHTML = "";
  console.log("display ", cart);
  cart.bookRows.forEach((row) => {
    favoriteFlightTable.innerHTML += makeFlights(row);
  });
};
const removeFromFavorites = (e, sku) => {
  const bookId = localStorage.getItem("flightBookId");
  axios
    .delete(`${baseURL}/api/flight-book/${bookId}/${sku}`)
    .then(({ data }) => {});
  location.reload();
};

const makeFlights = (flight) => {
  return `
    <tr>
    <td>${flight.sku}</td>
    <td align="center">${flight.airline}</td>
    <td align="center">${flight.departure}</td>
    <td align="center">${flight.arrival}</td>
    <td align="center">${flight.date}</td>
    <td align="center">${flight.time}</td>
    <td align="center">$${flight.price}</td>
    <td align="center"><button onclick="removeFromFavorites(this, ${flight.sku})">Remove</button></td>
</tr>`;
};

window.onload = getFavoriteFlights();
