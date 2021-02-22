package com.github.epoddubny.zeebeteamworkshop.service;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.DeploymentEvent;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ZeebeService {
    private ZeebeClient zeebeClient;

    public DeploymentEvent deployProcess(String processId) {
        return zeebeClient.newDeployCommand()
                .addResourceFromClasspath("bpmn/" + processId + ".bpmn")
                .send()
                .join();
    }

    public WorkflowInstanceEvent startProcess(String processId) {
        return zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(processId)
                .latestVersion()
                .send()
                .join();
    }
}
