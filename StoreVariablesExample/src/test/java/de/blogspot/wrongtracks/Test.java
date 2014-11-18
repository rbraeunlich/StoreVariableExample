package de.blogspot.wrongtracks;

import java.util.Collections;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.camunda.bpm.engine.impl.variable.CustomObjectType;
import org.camunda.bpm.engine.impl.variable.VariableType;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.junit.BeforeClass;

public class Test {

  private static ProcessEngine engine;

  @BeforeClass
  public static void setUpBeforeClass() {
    StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
    configuration.setJdbcUrl("jdbc:h2:mem:camunda;DB_CLOSE_DELAY=-1");
    configuration.setJdbcUsername("sa");
    configuration.setJdbcPassword("sa");
    configuration.setDatabaseSchemaUpdate("create-drop");
    configuration.setCustomPostVariableTypes(Collections.<VariableType> singletonList(new CustomObjectType("name", MyDataHolder.class)));
    engine = configuration.buildProcessEngine();
  }

  @org.junit.Test
  public void storeVariable() {
    DeploymentBuilder deployment = engine.getRepositoryService().createDeployment();
    deployment.addClasspathResource("process.bpmn").name("process").deploy();
    engine.getRuntimeService().startProcessInstanceByKey("Process_1");
  }

}
