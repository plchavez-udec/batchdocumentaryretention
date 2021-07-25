package co.edu.ierdminayticha.sgd.batchdocumentaryretention;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	public JobLauncher getJobLauncher() {
		return new SimpleJobLauncher();
	}
}
