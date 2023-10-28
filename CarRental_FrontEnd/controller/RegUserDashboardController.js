let RentbaseUrl = "http://localhost:8080/CarRental_BackEnd_war/";
loadAllRent();
$("#updateCustomer").attr('disabled', true);

//Rent Id generate
generateRentID();

function generateRentID() {
    $("#rent_Id").val("REN-001");
    $.ajax({
        url: RentbaseUrl + "rent/rentIdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#rent_Id").val("REN-00" + tempId);
            } else if (tempId <= 99) {
                $("#rent_Id").val("REN-0" + tempId);
            } else {
                $("#rent_Id").val("REN-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}

//search
$("#car_Id").click(function () {
    var search = $("#car_Id").val();
    $.ajax({
        url: RentbaseUrl + "car/searchCar/?car_Id=" + search,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $("#name").val(res.name);
            $("#brand").val(res.brand);
            $("#number_Of_Passengers").val(res.number_Of_Passengers);
            let url1 = res.image.front_View;
            let url2 = res.image.back_View;
            let url3 = res.image.side_View;
            let url4 = res.image.interior;
            $("#imageLoad1").css({
                "background": `url(${RentbaseUrl + url1})`, "background-size": "cover"
            });
            $("#imageLoad2").css({
                "background": `url(${RentbaseUrl + url2})`, "background-size": "cover"
            });
            $("#imageLoad3").css({
                "background": `url(${RentbaseUrl + url3})`, "background-size": "cover"
            });
            $("#imageLoad4").css({
                "background": `url(${RentbaseUrl + url4})`, "background-size": "cover"
            });
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    })
});

//Current user
let user;
$.ajax({
    url: RentbaseUrl + "loginForm/current", method: "get", success: function (res) {
        user = res.data.user_Id;
        console.log(res.data)
        $("#user_Id").val(res.data.user_Id);
    }
});

//Current User Profile
$.ajax({
    url: RentbaseUrl + "reg_User/loadAllUsers",
    method: "get",
    contentType: "application/json",
    dataType: "json",
    success: function (res) {
        for (var cus of res.data) {
            if (user === cus.user_Id) {
                $("#cusUserID").val(cus.user_Id);
                $("#userFirstName").val(cus.name.firstName);
                $("#userLastName").val(cus.name.lastName);
                $("#customerContactNo").val(cus.contact_No);
                $("#customerAddress").val(cus.address);
                $("#customerDriverEmail").val(cus.email);
                $("#customerNic").val(cus.nic);
                $("#customerLicence").val(cus.license_No);
                $("#customerUserName").val(cus.user.user_Name);
                $("#customerPassword").val(cus.user.password);
                let urlone = cus.nic_Img;
                let urltwo = cus.license_Img;
                $("#photoImg1").css({
                    "background": `url(${RentbaseUrl + urlone})`, "background-size": "cover"
                });
                $("#photoImg2").css({
                    "background": `url(${RentbaseUrl + urltwo})`, "background-size": "cover"
                });
            }
        }
    }
});

//Current User Update
$("#updateCustomer").click(function () {
    let formData = new FormData($("#customerDetailsForm")[0]);
    console.log(formData);
    $.ajax({
        url: RentbaseUrl + "reg_User/update",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            saveUpdateAlert("User", res.message);
            loadAllRegUsers();
        },
        error: function (error) {
            unSuccessUpdateAlert("User", JSON.parse(error.responseText).message);
        }
    });
});


$("#userFirstName").focus();
const regExFirstName = /^[A-z ]{3,20}$/;
const regExLastName = /^[A-z ]{3,20}$/;
const regExContactNum = /^(07(0|1|2|4|5|6|7|8)[0-9]{7})$/;
const regExCusAddress = /^[A-z0-9/ ]{4,30}$/;
const regExEmailCusAddress = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const regExNIC = /^([0-9]{12}|[0-9V]{10})$/;
const regExDrivingNIC = /^[A-Z0-9-]+$/;
const regExUserName = /^[A-z0-9/ ]{4,30}$/;
const regExPassword = /^([A-Z a-z]{5,15}[0-9]{1,10})$/;

let customerValidations = [];
customerValidations.push({
    reg: regExFirstName, field: $('#userFirstName'), error: 'Customer First Name Pattern is Wrong'
});
customerValidations.push({
    reg: regExLastName, field: $('#userLastName'), error: 'Customer Last Name Pattern is Wrong'
});
customerValidations.push({
    reg: regExContactNum, field: $('#customerContactNo'), error: 'Customer Contact Number Pattern is Wrong'
});
customerValidations.push({
    reg: regExCusAddress, field: $('#customerAddress'), error: 'Customer Address Pattern is Wrong'
});
customerValidations.push({
    reg: regExEmailCusAddress, field: $('#customerDriverEmail'), error: 'Customer Email Address Pattern is Wrong'
});
customerValidations.push({
    reg: regExNIC, field: $('#customerNic'), error: 'Customer NIC Pattern is Wrong'
});
customerValidations.push({
    reg: regExDrivingNIC, field: $('#customerLicence'), error: 'Customer Driving License Pattern is Wrong'
});
customerValidations.push({
    reg: regExUserName, field: $('#customerUserName'), error: 'Customer User Name Pattern is Wrong'
});
customerValidations.push({
    reg: regExPassword, field: $('#customerPassword'), error: 'Customer Password Pattern is Wrong'
});
//disable tab key of all four text fields using grouping selector in CSS
$("#userFirstName,#userLastName,#customerContactNo,#customerAddress,#customerDriverEmail,#customerNic,#customerLicence,#customerUserName,#customerPassword").on('keydown', function (event) {
    if (event.key === "Tab") {
        event.preventDefault();
    }
});

$("#userFirstName,#userLastName,#customerContactNo,#customerAddress,#customerDriverEmail,#customerNic,#customerLicence,#customerUserName,#customerPassword").on('keyup', function (event) {
    checkValidity(customerValidations);
});

$("#userFirstName,#userLastName,#customerContactNo,#customerAddress,#customerDriverEmail,#customerNic,#customerLicence,#customerUserName,#customerPassword").on('blur', function (event) {
    checkValidity(customerValidations);
});
