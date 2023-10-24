let userBaseUrl = "http://localhost:8080/CarRental_BackEnd_war/";

loadAllRegUsers();


// Customer Save

$("#btnSaveCustomer").click(function (){
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: userBaseUrl + "reg_User",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            saveUpdateAlert("User", res.message);
            loadAllRegUsers();
        },
        error: function (error){
            unSuccessUpdateAlert("User", JSON.parse(error.responseText).message);
        }
    });
});

//load all customers Method
function loadAllRegUsers() {
    $("#customerTable").empty();
    $.ajax({
        url: userBaseUrl + "", method: "GET", dataType: "json", success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let user_Id = i.user_Id;
                let firstName = i.name.firstName;
                let lastName = i.name.lastName;
                let contact_No = i.contact_No;
                let address = i.address;
                let email = i.email;
                let nic = i.nic;
                let license_No = i.license_No;
                let nic_Img = i.nic_Img;
                let license_Img = i.license_Img;
                let role_Type = i.user.role_Type;
                let user_Name = i.user.user_Name;
                let password = i.user.password;

                let row = "<tr><td>" + user_Id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + contact_No + "</td><td>" + address + "</td><td>" + email + "</td><td>" + nic + "</td><td>" + license_No + "</td><td>" + role_Type + "</td><td>" + user_Name + "</td><td>" + password + "</td></tr>";
                $("#customerTable").append(row);
            }
            blindClickEvents();
            setTextFieldValues("", "", "", "", "", "", "", "", "", "", "");
            console.log(res.message);
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    });
}

//Table Listener Click and Load textFields

function blindClickEvents() {
    $("#customerTable>tr").on("click", function () {
        let user_Id = $(this).children().eq(0).text();
        let firstName = $(this).children().eq(1).text();
        let lastName = $(this).children().eq(2).text();
        let address = $(this).children().eq(3).text();
        let contact_No = $(this).children().eq(4).text();
        let email = $(this).children().eq(5).text();
        let nic = $(this).children().eq(6).text();
        let license_No = $(this).children().eq(7).text();
        let role_Type = $(this).children().eq(8).text();
        let user_Name = $(this).children().eq(9).text();
        let password = $(this).children().eq(10).text();


        console.log(user_Id, firstName, lastName, address, contact_No, email, nic, license_No, role_Type, user_Name, password);

        $("#user_Id").val(user_Id);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#contact_No").val(address);
        $("#address").val(contact_No);
        $("#email").val(email);
        $("#nic").val(nic);
        $("#license_No").val(license_No);
        $("#role_Type").val(role_Type);
        $("#user_Name").val(user_Name);
        $("#password").val(password);
    });
    $("#btnSaveCustomer").attr('disabled', true);
}
//clear input fields Values Method
function setTextFieldValues(firstName, lastName, contact_No, address, email, nic, license_No, nic_Img, license_Img, user_Name, password) {
    $("#firstName").val(firstName);
    $("#lastName").val(lastName);
    $("#contact_No").val(contact_No);
    $("#address").val(address);
    $("#email").val(email);
    $("#nic").val(nic);
    $("#license_No").val(license_No);
    $("#nic_Img").val(nic_Img);
    $("#license_Img").val(license_Img);
    $("#user_Name").val(user_Name);
    $("#password").val(password);

    $("#firstName").focus();
    $("#btnSaveCustomer").attr('disabled', true);
}
