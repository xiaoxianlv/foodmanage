<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商家注册</title>
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
        <h2 align="center">商家注册</h2>
    </div>
    <div class="col-md-offset-2 col-lg-offset-2 col-md-8 col-lg-8">
        <!--用户注册的form-->
        <form action="/storeinfo/doReg" method="post" class="col-lg-8 col-md-offset-2">

            <div class="form-group">
                <label for="username">用户名:</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <div class="form-group">
                <label for="nickname">店铺名:</label>
                <input type="text" name="storename" id="storename" class="form-control">
            </div>
            <div class="form-group">
                <label for="userphone">店铺详细地址:</label>
                <input type="text" name="addressinfo" id="addressinfo" class="form-control">
            </div>
            <div class="form-group">
                <label for="coordinate">经纬度:</label>
                <input type="text" name="coordinate" id="coordinate" class="form-control">
            </div>
            <div class="form-group col-md-7 col-md-offset-2">
                <button class="btn btn-success" type="submit" id="submitReg">提交注册</button>
                <button class="btn btn-warning" type="reset">重置</button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="https://cdn.staticfile.org/sweetalert/2.1.1/sweetalert.min.js"></script>
</html>