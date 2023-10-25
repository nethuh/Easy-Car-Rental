let driverBaseUrl = "http://localhost:8080/CarRental_BackEnd_war/";

$("#btnSaveDriver").click(function (){
    let formData = new FormData($("#driverForm")[0]);
    console.log(formData);
    $.ajax({
        url: driverBaseUrl + "driver",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            console.log(res)
             saveUpdateAlert("Driver", res.message);
        },
        error: function (error) {
            unSuccessUpdateAlert("Driver", JSON.parse(error.responseText).message);
        }
    });

});