let userbasurl = "http://localhost:8080/CarRental_BackEnd_war/";

let user;

$.ajax({
    url: userbasurl + "loginForm/current",
    method: "get",
    success: function (res) {
        user = res.data.user_Id;
        console.log(res.data)
        $("#search_Id").val(res.data.user_Id);
    }
});

//Rent Details
loadAllRent();
function loadAllRent() {
    $.ajax({
        url: userbasurl + "",
        method: "get",
        contentType: "application/json",
        dataType: "json",
        async: true,
        success: function (res) {
            console.log(res.data)
            for (var i of res.data) {
                if (user === i.rentDetails.at().driverID) {
                    let row = "<tr><td>" + i.rentID + "</td><td>" + i.rentDetails.at().carID  + "</td><td>" + i.pickUpDate + "</td><td>" + i.pickUpTime + "</td><td>" + i.returnDate + "</td><td>" + i.returnTime + "</td><td>" + i.location + "</td></tr>";
                    $("#driverSheduleTable").append(row);
                }
            }
        }
    });
}


$.ajax({
    url: userbasurl + "driver/loadAllDrivers",
    method: "get",
    contentType: "application/json",
    dataType: "json",
    success: function (res) {
        for (var driver of res.data) {

            if (user === driver.user_Id) {
                console.log(res.data)
                $("#cusUserID").val(driver.user_Id);
                $("#userFirstName").val(driver.name.firstName);
                $("#userLastName").val(driver.name.lastName);
                $("#customerContactNo").val(driver.contact_No);
                $("#customerAddress").val(driver.address);
                $("#customerDriverEmail").val(driver.email);
                $("#customerNic").val(driver.nic_No);
                $("#customerLicence").val(driver.license_No);
                $("#customerUserName").val(driver.user.user_Name);
                $("#customerPassword").val(driver.user.password);
                let url1 = driver.license_Img;
                console.log(url1);
                $("#photoImg").css({
                    "background": `url(${userbasurl + url1})`, "background-size": "cover"
                });
            }
        }
    }
});

