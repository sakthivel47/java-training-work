function validateForm() {
    var name = document.forms["addCustomer"]["name"].value;
    var email = document.forms["addCustomer"]["email"].value;
    var contact = document.forms["addCustomer"]["contact"].value;
    var accountType = document.forms["addCustomer"]["accountType"].value;
    var namePattern = /^[a-zA-Z ]+$/;
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    var contactPattern = /^[7-9][0-9]{9}$/;

    if (!namePattern.test(name)) {
        document.getElementById("nameError").innerHTML = "Please enter only alphabets";
        return false;
    } else {
        document.getElementById("nameError").innerHTML = "";
    }

    if (!emailPattern.test(email)) {
        document.getElementById("emailError").innerHTML = "Please enter a valid email id";
        return false;
    } else {
        document.getElementById("emailError").innerHTML = "";
    }

    if (!contactPattern.test(contact)) {
        document.getElementById("contactError").innerHTML = "Please enter a valid contact number";
        return false;
    } else {
        document.getElementById("contactError").innerHTML = "";
    }

    var customer = {
        name: name,
        email: email,
        contact: contact,
        accountType: accountType
    };

    document.getElementById("customerTable").innerHTML += "<tr><td>" + customer.name + "</td><td>" + customer.email + "</td><td>" + customer.contact + "</td><td>" + customer.accountType + "</td></tr>";

    return false;
}