
package com.big.TestRunners;

import java.util.ArrayList;
import java.util.List;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.testng.TestNG;

import com.big.utils.Utilities;

public class TestRunner {

	public static void main(String[] args) {
	
		try {
			Utilities util = new Utilities();
			String mode = util.getProeprty("Execution-Type");
			TestNG testNG = new TestNG();
			if(mode.equalsIgnoreCase("Cucumber")) {
				
				testNG.setTestClasses(new Class[] {CucumberRunner.class});
		 		testNG.run();
				
			}
			else if (mode.equalsIgnoreCase("TestNg")) {
				util.builTestNgXML();
				
				  List<String> suites = new ArrayList<String>();
				  suites.add(""+System.getProperty("user.dir")+"\\testng.xml");
				  testNG.setTestSuites(suites); 
				  testNG.run();
				 	 
			}
			else if (mode.equalsIgnoreCase("Karate")) {
				/*
				 * JUnitCore junit = new JUnitCore(); junit.run(KarateRunner.class);
				 */
			 	   LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
			                .selectors(DiscoverySelectors.selectClass(KarateRunner.class))
			                .build();
			       Launcher launcher = LauncherFactory.create();
			       launcher.execute(request);

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
