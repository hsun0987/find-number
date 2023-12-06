<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>숫자 필터 프로그램</title>
</head>
<body>
<div id="container">
    <h3>숫자 필터 프로그램</h3>
    <form action="find-number" method="get">
        <div>
            <input type="text" name="input">
        </div>
        <div>
            <input type="submit" value="전송하기">
        </div>
    </form>
</div>
</body>
<style>
    html {
        height: 100%;
    }
    body {
        box-sizing: border-box;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 60%;
    }
    h3 {
        margin-top: 0px;
        padding-top: 0px;
    }
    #container {
        border-style: solid;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 500px;
        height: 150px;
    }
    input[type="text"] {
        width: 400px;
        margin-bottom: 10px;
    }
</style>
</html>