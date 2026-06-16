package dio.marktplace.registration.infrastructure.persistence.repository;

import dio.marktplace.registration.infrastructure.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerEntityRepository extends CrudRepository<Customer, UUID> {
}
