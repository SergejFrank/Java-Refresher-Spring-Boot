package com.example;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import de.otto.refresher.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@TestPropertySource(locations = "classpath:application.properties")
public class TaskControllerTest extends FluentTest {

    @Value("${local.server.port}")
    private int serverPort;

    private WebDriver webDriver = new PhantomJSDriver();

    private String taskCssSelector = "li.task";
    private String todoTaskCssSelector = "li.todo-task";
    private String doneTaskCssSelector = "li.done-task";

    @Before
    public void setUp() {
        goTo(url());
    }

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    public String url() {
        return "http://localhost:" + serverPort + "/";
    }

    @Test
    public void newTasksCanBeAdded() {
        //todo
    }

    @Test
    public void setTaskDone() {
        //todo
    }

    @Test
    public void deleteTasks() {
        //todo
    }

    public void addNewTask(String taskName) {
        //todo
    }

    public ArrayList<String> getTasksByCSSSelector(String cssSelector) {
        FluentList<FluentWebElement> webElementsDone = find(cssSelector);
        ArrayList<String> doneTasks = new ArrayList<>();
        for (FluentWebElement element : webElementsDone) {
            doneTasks.add(element.getText());
        }
        return doneTasks;
    }

    public void clickButtonByTaskName(String taskName) {
        FluentList<FluentWebElement> webElements = find(taskCssSelector);
        for (FluentWebElement element : webElements) {
            if (element.getText().equals(taskName)) {
                element.getElement().findElement(By.cssSelector("button")).click();
                return;
            }
        }
    }
}