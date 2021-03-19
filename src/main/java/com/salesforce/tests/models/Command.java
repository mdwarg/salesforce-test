package com.salesforce.tests.models;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private String name;
    private List<String> options;
    private List<String> parameters;

    public Command(String name, List<String> options, List<String> parameters) {
        super();
        this.name = name;
        this.options = options;
        this.parameters = parameters;
    }

    public Command(String name) {
        super();
        this.name = name;
        this.options = new ArrayList<String>();
        this.parameters = new ArrayList<String>();
    }
    
    public Command() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Command [name=" + name + ", options=" + options + ", parameters=" + parameters + "]";
    }

}
