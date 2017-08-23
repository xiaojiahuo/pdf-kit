<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">
        body {
            font-family: pingfang sc light;
        }
        .center{
            text-align: center;
            font-size: 25px;
            width: 100%;
        }

        .firstTitle{
            font-size: 20px;
            padding-bottom: 6px;
            padding-top: 6px;
        }
    </style>
</head>
<body>
<!--第一页开始-->
<div class="page" >
    <div class="center"><p>${title}</p></div>
    <#list service?keys as key>
        <div>
            <div class="firstTitle">${key}:</div>
            <div>${service[key]}</div>
        </div>
    </#list>

    <div >
        <div class="firstTitle">授权确认:</div>
        <div>${authorizationDate}</div>
    </div>
    <div>
        <div class="firstTitle">授权内容:</div>
        <p style="text-align: center;font-size: 20px">${authorizationContentTile}</p>
        <div>${authorizationContent}</div>
    </div>

</div>
<!--第一页结束-->
</body>
</html>