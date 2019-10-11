
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的商铺订单</title>
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
        <h2 align="center">订单列表</h2>
    </div>
    <div class="row">
        <table class="table table-striped  table-bordered table-hover">
            <tr>
                <th>用户名</th>
                <th>手机号</th>
                <th>产品名称</th>
                <th>数量</th>
                <th>总价</th>
            </tr>
            <#list storeOrderVOList as store>
                <tr>
                    <td>${store.userInfo.username}</td>
                    <td>${store.userInfo.userphone}</td>
                    <td>${store.commodity.commodityname}</td>
                    <td>${store.count}</td>
                    <td>${store.price}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        $("button[name='showHome']").click(function () {
            var storeid = $(this).attr('storeId');
            location.href = '/storeinfo/storeHome?storeId='+storeid;
        })
    })
</script>
</html>