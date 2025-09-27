<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Category</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <section class="row">
        <div class="col-6 offset-3 mt-4">
            <form action="<c:url value='/admin/categories/add' />" method="POST">
                <div class="card">
                    <div class="card-header">
                        <h2>Add New Category</h2>
                    </div>
                    <div class="card-body">
                        <!-- Hiển thị thông báo -->
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <!-- Category ID (ẩn, chỉ dùng khi sửa) -->
                        <input type="hidden" name="cateId" value="${category.cateId}" />
                        <!-- Category Name -->
                        <div class="mb-3">
                            <label for="categoryName" class="form-label">Category Name:</label>
                <input type="text" class="form-control" id="cateName" name="cateName" 
                    value="${category.cateName}" aria-describedby="cateNameHelp" 
                                   placeholder="Enter category name" required>
                        </div>
                        <!-- Image URL -->
                        <div class="mb-3">
                            <label for="images" class="form-label">Image URL:</label>
                <input type="text" class="form-control" id="icons" name="icons" 
                    value="${category.icons}" placeholder="Enter image URL">
                        </div>
                    </div>
                    <div class="card-footer text-muted">
                        <a href="<c:url value='/admin/categories/add' />" class="btn btn-secondary">
                            <i class="fas fa-plus"></i> New
                        </a>
                        <a href="<c:url value='/admin/categories' />" class="btn btn-success">
                            <i class="fas fa-list"></i> List Categories
                        </a>
                        <button class="btn btn-primary" type="submit">
                            <i class="fas fa-save"></i> Submit
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>