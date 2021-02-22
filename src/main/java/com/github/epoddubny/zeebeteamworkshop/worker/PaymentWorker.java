package com.github.epoddubny.zeebeteamworkshop.worker;

import io.zeebe.client.api.response.ActivatedJob;
import io.zeebe.client.api.worker.JobClient;
import io.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.stereotype.Component;

@Component
public class PaymentWorker extends BaseWorker {

    @ZeebeWorker(type = "payment-service")
    public void handleJob(final JobClient client, final ActivatedJob job) {
        logJob(job);
        client.newCompleteCommand(job.getKey()).send().join();
    }
}
