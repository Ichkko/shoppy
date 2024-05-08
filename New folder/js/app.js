let customers = document.querySelector(".customers");

async function fetchcustomers(url) {
    try {


        let data = await fetch(url);
        let response = await data.json();
        for (let i = 0; i < response.length; i++) {
            let name = response[i].name;
            let email = response[i].email;
            let phone = response[i].phone;
            customers.innerHTML += `<div><h2>${name}</h2>
            <p>${email}</p></div>`;
        }
    } catch (err) {
        console.log(err);
    }
    fetchcustomers("http://localhost:8080/api/customers");
}