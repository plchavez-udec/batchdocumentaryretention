package co.edu.ierdminayticha.sgd.batchdocumentaryretention.batch;

import java.util.Iterator;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.DocumentEntity;
import co.edu.ierdminayticha.sgd.batchdocumentaryretention.repository.IDocumentsRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DocumentItemReader implements ItemReader<DocumentEntity> {

	@Autowired
	private IDocumentsRepository repository;

	private Iterator<DocumentEntity> documents;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.documents = this.repository.findAll().iterator();
	}

	@Override
	public DocumentEntity read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (this.documents.hasNext()) {
			return this.documents.next();
		} else {
			return null;
		}
	}

}
