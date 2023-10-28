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
