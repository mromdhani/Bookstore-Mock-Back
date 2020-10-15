package be.businesstraining.repository;

import be.businesstraining.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriesRepository extends JpaRepository<Category,Long> {
}
