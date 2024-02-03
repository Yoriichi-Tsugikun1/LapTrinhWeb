
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.user" %>
<%
    Object a = session.getAttribute("account");
    
    if(a==null){
        response.sendRedirect("/btl/dangnhap");
        return;
    }
    else {
        user u = (user) a;
        if(u.getRole()==1){
            response.sendRedirect("/btl/dangnhap");
            return;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông Tin Đơn Hàng</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
              integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
              integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="chiTietsp.css">
        <link rel="stylesheet" href="base.css">
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
        <link rel="stylesheet" type="text/css" href="https://kenwheeler.github.io/slick/slick/slick-theme.css" />
        <style>
            .section-4{
                padding: 50px 0;
            }
            .section-4 .inner-image img{
                width: 100%;
                height: auto;
                object-fit: cover;
            }
            .section-4 .inner-item{
                border-radius: 10px;
                margin-top: 20px;
                text-align: center;
                box-shadow: 0 1px 3px 0 rgb(0 0 0 / 20%);
                background: #FFF;
                padding: 10px;
            }
            .section-4 .inner-item img{
                padding: 10px;
                transition: all 0.4s ease-in-out;
            }
            .section-4 .inner-item img:hover{
                transform: scale(1.1);
                transition: all 0.4s ease-in-out;
            }
            .section-4 .inner-name p{
                font-size: 18px;
            }
            .section-4 .inner-price h5{
                color: var(--color-3);
                font-style: italic;
            }

            .dropbtn {
                background-color: #3498DB;
                color: white;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            .dropbtn:hover,
            .dropbtn:focus {
                background-color: #2980B9;
            }

            .dropdown-profile {
                position: relative;
                display: inline-block;
            }
            .dropdown-profile img{
                width: 50px;
                height: auto;
                border-radius: 50%;
            }
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                margin-top: 10px;
                min-width: 160px;
                overflow: auto;
                box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
                z-index: 1;
                border-radius: 10px;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                box-shadow: 0 1px 1px 0 rgb(0 0 0 / 20%);
                transition: all 0.3s ease-in-out;
            }

            .dropdown-content a:hover {
                background-color: var(--color-2);
                color: #FFF;
                transition: all 0.3s ease-in-out;
            }

            .show {
                display: block;
            }

            .header .inner-gioHang i{
                color: #FFF;
                font-size: 30px;
            }
            .header .inner-gioHang .inner-badge{
                position: absolute;
                top: -15px;
                right: 34px;
                border: none;
                display: inline-flex;
                min-width: 20px;
                height: 20px;
                border-radius: 25px;
                font-size: 12px;
                align-items: center;
                justify-content: center;
                color: #FFF;
                padding: 5px;
                background-color: #ff2200;
            }
            .inner-image .add-btn{
                display: inline-block;
                margin: 20px 0;
                background-color: var(--color-2);
                text-decoration: none;
                color: #fff;
                padding: 8px 18px;
                border-radius: 12px;
                border: 1px solid var(--color-2);
                -webkit-transition: all 0.3s ease-in-out;
                -o-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
            }
            .inner-image .add-btn:hover{
                border-color: var(--color-2);
                background-color: #fff;
                color: var(--color-2);
            }
            .inner-image .add-btn i{
                margin-left: 10px;
            }
            table{
                border-collapse: collapse;
            }
            .section-lichSu .inner-main{
                border: 1px solid #DDD;
                padding: 10px 20px;
                border-radius: 10px;
                background-color: #FFF;
                box-shadow: 0 1px 3px 0 rgb(0 0 0 / 20%);
            }
            .section-lichSu .inner-button{
                margin-bottom: 30px;
            }
            .section-lichSu{
                background: #F2F2FE;
                padding: 50px 0;
                margin-top: 0;
            }
            .section-lichSu a{
                text-decoration: none;
                background-color: #2b80dd;
                ;
                color: #FFF;
                font-size: 16px;
                padding: 8px 20px;
                border-radius: 10px;
                border: 1px solid var(--color-2);
                -webkit-transition: all 0.3s ease-in-out;
                -o-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
            }
            .section-lichSu a:hover{
                border-color: var(--color-2);
                background-color: #fff;
                color: var(--color-2);
            }
            .section-lichSu h2{
                margin-bottom: 30px;
            }
            .section-lichSu .inner-product{
                display: flex;
                margin: 20px 0;
                border-bottom: 1px solid #DDD;
            }
            .section-lichSu .inner-product img{
                width: 200px;
                height: auto;
                margin: 0 40px 0 0;
            }

            .hienthi {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .hienthi th, .hienthi td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
                font-size: 20px;
            }

            .hienthi th {
                background-color: #f2f2f2;
            }
            .tbao{

                height: auto;
                width: 100%;
            }
            .xc{
                padding: 10px 35%;
            }
            .fxoa{
                margin-top: 10px;
                display: flex;
            }
            .ri{
                margin-left: 10px;
            }
            .hd{
                padding-left: 39%;
                padding-bottom: 50px;
            }
            .hd a{
                border: 1px solid black;
                padding: 5px;
                text-decoration: none;
                margin: 0 50px 0 0;
                border-radius: 10px;
                background-color: green;
                color: black;
            }
            .listrang {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .listrang a {
                text-decoration: none;
                margin: 0 10px;
                border: 1px solid black;
                border-radius: 20px;
                background-color: green;
            }
            .tsp {
                width: 80%;
                margin: 20px auto;
                display: flex;
            }

            .tsp-left {
                width: 70%;
                padding: 20px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 10px;
            }

            .tsp-right {
                width: 30%;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 10px;
                margin-left: 10px;
            }

            .tsp-right input,
            .tsp-left input,
            textarea {
                width: calc(100% - 16px);
                padding: 8px;
                margin-bottom: 10px;
                box-sizing: border-box;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            label {
                width: 100%;
                margin-bottom: 5px;
                font-weight: bold;
            }

            .tsp-left input[type="file"],
            .tsp-right input[type="file"] {
                margin-top: 5px;
            }

            .button-container {
                margin-top: 10px;
            }

            button {
                width: 100%;
                background-color: #333;
                color: #fff;
                padding: 10px;
                cursor: pointer;
                border: none;
                border-radius: 3px;
            }

            #imagePreview,
            #imagePreview2,
            #imagePreview3 {
                max-width: 100%;
                margin-top: 10px;
            }

            .tsp-right table {
                width: 100%;
            }

            .tsp-right table td {
                padding: 8px;
            }


            @media (max-width: 768px) {
                .tsp {
                    flex-direction: column;
                }

                .tsp-left,
                .tsp-right {
                    width: 100%;
                    margin-left: 0;
                }
            }
            .button-container {
                text-align: center;
                margin-top: 10px;
                margin-bottom: 10px;
            }
            .button-container input{
                border: 2px solid black;
                border-radius: 10px;
                background-color: white;
            }
            .tsp-left select{
                width: calc(100% - 16px);
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border-radius: 5px;
            }

        </style>
    </head>
    <body class="background-color">

        <!-- Header -->
        <div class="header-top"  id="home">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="inner-wrap">
                            <div class="inner-item">
                                <span>Theo dõi chúng tôi</span>
                                <a href="https://www.facebook.com/"><i class="fa-brands fa-facebook"></i></a>
                                <a href="https://www.instagram.com/"><i class="fa-brands fa-instagram"></i></a>
                                <a href="https://www.tiktok.com/"><i class="fa-brands fa-tiktok"></i></a>
                            </div>
                            <div class="inner-item">  
                                <i class="fa-solid fa-phone"></i>
                                Hotline: 0123456789
                            </div>
                            <div class="inner-item">
                                <form action="dangxuat" method="POST">
                                    <input type="submit" value="Đăng xuất" class="no-border">
                                </form>
                            </div>
                            <div class="dropdown-profile">
                                <a>
                                    <img onclick="myFunction()" class="dropbtn" src="image/avatar.png" alt="">
                                </a>
                                <div id="dropdown" class="dropdown-content">
                                    <a id="myLink" style="${sessionScope.account.role == 1? '' : 'display: none;'}" href="thongtin?account=${sessionScope.account.account}">
                                        Thông Tin
                                    </a>
                                    <!--                                    <a href="">Lịch sử mua hàng</a>-->
                                    <a id="myLink" style="${sessionScope.account.role == 2 ? '' : 'display: none;'}" href="DuyetDonHangServlet">
                                        Duyệt Hóa Đơn
                                    </a>
                                    <a id="myLink" style="${sessionScope.account.role == 2 ? '' : 'display: none;'}" href="ThemSanPhamServlet">
                                        Thêm Mặt Hàng
                                    </a> 
                                    <a id="myLink" style="${sessionScope.account.role == 2 ? '' : 'display: none;'}" href="DanhSachHoaDonServlet">
                                        Danh sách hóa đơn 
                                    </a>
                                    <a id="myLink" style="${sessionScope.account.role == 2 ? '' : 'display: none;'}" href="ThongTinTaiKhoanServlet">
                                        Thông Tin Tài  Khoản
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <header class="header">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-xl-1">
                        <div class="inner-logo">
                            <a href="index">
                                <img src="image/image.png" alt="Ảnh logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-9">
                        <form action="timkiem" class="inner-search">
                            <input type="text" name="name" required placeholder="Bạn đang tìm kiếm sản phẩm gì...">
                            <button type="submit">
                                <img src="image/search.svg" alt="">
                            </button>
                        </form>
                    </div>
                    <div class="col-xl-2">
                        <div class="inner-gioHang">
                            <a href="giohang">
                                <i class="fa-solid fa-cart-shopping"></i>
                            </a>
                            <span class="inner-badge">${sessionScope.size==null?0:sessionScope.size}</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="tbao" style="background-color: rgb(242,242,254)">
            <div class="xc" style="text-align: center; background-color: rgb(242,242,254); font-size: 30px">
                Xin Chào ${sessionScope.account.account}
            </div>
        </div>

        <form action="ThemSanPhamServlet" method="post" enctype="multipart/form-data">
            <div class="tsp">
                <div class="tsp-left">
                    <label for="id">ID</label>
                    <input type="text" name="id" value="${requestScope.masp}" readonly>
                    <label for="tensp">Tên Sản Phẩm</label>
                    <input type="text" name="tensp" required>
                    <label for="giaban">Giá bán</label>
                    <input type="number" name="giaban" required>
                    <label for="id">Số lượng</label>
                    <input type="number" name="soluong" required>
                    <label for="theloai">Thể loại</label>
                    <input type="text" name="theloai" required>
                    <label for="hang">Hãng</label> <br>
                    <select name="hang">
                        <option value="dell">DELL</option>
                        <option value="asus">ASUS</option>
                        <option value="lenovo">LENOVO</option>
                        <option value="msi">MSI</option>
                        <option value="apple">APPLE</option>
                        <option value="acer">ACER</option>
                        <option value="hp">HP</option>
                    </select>
                    <label for="mt1">Ảnh 1</label>
                    <input type="file" name="file" id="fileInput" accept="image/*" required>
                    <div id="imagePreview"></div>
                    <label for="mt1">Ảnh 2</label>
                    <input type="file" name="file1" id="fileInput2" accept="image/*" required>
                    <div id="imagePreview2"></div>
                    <label for="mt1">Ảnh 3</label>
                    <input type="file" name="file2" id="fileInput3" accept="image/*" required>
                    <div id="imagePreview3"></div>
                    <script>
                        document.getElementById('fileInput').addEventListener('change', function (event) {
                            var fileInput = event.target;
                            var imagePreview = document.getElementById('imagePreview');
                            if (fileInput.files.length > 0) {
                                var file = fileInput.files[0];
                                var imageURL = URL.createObjectURL(file);

                                imagePreview.innerHTML = '<img src="' + imageURL + '" alt="Selected Image" style="max-width: 10%;">';
                            } else {
                                imagePreview.innerHTML = '';
                            }
                        });
                        document.getElementById('fileInput2').addEventListener('change', function (event) {
                            var fileInput = event.target;
                            var imagePreview = document.getElementById('imagePreview2');
                            if (fileInput.files.length > 0) {
                                var file = fileInput.files[0];
                                var imageURL = URL.createObjectURL(file);

                                imagePreview.innerHTML = '<img src="' + imageURL + '" alt="Selected Image" style="max-width: 10%;">';
                            } else {
                                imagePreview.innerHTML = '';
                            }
                        });
                        document.getElementById('fileInput3').addEventListener('change', function (event) {
                            var fileInput = event.target;
                            var imagePreview = document.getElementById('imagePreview3');
                            if (fileInput.files.length > 0) {
                                var file = fileInput.files[0];
                                var imageURL = URL.createObjectURL(file);

                                imagePreview.innerHTML = '<img src="' + imageURL + '" alt="Selected Image" style="max-width: 10%;">';
                            } else {
                                imagePreview.innerHTML = '';
                            }
                        });
                    </script>
                </div>

                <div class="tsp-right">

                    <table>
                        <tr>
                            <td>Màn hình</td>
                            <td><input type="text" name="mh" placeholder="13.4 inches IPS Panel, 144Hz..." required></td>
                        </tr>
                        <tr>
                            <td>CPU</td>
                            <td><input type="text" name="cpu" placeholder="AMD Ryzen 7 6800HS ..." required></td>
                        </tr>
                        <tr>
                            <td>RAM</td>
                            <td><input type="text" name="ram" placeholder="8GB RAM..." required></td>
                        </tr>
                        <tr>
                            <td>Ổ cứng</td>
                            <td><input type="text" name="ocung" placeholder="512GB M.2 2230 NVMe™ PCIe® 4.0 SSD" required></td>
                        </tr>
                        <tr>
                            <td>Đồ họa</td>
                            <td><input type="text" name="dohoa" placeholder="NVIDIA GeForce RTX 2050 4GB" required></td>
                        </tr>
                        <tr>
                            <td>Hệ điều hành</td>
                            <td><input type="text" name="hdh" placeholder="Windows 11 Home" required></td>
                        </tr>
                        <tr>
                            <td>Trọng lượng</td>
                            <td><input type="text" name="trongluong" placeholder="2.3 kg" required></td>
                        </tr>
                        <tr>
                            <td>Kích thước</td>
                            <td><input type="text" name="kichthuoc" placeholder="35.9 x 25.6 x 2.28 ~ 2.45 cm" required></td>
                        </tr>
                        <tr>
                            <td>Xuất xứ</td>
                            <td><input type="text" name="xuatsu" placeholder="Mỹ" required></td>
                        </tr>
                        <tr>
                            <td>Năm ra mắt</td>
                            <td><input type="text" name="namramat" placeholder="2023" required></td>
                        </tr>

                    </table>
                </div>
            </div>
            <div class="button-container">
                <input type="submit" value="Thêm sản phẩm">
            </div>
        </form>



        <div class="section-12">
            <div class="container">
                <div class="row">
                    <div class="col-3">
                        <div class="inner-service">
                            <div class="img">
                                <img src="image/XMLID 141.svg" alt="">
                            </div>
                            <div class="desc">
                                <p>SẢN PHẨM CHẤT LƯỢNG</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="inner-service">
                            <div class="img">
                                <img src="image/Group 780.svg" alt="">
                            </div>
                            <div class="desc">
                                <p>DỊCH VỤ CHUYÊN NGHIỆP</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="inner-service">
                            <div class="img">
                                <img src="image/truck 1.svg" alt="">
                            </div>
                            <div class="desc">
                                <p>GIAO HÀNG TOÀN QUỐC</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="inner-service">
                            <div class="img">
                                <img src="image/Group 806.svg" alt="">
                            </div>
                            <div class="desc">
                                <p>MIỄN PHÍ BẢO HÀNH</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Section-12 -->

        <!-- Section-13 -->
        <div class="section-13">
            <div class="container">
                <div class="row">
                    <div class="col-3">
                        <img class="logo-footer" src="core/logo-main.svg" alt="">
                        <div class="contact">
                            <p>HOTLINE BÁN HÀNG</p>
                            <div class="img">
                                <img src="demo/fluent_video-person-call-16-filled.png" alt="">
                                <p>0912 250 625</p>
                            </div>
                        </div>
                        <div class="contact">
                            <p>CHĂM SÓC KHÁCH HÀNG</p>
                            <div class="img">
                                <img src="demo/fluent_video-person-call-16-filled.png" alt="">
                                <p>0912 250 625</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <div class="inner-wrap">
                            <div class="CSKH">
                                <h5>CHĂM SÓC KHÁCH HÀNG</h5>
                                <p>Chính sách bảo hành<br> Chính sách đổi trả sản phẩm <br>Hỏi đáp mua hàng online</p>
                            </div>
                            <div class="store">
                                <h5>CỬA HÀNG</h5>
                                <p>Laptop chính hãng <br>
                                    Bảo hành chọn đời <br>
                                    Sản phẩm khuyến mại
                                </p>
                            </div>
                            <div class="about">
                                <h5>VỀ CHÚNG TÔI</h5>
                                <p>Giới thiệu công ty <br>
                                    Hệ thống cửa hàng <br>
                                    Tuyển dụng
                                </p>
                            </div>
                            <div class="lienHe">
                                <h5>LIÊN HỆ</h5>
                                <p>
                                    <img src="image/Location2.png" alt="">56, Trần Phú, Hà Đông,
                                    <br> Hà Nội <br>
                                    <img src="image/Letter.png" alt="">Hệ thống cửa hàng <br>
                                    <img src="image/call.png" alt="">Tuyển dụng
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End section-13 -->
        <div class="button-contact">
            <a class="button-1" href="https://www.facebook.com/">
                <i class="fa-brands fa-facebook-messenger"></i>
            </a>
        </div>
        <div class="button-home">
            <a class="button-1" href="index#home">
                <i class="fa-solid fa-chevron-up"></i>
            </a>
        </div>
        <footer class="footer">
            <p>Copyright @2019 LAPTOP.vn</p>
        </footer>

        <!-- link nhúng -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous">
        </script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
                integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="slide.js"></script>
        <c:if test="${not empty sessionScope.er}">
            <script>
                        alert("${sessionScope.er}");
                <% session.setAttribute("er", null); %>
            </script>
        </c:if>
    </body>
</html>
