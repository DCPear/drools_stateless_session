package com.dcpear.main;
/**
 * We have a stateless session here.
 * Initially when counter1 is inserted and rules executed. Later we insert counter2 and execute rules again.
 * In this case the execution of rule "Counter shower 2" changes the value of cnt in working memory.
 * As this is a stateless session each session gets disposed after getting executed.
 * So execution of counter1 and counter2 are independent of each other
 * creating new using overloaded constructor
 * Counter there (1) : 1 and the name is : cnt1
 * Counter there (2) : 1 and the name is : cnt1 accumaulated value is 1
 * Counters there (3) :
 * Counter there (1) : 2 and the name is : cnt2
 * Counter there (2) : 2 and the name is : cnt2 accumaulated value is 1
 * Counters there (3) :
 *
 */

import com.dcpear.model.Counter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();

//get stateless session
			StatelessKieSession kSession = kContainer.newStatelessKieSession();


			Counter counter1 = new Counter(1,"cnt1");
			Counter counter2 = new Counter(2,"cnt2");

			//execute with counter1
			kSession.execute(counter1);

			//execute with counter2
			kSession.execute(counter2);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}


}
