<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm điện thoại mới</title>
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
        .form-container { max-width: 600px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; color: #333; }
        .form-group input, .form-group select, .form-group textarea { 
            width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; 
            box-sizing: border-box; font-size: 14px;
        }
        .form-group textarea { height: 80px; resize: vertical; }
        .required { color: red; }
        .error { color: red; font-size: 12px; margin-top: 5px; }
        .button-group { text-align: center; margin-top: 20px; }
        .btn { padding: 10px 20px; margin: 0 10px; border: none; border-radius: 4px; cursor: pointer; font-size: 14px; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .btn:hover { opacity: 0.8; }
    </style>
    <script>
        function validateForm() {
            var maDT = document.getElementById('maDT').value;
            var tenDT = document.getElementById('tenDT').value;
            var namSX = document.getElementById('namSX').value;
            var cauHinh = document.getElementById('cauHinh').value;
            var hinhAnh = document.getElementById('hinhAnh').value;
            
            var errors = [];
            
            // Kiểm tra bắt buộc
            if (!maDT.trim()) errors.push('Mã điện thoại là bắt buộc');
            if (!tenDT.trim()) errors.push('Tên điện thoại là bắt buộc');
            if (!namSX.trim()) errors.push('Năm sản xuất là bắt buộc');
            if (!cauHinh.trim()) errors.push('Cấu hình là bắt buộc');
            
            // Kiểm tra năm sản xuất (4 chữ số)
            var yearRegex = /^\d{4}$/;
            if (namSX && !yearRegex.test(namSX)) {
                errors.push('Năm sản xuất phải là 4 chữ số');
            }
            
            // Kiểm tra cấu hình (không quá 255 ký tự)
            if (cauHinh && cauHinh.length > 255) {
                errors.push('Cấu hình không được quá 255 ký tự');
            }
            
            // Kiểm tra file hình ảnh
            if (hinhAnh) {
                var allowedTypes = ['image/png', 'image/jpg', 'image/jpeg'];
                var fileType = document.getElementById('hinhAnh').files[0]?.type;
                if (fileType && !allowedTypes.includes(fileType)) {
                    errors.push('Hình ảnh chỉ chấp nhận định dạng PNG, JPG, JPEG');
                }
            }
            
            if (errors.length > 0) {
                alert('Lỗi:\n' + errors.join('\n'));
                return false;
            }
            
            return true;
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
        <h2>Thêm điện thoại mới</h2>
        
        <div class="form-container">
            <form action="../form" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="maDT">Mã điện thoại <span class="required">*</span></label>
                    <input type="text" id="maDT" name="maDT" required>
                </div>
                
                <div class="form-group">
                    <label for="tenDT">Tên điện thoại <span class="required">*</span></label>
                    <input type="text" id="tenDT" name="tenDT" required>
                </div>
                
                <div class="form-group">
                    <label for="namSX">Năm sản xuất <span class="required">*</span></label>
                    <input type="number" id="namSX" name="namSX" min="1900" max="2030" required>
                </div>
                
                <div class="form-group">
                    <label for="cauHinh">Cấu hình <span class="required">*</span></label>
                    <textarea id="cauHinh" name="cauHinh" maxlength="255" required></textarea>
                </div>
                
                <div class="form-group">
                    <label for="maNCC">Nhà cung cấp <span class="required">*</span></label>
                    <select id="maNCC" name="maNCC" required>
                        <option value="">-- Chọn nhà cung cấp --</option>
                        <option value="NCC01">Công ty A</option>
                        <option value="NCC02">Công ty B</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="hinhAnh">Hình ảnh</label>
                    <input type="file" id="hinhAnh" name="hinhAnh" accept=".png,.jpg,.jpeg">
                    <small>Chỉ chấp nhận file PNG, JPG, JPEG</small>
                </div>
                
                <div class="button-group">
                    <button type="submit" class="btn btn-primary">Thêm</button>
                    <button type="reset" class="btn btn-secondary">Làm mới</button>
                    <a href="../listdt" class="btn btn-secondary">Quay lại</a>
                </div>
            </form>
        </div>
    </div>
    
    <div class="footer">
        Họ tên sinh viên – Mã sinh viên – Lớp
    </div>
</body>
</html> 