package com.github.epoddubny.zeebeteamworkshop.worker;

import io.zeebe.client.api.response.ActivatedJob;
import io.zeebe.client.api.worker.JobClient;
import io.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class InventoryWorker extends BaseWorker {

    @ZeebeWorker(type = "inventory-service")
    public void handleJob(final JobClient client, final ActivatedJob job) {
        logJob(job);
        client.newCompleteCommand(job.getKey()).send().join();
    }
}
