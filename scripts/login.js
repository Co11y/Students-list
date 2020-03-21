const loginButtonLogin = document.getElementById("loginButtonLogin");
const signUpButtonLogin = document.getElementById("signUpButtonLogin");

const emailInputLogin = document.getElementById("emailInputLogin");
const passwordInputLogin = document.getElementById("passwordInputLogin");

loginButtonLogin.addEventListener("click", function () {
    emailInputLogin.required;
    passwordInputLogin.required;
    if (emailInputLogin.validity.valueMissing == false && passwordInputLogin.validity.valueMissing == false) {
        console.log(emailInputLogin.value);
        console.log(passwordInputLogin.value);

        user = new Object();
        user.email = emailInputLogin.value;
        user.password = passwordInputLogin.value;

        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            resptext = this.responseText;
            console.log(resptext);
            if (resptext == "notFound") {
                alert("account not found");
            }
            else {
                let user = JSON.parse(resptext);
                fillProfile(user);
                LogStatus = true;
                Role = user.role;
                window.location.href = "#home";
            }

        };
        xhttp.open("POST", "LoginValidator", true);
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send(JSON.stringify(user));

    }
});

signUpButtonLogin.addEventListener("click", function () {
    window.location.href = "#signUp";
});