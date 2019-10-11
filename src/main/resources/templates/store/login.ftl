<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
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
        <h2 align="center">商家登录</h2>
    </div>
    <div class="col-md-offset-2 col-lg-offset-2 col-md-8 col-lg-8">
        <!--用户注册的form-->
        <form action="/storeinfo/doStoreLogin" method="post" class="col-lg-8 col-md-offset-2">
            <div class="form-group">
                <label for="username">用户名:</label>
                <input type="text" name="username" id="username" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>
            <div class="form-group col-md-7 col-md-offset-2">
                <button class="btn btn-success" type="submit">登录</button>
                <a  class="btn btn-info" href="/userinfo/reg">注册</a>
            </div>
        </form>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="https://cdn.staticfile.org/sweetalert/2.1.1/sweetalert.min.js"></script>
</html>