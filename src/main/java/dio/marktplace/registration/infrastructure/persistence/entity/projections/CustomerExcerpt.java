package dio.marktplace.registration.infrastructure.persistence.entity.projections;

import dio.marktplace.registration.infrastructure.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="excerpet", types = Customer.class)
public interface CustomerExcerpt {
    String getFirstName();
    String getLastName();

    @Value("#{target.adress?.toString()}")
    String getAdress();
}
