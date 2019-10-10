
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

    <script type="text/javascript">
        $(function () {
            $("input[type='radio']").on("click",function () {
                alert($(this).val());
                /*
                    if($("input[id='a']:checked").val()=="1"){
                        console.log("11111");
                    }else{
                        console.log("2222");
                    }
                */
            })
        })

    </script>
</head>

<body>
<div class="container" style="font-family:微软雅黑;font-size:middle">
    <div class="page-header">
        <h2 align="center">${(storeInfo.storename)!}</h2>
    </div>

    <div class="col-md-offset-2 col-md-8">
        <form action="#" class="navbar-form navbar-left" role="search">
            <div class="form-group">
                大小：
                <select class="form-control">
                    <option>全部</option>
                    <option>大杯</option>
                    <option>中杯</option>
                    <option>小杯</option>
                </select>
            </div>
            &nbsp;
            <div class="form-group">
                冷热：
                <select class="form-control">
                    <option>全部</option>
                    <option>冷</option>
                    <option>热</option>
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
                        <input name="size-1" type="radio" value="1:s1" checked>大杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size-1" type="radio" value="1:s2">中杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size-1" type="radio" value="1:s3">小杯</input>
                    </label>
                </td>
                <td align="center">
                    <label class="radio-inline">
                        <input name="temp" type="radio" value="1:t1" checked>热</input>
                    </label>
                    <label class="radio-inline">
                        <input name="temp" type="radio" value="1:t2">冷</input>
                    </label>
                </td>
                <td>25</td>
                <td>
                    <a href="/goto_set?sid=1" target="_blank">加入购物车</a>
                </td>
            </tr>
            </#list>
            <tr>
                <td>2</td>
                <td>卡布其诺</td>
                <td align="center">
                    <label class="radio-inline">
                        <input name="size-2" type="radio" value="2:s1" checked>大杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size-2" type="radio" value="2:s2">中杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size-2" type="radio" value="2:s3">小杯</input>
                    </label>
                </td>
                <td align="center">
                    <label class="radio-inline">
                        <input type="radio" value="2:t1" checked>热</input>
                    </label>
                    <label class="radio-inline">
                        <input type="radio" value="2:t2">冷</input>
                    </label>
                </td>
                <td>25</td>
                <td>
                    <a href="/goto_set?sid=1" target="_blank">加入购物车</a>
                </td>
            </tr>

            <tr>
                <td>3</td>
                <td>猫屎咖啡</td>
                <td align="center">
                    <label class="radio-inline">
                        <input name="size-3" type="radio" checked>中杯</input>
                    </label>
                    <label class="radio-inline">
                        <input name="size-3" type="radio">小杯</input>
                    </label>
                </td>
                <td align="center">
                    <label class="radio-inline">
                        <input type="radio" checked>热</input>
                    </label>
                </td>
                <td>25</td>
                <td>
                    <a href="/goto_set?sid=1" target="_blank">加入购物车</a>
                </td>
            </tr>
        </table>

        <div align="center">
            <nav aria-lable="Page navigation">
                <ul class="pagination">
                    <li class="disabled"><a href="javascript:void(0);">首页</a></li>
                    <li class="disabled">
                        <a href="javascript:void(0);" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                    <li class="active"><a href="javascript:void(0);">1</a></li>
                    <li><a href="/all_students?page=2">2</a></li>

                    <li>
                        <a href="/all_students?page=2" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="/all_students?page=2">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
