
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的订单列表</title>
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
                <th>门店名称</th>
                <th>产品名称</th>
                <th>数量</th>
                <th>总价</th>
            </tr>
            <#if userOrderVOList?? && (userOrderVOList?size > 0)>
            <#list userOrderVOList as order>
                <tr>
                    <td>${order.storeInfo.storename}</td>
                    <td>${order.commodity.commodityname}</td>
                    <td>${order.count}</td>
                    <td>${order.price}</td>
                </tr>
            </#list>
            <#else>
                <h3>您还没有购买过任何商品，快去下单把!</h3>
                <a href="/storeinfo/query">去下单</a>
            </#if>
        </table>
    </div>
</div>
</body>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</html>