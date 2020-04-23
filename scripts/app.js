let loginStatus = false;
let userProfile = null;


buttons = [homeButton, listButton, userButton];
windows = [home, login, list, profile, signUp];

window.addEventListener('hashchange', function() {
    let ref = window.location.href.split("#")[1];
    route(ref);
});

window.addEventListener('load', function () {
    let ref = window.location.href.split("#")[1];
    route(ref);
});

function route(ref) {
    if (ref == "login") {
        show(login)
        highlight(userButton);
    }
    else if (ref == "home") {
        show(home);
        highlight(homeButton);
    }

    else if (ref == "list") {
        show(list);
        highlight(listButton);
    }
    else if (ref == "profile") {
        show(profile);
        highlight(userButton);
    }
    else if (ref == "signUp") {
        show(signUp);
    }
    console.log("triggered");
}

function highlight(button) {
    for(let but of buttons) {
        if (but == button) {
            but.style.backgroundColor = "#751d7d";
            continue;
        }
        but.style.backgroundColor = "white";

    }
}
function show(wind) {
    for(let win of windows) {
        if (win == wind) {
            win.style.display = "block";
            continue;
        }
        win.style.display = "none";
    }
}