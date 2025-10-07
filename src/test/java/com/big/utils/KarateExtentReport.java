package com.big.utils;

import java.util.List;
import java.util.stream.Stream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.gherkin.model.But;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.gherkin.model.Then;
import com.aventstack.extentreports.gherkin.model.When;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.intuit.karate.Results;
import com.intuit.karate.core.Result;
import com.intuit.karate.core.ScenarioResult;
import com.intuit.karate.core.Step;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KarateExtentReport {
	
	private ExtentReports extentReport;
	private ExtentSparkReporter extentSparkReport;
	private String repDir;
	private String reportName;
	private Results testResult;
	private ExtentTest featureNode;
	private String featuerTitle = "";
	private ExtentTest scenarioNode;
	private String scenarioTitle = "";
	
	public KarateExtentReport(){
		extentReport = new ExtentReports();
	}
	
	public KarateExtentReport reportDir() {
		String path = System.getProperty("user.dir");
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH-mm-ss");
        String formattedDateTime = now.format(formatter);
        path = path+"\\Results\\Report"+" "+formattedDateTime;
        File file = new File(path);
        file.mkdir();
		this.repDir = path;
		return this;
	}
	
	public KarateExtentReport karateResults(Results testRes) {
		this.testResult = testRes;
		return this;
	}
	
	public KarateExtentReport reportName(String repName) {
		this.reportName = repName;
		return this;
	}
	
	public void generateReport() {
		reportDir();
		if(this.repDir!=null && !this.repDir.isEmpty() && this.testResult!=null) {
			extentSparkReport = new ExtentSparkReporter(repDir);
			extentReport.attachReporter(extentSparkReport);
			setConfig();
			Stream<ScenarioResult> scenarioResults = getScenarioResult();
			scenarioResults.forEach((scenarioResult)->{
				String featureName = getFeatureName(scenarioResult);
				String featureDescription = getFeatureDescription(scenarioResult);
				ExtentTest featureNode = createFeatureNode(featureName, featureDescription);
				String scenarioTitle = getScenariotitle(scenarioResult);
				ExtentTest scenarioNode = createScenarioNode(featureNode, scenarioTitle);
				scenarioResult.getStepResults().forEach((step)->{
					addStepNode(scenarioNode, step.getStep(), step.getResult());
				});
			});
			extentReport.flush();
			return;
		}
		
		throw new RuntimeException("Missing Karate Results / Report directory location");
		
	}
	
	@SuppressWarnings("unchecked")
	private Stream<ScenarioResult> getScenarioResult(){
		return this.testResult.getScenarioResults();
	}
	
	private String getFeatureName(ScenarioResult scenarioResult) {
		return scenarioResult.getScenario().getFeature().getName();
	}
	
	private String getFeatureDescription(ScenarioResult scenarioResult) {
		return scenarioResult.getScenario().getFeature().getDescription();
	}
	
	private ExtentTest createFeatureNode(String featureName, String featureDescription) {
		
		if(this.featuerTitle.equalsIgnoreCase(featureName)) {
			return featureNode;
		}
		this.featuerTitle=featureName;
		featureNode=extentReport.createTest(Feature.class, featureName, featureDescription);
		return featureNode;
	}
	
	
	private ExtentTest createScenarioNode(ExtentTest featureNode, String scenarioTitle) {
		
		if(this.scenarioTitle.equalsIgnoreCase(scenarioTitle)) {
			return scenarioNode;
		}
		this.scenarioTitle=scenarioTitle;
		scenarioNode=featureNode.createNode(Scenario.class, scenarioTitle);
		return scenarioNode;
	}
	
	private String getScenariotitle(ScenarioResult scenarioResult) {
		return scenarioResult.getScenario().getName();
	}
	
	private void addStepNode(ExtentTest scenarioNode, Step step, Result stepResult) {
		
		String type = step.getPrefix();
		String stepTitle = step.getText();
		String status = stepResult.getStatus();
		Throwable error = stepResult.getError();
		ExtentTest stepNode;
		switch(type){
			case "Given":
				stepNode = scenarioNode.createNode(Given.class, stepTitle);
				addStepStatus(stepNode, status, error);
				break;
			case "When":
				stepNode = scenarioNode.createNode(When.class, stepTitle);
				addStepStatus(stepNode, status, error);
				break;
			case "Then":
				stepNode = scenarioNode.createNode(Then.class, stepTitle);
				addStepStatus(stepNode, status, error);
				break;
			case "And":
				stepNode = scenarioNode.createNode(And.class, stepTitle);
				addStepStatus(stepNode, status, error);
				break;
			case "But":
				stepNode = scenarioNode.createNode(But.class, stepTitle);
				addStepStatus(stepNode, status, error);
				break;
			default:
				stepNode = scenarioNode.createNode(type+ ""+ stepTitle);
		}
		
	}
	
	private void addStepStatus(ExtentTest stepNode, String status, Throwable error ) {
		switch(status) {
			case "passed":
				stepNode.pass("");
				break;
			case "failed":
				stepNode.fail(error);
				break;
			default:
				stepNode.skip("");
				break;
		}
	}
	
	private void setConfig() {
		extentSparkReport.config().enableOfflineMode(true);
		extentSparkReport.config().setDocumentTitle(reportName);
		extentSparkReport.config().setTimelineEnabled(true);
		extentSparkReport.config().setTheme(Theme.DARK);
		
	}
}
