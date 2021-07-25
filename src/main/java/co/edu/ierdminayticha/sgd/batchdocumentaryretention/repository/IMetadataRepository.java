package co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.MetadataEntity;

@Repository
public interface IMetadataRepository extends CrudRepository<MetadataEntity, Long> {

	MetadataEntity findByNameAndParent(String name, Long idParent);

}
