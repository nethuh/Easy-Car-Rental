let userBaseUrl = "http://localhost:8080/CarRental_BackEnd_war/";

loadAllRegUsers();



$("#btnSaveCustomer").click(function (){
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: userBaseUrl + "",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            loadAllRegUsers();
        },
        error: function (error){
        }
    });
});

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
                console.log(res.message);
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    });
}
