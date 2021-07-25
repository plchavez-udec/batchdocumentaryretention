package co.edu.ierdminayticha.sgd.batchdocumentaryretention;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchdocumentaryretentionApplication implements CommandLineRunner {
	
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(BatchdocumentaryretentionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameter = new  JobParametersBuilder().addDate("date", new Date()).toJobParameters();
		this.jobLauncher.run(this.job, jobParameter);
	}

}
