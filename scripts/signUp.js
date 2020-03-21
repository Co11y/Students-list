const firstNameInputSignUp = document.getElementById("firstNameInputSignUp");
const lastNameInputSignUp = document.getElementById("lastNameInputSignUp");
const emailInputSignUp = document.getElementById("emailInputSignUp");
const passwordInputSignUp = document.getElementById("passwordInputSignUp");
const passwordInputRepeatSignUp = document.getElementById("passwordInputRepeatSignUp");
const adminRadioSignUp = document.getElementById("adminRadioSignUp");
const userRadioSignUp = document.getElementById("userRadioSignUp");

const createAccountButtonSignUp = document.getElementById("createAccountButtonSignUp");

createAccountButtonSignUp.addEventListener("click", function (event) {
    event.preventDefault();
    firstNameInputSignUp.required;
    lastNameInputSignUp.required;
    emailInputSignUp.required;
    passwordInputSignUp.required;
    passwordInputRepeatSignUp.required;

    if (firstNameInputSignUp.validity.valueMissing == false && lastNameInputSignUp.validity.valueMissing == false &&
    emailInputSignUp.validity.valueMissing == false && passwordInputSignUp.validity.valueMissing == false &&
    passwordInputRepeatSignUp.validity.valueMissing == false && adminRadioSignUp.checked || userRadioSignUp.checked) {
        if (passwordInputSignUp.value != passwordInputRepeatSignUp.value) {
            alert("password doesn't match");
        }
        else {
            alert("hell yes");
            user = new Object();
            user.firstName = firstNameInputSignUp.value;
            user.lastName = lastNameInputSignUp.value;
            user.email = emailInputSignUp.value;
            user.password = passwordInputSignUp.value;
            if (adminRadioSignUp.checked) {
                user.role = "admin"
            }
            else {
                user.role = "user"
            }

            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
            };
            xhttp.open("POST", "AccountCreator", true);
            xhttp.setRequestHeader("Content-Type", "application/json");
            xhttp.send(JSON.stringify(user));
            window.location.href = "#login";
        }
    }
});

