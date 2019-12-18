
function submitForm(){
    confirm("Are you Sure You want to submit the form");


var uname = document.getElementById('uname').value;
localStorage.setItem("fname",uname);



var ln = document.getElementById('Lastname').value;
localStorage.setItem("Lname",ln);



var ag=document.getElementById("age").value;
localStorage.setItem("age1",ag);


var ag=document.getElementById("Gender").value;
localStorage.setItem("gen",ag);


var textarea=document.getElementById("txtarea").value;
localStorage.setItem("address",textarea);




window.open("successfully.html");
}
