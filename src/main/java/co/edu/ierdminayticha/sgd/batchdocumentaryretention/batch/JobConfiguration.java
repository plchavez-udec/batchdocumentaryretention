package co.edu.ierdminayticha.sgd.batchdocumentaryretention.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.ierdminayticha.sgd.batchdocumentaryretention.entity.DocumentEntity;


@Configuration
public class JobConfiguration {

	@Bean
	public DocumentItemReader getDocumentItemReader() {
		return new DocumentItemReader();
	}
	
	@Bean
	public DocumentItemProcessor getDocumentItemProcessor() {
		return new DocumentItemProcessor();
	}
	
	@Bean
	public DocumentItemWriter getDocumentItemWriter() {
		return new DocumentItemWriter();
	}
	
	@Bean
	public Step stepOne(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("stepOne")
				.<DocumentEntity, DocumentEntity>chunk(10)
				.reader(getDocumentItemReader())
				.processor(getDocumentItemProcessor())
				.writer(getDocumentItemWriter())
				.build();
	}
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, Step step) {
		return jobBuilderFactory.get("jop")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	
}
