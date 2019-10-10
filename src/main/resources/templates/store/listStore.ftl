
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>店铺列表</title>
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
        <h2 align="center">店铺列表</h2>
    </div>
    <div class="col-md-offset-2 col-lg-offset-2 col-md-8 col-lg-8">
        <!--用户注册的form-->
        <form action="" method="get" class="col-lg-8 col-md-offset-2 form-inline">
            <div class="form-group">
                <label for="addressinfo">地址信息:</label>
                <input type="text" name="addressinfo" id="addressinfo" class="form-control"
                           value="${(storeInfo.addressinfo)!}"
                       >
            </div>
            <button class="btn btn-success" type="submit">查询</button>
        </form>
    </div>
    <div class="row">

        <table class="table table-striped  table-bordered table-hover">
            <tr>
                <th>店铺名</th>
                <th>店铺详细地址</th>
                <th>店铺经纬度</th>
                <th>操作</th>
            </tr>
            <#list storeInfoList as store>
            <tr>
                <td>${store.storename}</td>
                <td>${store.addressinfo}</td>
                <td>${store.coordinate}</td>
                <td>
                    <button class="btn btn-warning" value="查看菜单">查看菜单</button>
                </td>
            </tr>
            </#list>
        </table>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</html>