package com.github.epoddubny.zeebeteamworkshop.web;

import com.github.epoddubny.zeebeteamworkshop.service.ZeebeService;
import com.github.epoddubny.zeebeteamworkshop.web.dto.ProcessRequest;
import io.zeebe.client.api.response.DeploymentEvent;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zeebe")
@AllArgsConstructor
public class ZeebeController {
    private ZeebeService zeebeService;

    @PostMapping(value = "/deploy-process")
    public DeploymentEvent deployProcess(@RequestBody ProcessRequest request) {
        return zeebeService.deployProcess(request.getProcessId());
    }

    @PostMapping(value = "/start-process")
    public WorkflowInstanceEvent startProcess(@RequestBody ProcessRequest request) {
        return zeebeService.startProcess(request.getProcessId());
    }
}
