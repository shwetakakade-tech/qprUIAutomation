package com.big.TestRunners;

import org.junit.jupiter.api.Test;
import com.big.utils.KarateExtentReport;
import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;


public class KarateRunner {
	
	@Test
	public void executeTest() {
	Builder aRunner = new Builder();
	aRunner.path("classpath:com/big/features/APIfeatures");
	String tags = "@Regression,@Smoke";
	Results result = aRunner.tags(tags).parallel(0);
	KarateExtentReport extentReport = new KarateExtentReport()
			.karateResults(result)
			.reportName("API Automation Report");
	extentReport.generateReport();

	}

}
