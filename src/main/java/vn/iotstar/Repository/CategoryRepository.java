package vn.iotstar.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // Tìm kiếm danh mục theo tên (không phân biệt hoa thường, chứa chuỗi)
    List<Category> findByCateNameContaining(String name);

    // Tìm kiếm danh mục theo tên và phân trang
    Page<Category> findByCateNameContaining(String name, Pageable pageable);
}
