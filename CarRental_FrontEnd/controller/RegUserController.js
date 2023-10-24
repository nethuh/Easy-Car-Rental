let userBaseUrl = "http://localhost:8080/CarRental_BackEnd_war/";

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
        }
    });
});
