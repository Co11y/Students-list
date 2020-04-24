const listUl = document.getElementById("listTable");
let isLoaded = false;


function loadStudents(page) {
  let users;
  let xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
      resptext = this.responseText;
      users = JSON.parse(resptext);
      fillProfile(user);
      LogStatus = true;
      Role = user.role;
      window.location.href = "#home";
  };
  xhttp.open("POST", "LoginValidator", true);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.send(JSON.stringify(user));
}

function renderStudents() {

}
