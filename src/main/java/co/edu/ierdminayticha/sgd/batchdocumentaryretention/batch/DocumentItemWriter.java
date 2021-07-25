package co.edu.ierdminayticha.sgd.batchdocumentaryretention.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.DocumentEntity;
import co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository.IDocumentsRepository;

public class DocumentItemWriter implements ItemWriter<DocumentEntity> {

	@Autowired
	private IDocumentsRepository repository;

	@Override
	public void write(List<? extends DocumentEntity> items) throws Exception {
		this.repository.saveAll(items);
	}

}
