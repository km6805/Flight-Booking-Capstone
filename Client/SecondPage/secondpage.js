const baseURL = "http://localhost:8080";

const form = document.querySelector("form");

const submitHandler = (e) => {
  e.preventDefault();
  const sku = document.querySelector("#flightnum");
  const airline = document.querySelector("#airline");
  const departure = document.querySelector("#departure");
  const arrival = document.querySelector("#arrival");
  const date = document.querySelector("#date");
  const time = document.querySelector("#time");
  const price = document.querySelector("#price");
  let body = {
    sku: sku.value,
    airline: airline.value,
    departure: departure.value,
    arrival: arrival.value,
    date: date.value,
    time: time.value,
    price: price.value,
  };
  createFlight(body);
  sku.value = "";
  airline.value = "";
  departure.value = "";
  arrival.value = "";
  date.value = "";
  time.value = "";
  price.value = "";
};

const createFlight = (body) => {
  axios.post(`${baseURL}/api/flight/add`, body).then(({ data }) => {});
};

form.addEventListener("submit", submitHandler);
