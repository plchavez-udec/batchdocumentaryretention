package co.edu.ierdminayticha.sgd.batchdocumentaryretention.batch;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.DocumentEntity;
import co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository.IBinaryRepository;
import co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository.IChildrenRepository;
import co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository.IDocumentsRepository;

public class DocumentItemProcessor implements ItemProcessor<DocumentEntity, DocumentEntity> {

	@Autowired
	private IDocumentsRepository repository;
	@Autowired
	private IBinaryRepository binaryRepository;
	@Autowired
	private IChildrenRepository childrenRepository;

	@Override
	public DocumentEntity process(DocumentEntity item) throws Exception {
		if (item.getMetadataEntity().getPreservationDate().isAfter(LocalDate.now())) {
			LocalDate newDate = item.getMetadataEntity().getPreservationDate().minusDays(1);
			item.getMetadataEntity().setPreservationDate(newDate);
			return item;
		} else if (item.getMetadataEntity().getPreservationDate().equals(LocalDate.now())) {
			if (item.getMetadataEntity().getSubSerie() != null) {
				if (item.getMetadataEntity().getSubSerie().getFinalDisposalType().getInitials().equals("EA")) {
					this.deleteEntities(item);
				}
			} else {
				if (item.getMetadataEntity().getSerie().getFinalDisposalType().getInitials().equals("EA")) {
					this.deleteEntities(item);
				}
			}
			return null;
		} else {
			return null;
		}

	}

	private void deleteEntities(DocumentEntity item) {
		this.repository.delete(item);
		this.binaryRepository.deleteById(item.getBinaryCode());
		this.childrenRepository.deleteById(item.getId());
	}

}
