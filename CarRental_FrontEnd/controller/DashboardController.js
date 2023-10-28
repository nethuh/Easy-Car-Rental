let dashboard =  "http://localhost:8080/CarRental_BackEnd_war/";

//Car Count
$("#carCount").val("00");
$.ajax({
    url: dashboard + "car/carCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#carCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});

//Available Car Count
$("#availableCarCount").val("00");
$.ajax({
    url: dashboard + "car/availablCarCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#availableCarCount").text(num);
    },
    error: function (ob, statusText, error) {
    }
});

//Reserved Car Count
$("#reservedCarCount").val("00");
$.ajax({
    url: dashboard + "car/reservedCarCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#reservedCarCount").text(num);
    },
    error: function (ob, statusText, error) {
    }
});

//Driver Count
$("#driverCount").val("00");
$.ajax({
    url: dashboard + "driver/driverCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#driverCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});

//Driver Available Count
$("#availableDriverCount").val("00");
$.ajax({
    url: dashboard + "driver/driverAvailableCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#availableDriverCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});

