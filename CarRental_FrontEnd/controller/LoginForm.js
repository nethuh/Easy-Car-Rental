let baseUrlLogin = "http://localhost:8080/CarRental_BackEnd_war/";

$("#btnLogin").on('click',function (){
    login();
});

function login(){
    let loginRole_Type = $("#role_Type").val();
    let loginUserName = $("#user_Name").val();
    let loginPassword = $("#password").val();

    $.ajax({
        url: baseUrlLogin + "loginForm",
        contentType: "application/json",
        dataType: "json",
        success: function (res){
            for (var login of res.data){
                if (loginRole_Type === login.role_Type && loginUserName === login.user_Name && Login.password){
                    if (loginRole_Type === "" && loginUserName === login.role_Type && loginPassword === login.password){
                        $.ajax({
                            url: baseUrlLogin + "" + loginUserName + "" + loginPassword,
                            data:res.data,
                            method:"get",
                            success:function (res1){

                            }
                        })
                        window.location.href ='';


                    }else if (loginRole_Type === "" && loginUserName === login.user_Name && loginPassword === login.password){
                        $.ajax({
                            url: baseUrlLogin + "" + loginUserName + "" + loginPassword,
                            data:res.data,
                            method:"get",
                            success:function (res1){

                            }
                        });
                         window.location.href = '';



                    }else if (loginRole_Type === "" && loginUserName === login.user_Name && loginPassword === login.password){
                        window.location.href ='';

                    }
                    return;
                }
            }
        }
    });
}