package de.blogspot.wrongtracks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class StoreDataDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		execution.setVariable("data", new MyDataHolder("Hello there!"));
	}

}
