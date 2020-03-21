const homeButton = document.getElementById("homeButton");
const listButton = document.getElementById("listButton");
const userButton = document.getElementById("userButton");

const list = document.getElementById("list");
const profile = document.getElementById("profile");
const signUp = document.getElementById("signUp");
const login = document.getElementById("login");
const home = document.getElementById("home");



homeButton.addEventListener("click", function () {
    window.location.href = "#home";
});

listButton.addEventListener("click", function () {
    window.location.href = "#list";
});

userButton.addEventListener("click", function () {
    if (LogStatus == true) {
        window.location.href = "#profile";
    }
    else {
        window.location.href = "#login";
    }
});