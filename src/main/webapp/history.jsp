<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>와이파이 정보 구하기</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }
        #customers td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 10px;
            text-align: center;
            background-color: #04AA6D;
            color: white;
        }
        #customers td {
            padding-top: 15px;
            padding-bottom: 22px;
            background-color: white;
            color: black;
            font-weight: 700;
        }
    </style>
</head>
<body>
<h1>위치 히스토리 목록</h1>
<p>
    <a href = "/">홈</a> <a>|</a>
    <a href = "history.jsp">위치 히스토리 목록</a> <a>|</a>
    <a href = "load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</p>
<p>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
    </tr>
</table>
</table>
</body>
</html>