console.log("js started");

function ValidateEmail() {
  console.log("in validate");
  var email = document.getElementById("1").value;
  if (
    /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(
      email
    )
  ) {
    document.getElementById("span1").innerHTML = "";
    return true;
  }
  // alert("You have entered an invalid email address!")
  document.getElementById("span1").innerHTML = "invalid email address";
  return false;
}
function veripass1() {
  var p = document.getElementById("2").value;
  if (p.length < 6) {
    document.getElementById("span2").innerHTML =
      "password must contain atleast 6 charcters";
  } else {
    document.getElementById("span2").innerHTML = "";
  }
}
function VerifyPass() {
  var pass = document.getElementById("2").value;
  var verpass = document.getElementById("3").value;

  if (pass == verpass) {
    document.getElementById("span1").innerHTML = "";
  } else {
    document.getElementById("span3").innerHTML = "Password Mismatch";
  }
}
