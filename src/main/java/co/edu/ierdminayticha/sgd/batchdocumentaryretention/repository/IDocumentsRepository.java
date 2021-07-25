package co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.DocumentEntity;

@Repository
public interface IDocumentsRepository extends CrudRepository<DocumentEntity, Long> {

}
