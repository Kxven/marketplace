package dio.marktplace.registration.infrastructure.persistence.repository;

import dio.marktplace.registration.infrastructure.persistence.entity.Customer;
import dio.marktplace.registration.infrastructure.persistence.entity.projections.CustomerExcerpt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(excerptProjection = CustomerExcerpt.class)
public interface CustomerEntityRepository extends PagingAndSortingRepository<Customer, UUID>, CrudRepository<Customer, UUID> {
    List<Customer> findByFirstNameStartingWithIgnoreCase(@Param("firstName")String firtsName);
    @Override
    @RestResource
    void deleteById(UUID id);
}
