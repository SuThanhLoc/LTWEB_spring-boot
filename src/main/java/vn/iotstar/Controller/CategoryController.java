package vn.iotstar.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;

import vn.iotstar.Entity.Category;
import vn.iotstar.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@GetMapping("")
	public String list(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size, Model model) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "cateId")); // đổi field nếu khác
		Page<Category> categoryPage = StringUtils.hasText(name)
				? categoryService.findByCategoryNameContaining(name.trim(), pageable)
				: categoryService.findAll(pageable);

		model.addAttribute("page", categoryPage); // Page<Category> cho Thymeleaf vẽ phân tran
		model.addAttribute("name", name); // giữ lại keyword tìm kiếm
		model.addAttribute("pageTitle", "Danh sách Category");
		return "categories/list"; // ==> templates/categories/list.html
	}


	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("pageTitle", "Tạo mới Category");
		return "categories/form"; // gộp add/edit thành 1 form 
	}

	@PostMapping("/add")
	public String save(@ModelAttribute("category") Category category,
					  @RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
					  RedirectAttributes ra) {
		if (imageFile != null && !imageFile.isEmpty()) {
			try {
				String fileName = java.util.UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
				String uploadDir = "C:/upload/";
				java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadDir);
				if (!java.nio.file.Files.exists(uploadPath)) {
					java.nio.file.Files.createDirectories(uploadPath);
				}
				java.nio.file.Path filePath = uploadPath.resolve(fileName);
				imageFile.transferTo(filePath.toFile());
				category.setIcons(fileName);
			} catch (Exception e) {
				ra.addFlashAttribute("errorMessage", "Lỗi upload file: " + e.getMessage());
			}
		}
		categoryService.save(category);
		ra.addFlashAttribute("successMessage", "Đã tạo Category thành công!");
		return "redirect:/admin/categories";
	}

	

	@GetMapping("/edit/{categoryId}")
	public String edit(@PathVariable("categoryId") Integer categoryId, Model model, RedirectAttributes ra) {
		Optional<Category> opt = categoryService.findById(categoryId);
		if (opt.isEmpty()) {
			ra.addFlashAttribute("errorMessage", "Không tìm thấy Category ID: " + categoryId);
			return "redirect:/admin/categories";
		}
		model.addAttribute("category", opt.get());
		model.addAttribute("pageTitle", "Cập nhật Category");
		return "categories/form";
	}

	@PostMapping("/edit")
	public String update(@ModelAttribute("category") Category category,
						@RequestParam(value = "imageFile", required = false) MultipartFile imageFile,
						RedirectAttributes ra) {
		if (imageFile != null && !imageFile.isEmpty()) {
			try {
				String fileName = java.util.UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
				   String uploadDir = "C:/upload/";
				java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadDir);
				if (!java.nio.file.Files.exists(uploadPath)) {
					java.nio.file.Files.createDirectories(uploadPath);
				}
				java.nio.file.Path filePath = uploadPath.resolve(fileName);
				imageFile.transferTo(filePath.toFile());
				category.setIcons(fileName);
			} catch (Exception e) {
				ra.addFlashAttribute("errorMessage", "Lỗi upload file: " + e.getMessage());
			}
		}
		categoryService.save(category);
		ra.addFlashAttribute("successMessage", "Đã cập nhật Category thành công!");
		return "redirect:/admin/categories";
	}

	@PostMapping("/delete/{categoryId}")
	public String delete(@PathVariable("categoryId") Integer categoryId, RedirectAttributes ra) {
		categoryService.deleteById(categoryId);
		ra.addFlashAttribute("successMessage", "Đã xóa Category!");
		return "redirect:/admin/categories";
	}

	@GetMapping("/search")
	public String legacySearch(@RequestParam(name = "name", required = false) String name) {
		return "redirect:/admin/categories?name=" + (name == null ? "" : name);
	}

	@GetMapping("/searchpaginated")
	public String legacySearchPaginated(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return "redirect:/admin/categories?name=" + (name == null ? "" : name) + "&page=" + page + "&size=" + size;
	}
}
