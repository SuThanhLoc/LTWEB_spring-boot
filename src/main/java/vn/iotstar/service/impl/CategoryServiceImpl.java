package vn.iotstar.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iotstar.Entity.Category;
import vn.iotstar.Repository.CategoryRepository;
import vn.iotstar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	// Constructor injection
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findByCategoryNameContaining(String name) {
		return categoryRepository.findByCateNameContaining(name);
	}

	@Override
	public Page<Category> findByCategoryNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByCateNameContaining(name, pageable);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}
}
