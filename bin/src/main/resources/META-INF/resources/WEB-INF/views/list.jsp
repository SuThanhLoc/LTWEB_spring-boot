<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <section class="row">
        <div class="col mt-4">
            <div class="card">
                <div class="card-header">
                    <h2>List Category</h2>
                </div>
                <div class="card-body">
                    <!-- Hiển thị thông báo -->
                    <c:if test="${not empty message}">
                        <div class="alert alert-success" role="alert">
                            <i>${message}</i>
                        </div>
                    </c:if>
                    <!-- Form tìm kiếm -->
                    <form method="get" action="<c:url value='/admin/categories/search' />" class="mb-3">
                        <div class="input-group">
                            <input type="text" class="form-control" name="name" placeholder="Search by name">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </div>
                    </form>
                    <!-- Bảng danh sách -->
                    <table class="table table-striped table-responsive">
                        <thead class="thead-dark">
                            <tr>
                                <th>Category ID</th>
                                <th>Category Name</th>
                                <th>Image</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${categories}" var="category">
                                <tr>
                                    <td>${category.cateId}</td>
                                    <td>${category.cateName}</td>
                                    <td><img src="${category.icons}" width="50" alt="Category Image"/></td>
                                    <td>
                                        <a href="<c:url value='/admin/categories/edit/${category.cateId}' />" 
                                           class="btn btn-outline-warning btn-sm">
                                            <i class="fa fa-edit"></i> Edit
                                        </a>
                                        <a href="<c:url value='/admin/categories/delete/${category.cateId}' />"
                                           class="btn btn-outline-danger btn-sm" 
                                           onclick="return confirm('Are you sure you want to delete this category?')">
                                            <i class="fa fa-trash"></i> Delete
                                        </a>
                                    </td>
                                </tr>	
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer text-muted">
                    <a href="<c:url value='/admin/categories/add' />" class="btn btn-primary">
                        <i class="fas fa-plus"></i> Add New Category
                    </a>
                    <a href="<c:url value='/admin/categories/searchpaginated' />" class="btn btn-info">
                        <i class="fas fa-search"></i> View Paginated
                    </a>
                </div>
            </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>