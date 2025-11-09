<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách điện thoại</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f5f5f5; }
        .header { background-color: #fff; border-bottom: 2px solid #007bff; padding: 20px; }
        .logo { text-align: center; margin-bottom: 20px; }
        .logo h1 { color: #007bff; font-size: 2.5em; margin: 0; }
        .logo .subtitle { color: #666; font-size: 1.2em; margin: 5px 0; }
        .nav { text-align: center; background-color: #fff; border-bottom: 1px solid #007bff; padding: 15px; }
        .nav a { color: #007bff; text-decoration: none; margin: 0 20px; font-weight: bold; }
        .nav a:hover { text-decoration: underline; }
        .main-content { background-color: #fff; margin: 20px; padding: 20px; border: 1px solid #ddd; }
        .footer { background-color: #fff; border-top: 1px solid #007bff; padding: 15px; text-align: center; color: #007bff; }
        .search-form { margin-bottom: 20px; padding: 15px; background-color: #f8f9fa; border: 1px solid #dee2e6; }
        .search-form input { padding: 8px; margin: 5px; border: 1px solid #ccc; border-radius: 4px; }
        .search-form button { padding: 8px 15px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        .search-form button:hover { background-color: #0056b3; }
        .product-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 20px; margin-top: 20px; }
        .product-card { border: 1px solid #ddd; border-radius: 8px; padding: 15px; background-color: #fff; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .product-image { width: 100%; height: 200px; object-fit: cover; border-radius: 4px; margin-bottom: 10px; }
        .product-title { font-size: 1.2em; font-weight: bold; color: #333; margin-bottom: 5px; }
        .product-info { color: #666; margin-bottom: 5px; }
        .product-config { background-color: #f8f9fa; padding: 10px; border-radius: 4px; margin: 10px 0; }
        .no-products { text-align: center; color: #666; font-style: italic; padding: 40px; }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo">
            <h1>fango™</h1>
            <div class="subtitle">HomePHONE</div>
        </div>
    </div>
    
    <div class="nav">
        <a href="../index.jsp">Trang chủ</a> |
        <a href="../listdt">Danh sách sản phẩm</a> |
        <a href="../form">Thêm mới sản phẩm</a> |
        <a href="../QuanLyFormServlet">Chức năng quản lý</a>
    </div>
    
    <div class="main-content">
        <h2>Danh sách điện thoại</h2>
        
        <!-- Form tìm kiếm -->
        <div class="search-form">
            <form action="../listdt" method="get">
                <input type="text" name="keyword" placeholder="Tìm kiếm theo tên, cấu hình..." value="${param.keyword}">
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>
        
        <!-- Hiển thị danh sách sản phẩm -->
        <c:choose>
            <c:when test="${not empty list}">
                <div class="product-grid">
                    <c:forEach var="dt" items="${list}">
                        <div class="product-card">
                            <c:if test="${not empty dt.hinhAnh}">
                                <img src="../uploads/${dt.hinhAnh}" alt="${dt.tenDT}" class="product-image" 
                                     onerror="this.src='../images/no-image.png'">
                            </c:if>
                            <c:if test="${empty dt.hinhAnh}">
                                <img src="../images/no-image.png" alt="No Image" class="product-image">
                            </c:if>
                            
                            <div class="product-title">${dt.tenDT}</div>
                            <div class="product-info"><strong>Mã ĐT:</strong> ${dt.maDT}</div>
                            <div class="product-info"><strong>Năm SX:</strong> ${dt.namSX}</div>
                            <div class="product-info"><strong>Nhà cung cấp:</strong> ${dt.maNCC.tenNCC}</div>
                            
                            <div class="product-config">
                                <strong>Cấu hình:</strong><br>
                                ${dt.cauHinh}
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <div class="no-products">
                    <p>Không tìm thấy sản phẩm nào.</p>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    
    <div class="footer">
        Họ tên sinh viên – Mã sinh viên – Lớp
    </div>
</body>
</html>