package co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.BinaryEntity;

@Repository
public interface IBinaryRepository extends JpaRepository<BinaryEntity, String> {

}
