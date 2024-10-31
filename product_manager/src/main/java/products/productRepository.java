package products;

import org.springframework.data.repository.CrudRepository;

public interface productRepository extends CrudRepository<product, Integer> {
}
