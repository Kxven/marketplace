package dio.marktplace.registration.infrastructure.event;

import dio.marktplace.registration.infrastructure.persistence.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RepositoryEventHandler
public class CustomerEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomerEventHandler.class);

    @HandleAfterCreate
    public void handlerAfterCreate(Customer customer){
        logger.warn("CustomerEventHandler#handleAfterCreate");
    }

    @HandleAfterSave
    public void handleAfterSave(Customer customer){
        logger.warn("CustomerEventHandler#handlerAfterSave");
    }

    @HandleAfterDelete
    public void handleAfterDelete(Customer customer){
        logger.warn("CustomerEventHandler#handlerAfterDelete");
    }
}
