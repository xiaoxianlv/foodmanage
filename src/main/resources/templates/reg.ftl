<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h2 align="center">用户注册</h2>
    </div>
    <div class="col-md-offset-2 col-lg-offset-2 col-md-8 col-lg-8">
        <!--用户注册的form-->
        <form action="" method="post" class="col-lg-8 col-md-offset-2">

            <div class="form-group">
                <label for="username">用户名:</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <div class="form-group">
                <label for="nickname">登录使用昵称:</label>
                <input type="text" name="nickname" id="nickname" class="form-control">
            </div>
            <div class="form-group">
                <label for="userphone">手机号:</label>
                <input type="text" name="userphone" id="userphone" class="form-control">
            </div>
            <div class="form-group col-md-7 col-md-offset-2">
                <button class="btn btn-success" type="button" id="submitReg">提交注册</button>
                <button class="btn btn-warning" type="reset">重置</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="https://cdn.staticfile.org/sweetalert/2.1.1/sweetalert.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#userphone").blur(function () {
            var phone = $(this).val();
            $.ajax({
                    type: "post",
                    url: "/userinfo/selectUserByPhone",
                    data: {
                        "phone":phone
                    },
                    success:function (data) {
                        if(data.dataStauts=="error"){
                            swal('该手机号已注册过此系统');
                            $("#userphone").val('');
                        }
                    }
                }
            )
        })


        //注册
        $("#submitReg").click(function () {
            var  reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
            var password = $("#password").val();
            if(password.length<6){
                swal('密码必须六位以上');
                return false;
            }
            if(!reg.test(password)){
                swal('密码不符合规则,必须有大小写字母、数字和标点中的至少三项');
                return false;
            }
            //获取表单
            var formdata=$("form").serialize();
            $.ajax({
                type:"post",
                url:"/userinfo/doRegUser",
                data:formdata,
                success:function (result) {
                   if(result.dataStauts=="success"){
                       swal('注册用户成功');
                   }else{
                       swal('注册用户失败');
                   }
                }
            })


        })

    })

</script>
</html>