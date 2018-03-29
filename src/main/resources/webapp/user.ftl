<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<style>

    .app-layout {
        display: flex;
        flex-direction: column;
        width: 100%;
        height: 100vh;
        margin: 0 auto;
        background: #f2f2f2;
    }

    .content-layout {
        margin: 0 auto;
        padding: 10px 100px;
        background: #f2f2f2;
        flex: 1;
    }

    .footer-layout {
        width: 100%;
        margin: 0 auto;
    }
    .footer {
        width: 100%;
        height: 60px;
        background-color: #fff;
        line-height: 60px;
        font-size: 14px;
        color: #666;
        text-align: center;
        border-top: 1px solid #d8d8d8;
    }
    .text {
        width: 1040px;
        margin-left: auto;
        margin-right: auto;
    }

    .content-page {
        height: 100%;
        background: #ffffff;
    }

    .jobmenu {
        height: 100vh;
        text-align: center;
        padding-top: 10px;
        border-right: 2px solid #f2f2f2;
    }

    .menu-content {
        height: 100%;
        padding: 10px;
    }

</style>

<script type="text/javascript">

    $(document).ready(function(){
        $('.my-apply').click(function(e){
            console.info("myapply");
            $(".content-container").empty();
            $(".content-container").append('<table id="table"></table>');
            $('#table').bootstrapTable({
                ajax : function (request) {
                    $.ajax({
                        type : "GET",
                        url : "http://localhost:8080/job/myapply",
                        contentType: "application/json;charset=utf-8",
                        dataType:"json",
//                        data:'',
                        jsonp:'callback',
                        success : function (msg) {
                            request.success({
                                row : msg
                            });
                            $('#table').bootstrapTable('load', msg);
                        },
                        error:function(){
                            alert("错误");
                        }
                    });
                },

                toolbar:'#toolbar',
                singleSelect:true,
                clickToSelect:true,
                sortName: "create_time",
                sortOrder: "desc",
                pageSize: 15,
                pageNumber: 1,
                pageList: "[10, 25, 50, 100, All]",
                showToggle: true,
                showRefresh: true,
                showColumns: true,
                search: true,
                pagination: true,
                columns: [{
                    field: 'job_name',
                    title: '推荐位名称',
                    switchable: true
                }, {
                    field: 'create_time',
                    title: '创建时间',
                    switchable: true,
                    sortable: true
                },{
                    field: "state",
                    checkbox:true,
                }],

            });
        });
        $('.my-resume').click(function(e){
            console.info("resume");
            $(".content-container").html("myresume.ftl");
        });
        $('.my-account').click(function(e){
            console.info("account");
            $(".content-container").in
        });
    });



</script>

<body>

<div class="app-layout">
<#include "head.ftl"/>

    <div class="content-layout">
        <div class="container content-page">
            <div class="row">
                <div class="col-xs-3" style="padding: 0px ">
                    <div class="jobmenu">
                        <ul class="nav nav-pills nav-stacked">
                            <li class="my-apply"><a href="#">我的申请</a></li>
                            <li class="my-resume"><a href="#">我的简历</a></li>
                            <li class="my-account"><a href="#">账号设置</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-9 menu-content">
                    <div class="content-container">
                        <#--<div id="my-apply"></div>-->
                        <#--<div hidden="hidden" id="my-resume"></div>-->
                        <#--<div hidden="hidden" id="my-account"></div>-->
                    </div>
                </div>
            </div>
        </div>


    </div>
<#include "footer.ftl"/>
</div>

</body>
</html>