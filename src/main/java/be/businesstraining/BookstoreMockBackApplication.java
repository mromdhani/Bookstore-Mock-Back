package be.businesstraining;

import be.businesstraining.domain.Book;
import be.businesstraining.domain.Category;
import be.businesstraining.repository.IBooksRepository;
import be.businesstraining.repository.ICategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class BookstoreMockBackApplication {

	private static final Logger log =
			LoggerFactory.getLogger(BookstoreMockBackApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BookstoreMockBackApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ICategoriesRepository catRepo, IBooksRepository bookRepo) {
		return (args) -> {
			// Create Category "Programming"
			Category cat1 = new Category(null, "Programming", null);
			catRepo.save(cat1);

			Book b11 = new Book(null, "Java OCA", "Kathy Sierra", cat1, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, "https://images-na.ssl-images-amazon.com/images/I/51ptF7BSDYL._SX403_BO1,204,203,200_.jpg" );
			Book b12 = new Book(null, "Spring In Action", "Craig Walls", cat1, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, "https://learning.oreilly.com/library/cover/9781617294945/250w/" );
			Book b13 = new Book(null, "Angular In Action", "Jeremy Wilken", cat1, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, "https://images-na.ssl-images-amazon.com/images/I/41Vs-83rPxL._SX258_BO1,204,203,200_.jpg");
						Book b14 = new Book(null, "GOF Design patterns", "The GOF", cat1, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, "https://images-na.ssl-images-amazon.com/images/I/51kuc0iWoKL._SX326_BO1,204,203,200_.jpg" );
		    bookRepo.saveAll(Arrays.asList(b11, b12, b13, b14));

		    // Create Category "Litterature"
			Category cat2 = new Category(null, "Litterature", null);
			catRepo.save(cat2);

			Book b21 = new Book(null, "Les misérables", "Victor Hugo", cat2, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, null );
			Book b22 = new Book(null, "L'être et le néant", "Jean Paul Sartres", cat2, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, null );
			Book b23 = new Book(null, "L'étranger", "Albert Camus", cat2, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, null );
			Book b24 = new Book(null, "Don Quichotte", "Miguel de Cervantes Saavedra", cat2, "Some description Lorem ipsum Lorem ipsum", BigDecimal.TEN, null );
			bookRepo.saveAll(Arrays.asList(b21, b22, b23, b24));

			// fetch all categories
			log.info("Categories found with findAll():");
			log.info("-------------------------------");
			for( Category category : catRepo.findAll()) {
				log.info(category.getTitle());
			}
			// fetch all categories
			log.info("Books found with findAll():");
			log.info("-------------------------------");
			for( Book book : bookRepo.findAll()) {
				log.info(book.getTitle());
			}
			// Test filtering by title or author
			log.info("Test Filering by title or author name");
			log.info("-------------------------------");
			for( Book book : bookRepo.findAllByTitleContainingIgnoreCaseOrAuthorsContainingIgnoreCase("P", "P")) {
				log.info("Title: " +book.getTitle() + "Authors: "+ book.getAuthors());
			}
		};
	}

}
