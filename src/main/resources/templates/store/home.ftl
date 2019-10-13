
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">


</head>

<body>
<div class="container" style="font-family:微软雅黑;font-size:middle">
    <div class="page-header">
        <h2 align="center">${(storeInfo.storename)!}</h2>
    </div>

    <div class="col-md-offset-2 col-md-8">
        <form action="" class="navbar-form navbar-left" role="search">

            <input type="hidden" name="storeId" value="${storeInfo.storeid}">

            <div class="form-group">
                大小：
                <select class="form-control" name="detailsize">
                    <option value="-1">全部</option>
                    <option value="3">大杯</option>
                    <option value="2">中杯</option>
                    <option value="1">小杯</option>
                </select>
            </div>
            &nbsp;
            <div class="form-group">
                冷热：
                <select class="form-control" name="temperature">
                    <option value="-1">全部</option>
                    <option value="1">冷</option>
                    <option value="2">热</option>
                </select>
            </div>
            &nbsp;
            <div class="form-group">
                <button type="submit" class="btn btn-default">查询</button>
            </div>
        </form>


        <table class="table table-bordered">
            <thead
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>大小</th>
                <th>冷热</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            </thead>

            <#list pageInfo.list as commod>
            <tr>
                <td>${commod.commodityid}</td>
                <td>${commod.commodityname}</td>
                <td align="center">
                    <label class="radio-inline">
                        <input name="size" type="radio" value="3">大杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size" type="radio" value="2">中杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size" type="radio" value="1">小杯</input>
                    </label>
                </td>
                <td align="center">
                    <label class="radio-inline">
                        <input name="temp" type="radio" commodityid="${commod.commodityid}" value="2" checked>热</input>
                    </label>
                    <label class="radio-inline">
                        <input name="temp" type="radio" commodityid="${commod.commodityid}" value="1">冷</input>
                    </label>
                </td>
                <td>25</td>
                <td>
                    <a href="javascript:void(0)" storeInfoId="${commod.storeid}" commodityid="${commod.commodityid}" name="saveOrder">加入购物车</a>
                </td>
            </tr>
            </#list>
        </table>

        <div align="center">
            <nav aria-lable="Page navigation">
                <p>当前页码:${pageInfo.pageNum},总页码:${pageInfo.pages}页</p>
                <ul class="pagination">
                    <li><a href="javascript:void(0);" name="limitQuery" pageNo="1">首页</a></li>
                    <li><a href="javascript:void(0);" name="limitQuery" pageNo="${pageInfo.pageNum-1}">上一页</a></li>
                    <li><a href="javascript:void(0);" name="limitQuery" pageNo="${pageInfo.pageNum+1}">下一页</a></li>
                    <li><a href="javascript:void(0);" name="limitQuery" pageNo="${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>


</div>

<div class="modal fade" tabindex="-1" role="dialog" id="countModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">请填写数量</h4>
            </div>
            <div class="modal-body">
                请填写数量:<input type="text" name="shopcount" id="shopcount" placeholder="请填写数量" class="form-control">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消下单</button>
                <button type="button" class="btn btn-primary" id="addOrderPay">确认下单</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<input type="hidden" value="" id="storeInfoId">
<input type="hidden" value="" id="commodityid">
<input type="hidden" value="" id="payPrice">


<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        var detailsize=${commodity.detailsize!-1}
        var temperature=${commodity.temperature!-1};
        if (detailsize==null){
            detailsize = -1;
        }
        if(temperature=-1){
            temperature = -1;
        }
        //回显
        $("select[name='detailsize']").val(detailsize);
        $("select[name='temperature']").val(temperature);

        //单选框 冷热的选择
        $("input[name='temp']").click(function () {
            //获取选择的value
            var dom = $(this);
            var temperatureValue = $(this).val();
            var commodityidValue = $(this).attr("commodityid");
            var size = $("input[name='size']:checked").val();
            $.ajax({
                type:"post",
                url:"/commoditydetail/detailPirce",
                data:{
                    "commodityid":commodityidValue,
                    "detailsize":size,
                    "temperature":temperatureValue
                },
                success:function (result) {
                    if(result.mess=="error"){
                        $(dom).parent().parent().next().text("请仔细选择套餐");
                    }else{
                        $(dom).parent().parent().next().text(result.price);
                    }

                }
            })
        })
        //新增订单的处理
        $("a[name='saveOrder']").click(function () {
            //显示模态框
            $("#countModal").modal('show');
            var dom = $(this);
            //获取店铺信息的id
            var storeInfoId = $(this).attr("storeinfoid");
            $("#storeInfoId").val(storeInfoId);
            //商品的id
            var commodityid = $(this).attr("commodityid");
            $("#commodityid").val(commodityid);
            //获取价格
            var price = $(dom).parent().prev().text();
            $("#payPrice").val(price);
        });

        //确认下单
        $("#addOrderPay").click(function () {
            //点击
            var storeInfoId = $("#storeInfoId").val();
            var commodityid = $("#commodityid").val();
            //获取数量，传送后台计算价格
            var shopcount = $("#shopcount").val();
            var price = $("#payPrice").val();
            $.ajax({
                type: "post",
                url: "/order/addOrder",
                data: {
                    "storeInfoId": storeInfoId,
                    "commodityid": commodityid,
                    "count": shopcount,
                    "price": price
                },
                success: function (result) {
                    if (result.dataStatus == "success") {
                        alert(result.message);
                        //显示模态框
                        $("#countModal").modal('hide');
                    }else if(result.dataStatus=="error"){
                        alert(result.message)
                        location.href = '/';
                    }
                }
            })
        })
        //分页
        $("a[name='limitQuery']").click(function () {
            var pageno = $(this).attr("pageno");
            var data = $("form").serialize();
            location.href = '/storeinfo/storeHome?pageNum='+pageno+"&"+data;
        })

    })
</script>
</body>
</html>
