const firstNameProfile = document.getElementById("firstNameProfile");
const lastNameProfile = document.getElementById("lastNameProfile");
const emailProfile = document.getElementById("emailProfile");
const roleProfile = document.getElementById("roleProfile");

const logOutButtonProfile = document.getElementById("logOutButtonProfile");

fillProfile = function (user) {
firstNameProfile.innerText = user.firstName;
lastNameProfile.innerText = user.lastName;
emailProfile.innerText = user.email;
roleProfile.innerText = user.role;
};

clearProfile = function() {
    firstNameProfile.innerText = " ";
    lastNameProfile.innerText = " ";
    emailProfile.innerText = " ";
    roleProfile.innerText = " ";
};

logOutButtonProfile.addEventListener("click", function () {
    clearProfile();
    Role = null;
    LogStatus = false;
    window.location.href = "#login";
});