package com.mygodoc.app.listener;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class TestStatus {
    @JsonProperty("testClass")
    private String testClass;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

    @JsonProperty("executionTime")
    private String executionTime;
}
