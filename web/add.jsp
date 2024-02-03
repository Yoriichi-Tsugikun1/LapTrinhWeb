<%-- 
    Document   : add
    Created on : Dec 23, 2023, 11:10:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="upfile" method="post" enctype="multipart/form-data">
<!--            <label for="file">Select an image to upload:</label>
            <input type="file" name="file1" id="fileInput" accept="image/*" required>-->
            <br>
            <input type="submit" value="Upload">
        </form>

        <!-- Hiển thị ảnh đã chọn -->
        <div id="imagePreview"></div>

<!--        <script>
            document.getElementById('fileInput').addEventListener('change', function (event) {
                var fileInput = event.target;
                var imagePreview = document.getElementById('imagePreview');

                // Kiểm tra xem có file nào được chọn không
                if (fileInput.files.length > 0) {
                    var file = fileInput.files[0];

                    // Đọc URL của file
                    var imageURL = URL.createObjectURL(file);

                    // Hiển thị ảnh đã chọn
                    imagePreview.innerHTML = '<img src="' + imageURL + '" alt="Selected Image" style="max-width: 10%;">';
                } else {
                    // Nếu không có file nào được chọn, xóa ảnh hiển thị
                    imagePreview.innerHTML = '';
                }
            });
        </script>-->

    </body>
</html>
