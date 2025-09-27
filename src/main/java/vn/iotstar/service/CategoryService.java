package vn.iotstar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iotstar.Entity.Category;

public interface CategoryService { // Phải là "interface", không phải "class"

    // Lấy tất cả danh mục
    List<Category> findAll();

    // Lấy danh mục theo ID
    Optional<Category> findById(Integer id);

    // Tìm kiếm danh mục theo tên
    List<Category> findByCategoryNameContaining(String name);

    // Tìm kiếm danh mục theo tên và phân trang
    Page<Category> findByCategoryNameContaining (String name, Pageable pageable);

    // Lưu danh mục
    Category save(Category category);

    // Xóa danh mục theo ID
    void deleteById(Integer id);
    Page<Category> findAll(Pageable pageable);
}