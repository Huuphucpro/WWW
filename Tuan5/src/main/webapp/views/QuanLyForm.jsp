<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý điện thoại</title>
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
        .product-table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        .product-table th, .product-table td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .product-table th { background-color: #f8f9fa; font-weight: bold; }
        .product-table tr:nth-child(even) { background-color: #f8f9fa; }
        .product-image { width: 80px; height: 80px; object-fit: cover; border-radius: 4px; }
        .btn-delete { background-color: #dc3545; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: pointer; }
        .btn-delete:hover { background-color: #c82333; }
        .no-products { text-align: center; color: #666; font-style: italic; padding: 40px; }
        .confirmation { background-color: #fff3cd; border: 1px solid #ffeaa7; padding: 10px; border-radius: 4px; margin: 10px 0; }
    </style>
    <script>
        function confirmDelete(maDT, tenDT) {
            if (confirm('Bạn có chắc chắn muốn xóa điện thoại "' + tenDT + '" (Mã: ' + maDT + ')?')) {
                return true;
            }
            return false;
        }
    </script>
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
        <h2>Quản lý điện thoại</h2>
        
        <!-- Form tìm kiếm -->
        <div class="search-form">
            <form action="../QuanLyFormServlet" method="get">
                <input type="text" name="keyword" placeholder="Tìm kiếm điện thoại..." value="${param.keyword}">
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>
        
        <!-- Hiển thị danh sách sản phẩm với chức năng xóa -->
        <c:choose>
            <c:when test="${not empty list}">
                <table class="product-table">
                    <thead>
                        <tr>
                            <th>Hình ảnh</th>
                            <th>Mã ĐT</th>
                            <th>Tên điện thoại</th>
                            <th>Năm SX</th>
                            <th>Nhà cung cấp</th>
                            <th>Cấu hình</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dt" items="${list}">
                            <tr>
                                <td>
                                    <c:if test="${not empty dt.hinhAnh}">
                                        <img src="../uploads/${dt.hinhAnh}" alt="${dt.tenDT}" class="product-image" 
                                             onerror="this.src='../images/no-image.png'">
                                    </c:if>
                                    <c:if test="${empty dt.hinhAnh}">
                                        <img src="../images/no-image.png" alt="No Image" class="product-image">
                                    </c:if>
                                </td>
                                <td>${dt.maDT}</td>
                                <td>${dt.tenDT}</td>
                                <td>${dt.namSX}</td>
                                <td>${dt.maNCC.tenNCC}</td>
                                <td>${dt.cauHinh}</td>
                                <td>
                                    <form action="../QuanLyFormServlet" method="post" style="display: inline;">
                                        <input type="hidden" name="maDT" value="${dt.maDT}">
                                        <input type="hidden" name="maNCC" value="${dt.maNCC.maNCC}">
                                        <button type="submit" class="btn-delete" 
                                                onclick="return confirmDelete('${dt.maDT}', '${dt.tenDT}')">
                                            Xóa
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
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
