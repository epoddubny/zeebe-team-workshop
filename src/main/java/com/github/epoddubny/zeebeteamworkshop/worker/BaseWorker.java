package com.github.epoddubny.zeebeteamworkshop.worker;

import io.zeebe.client.api.response.ActivatedJob;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class BaseWorker {

    protected void logJob(final ActivatedJob job) {
        log.info(
                "\nComplete job\ntype: {},\nkey: {},\nelement: {},\nworkflow instance: {}\ndeadline; {}\nheaders: {}\nvariables: {}",
                job.getType(),
                job.getKey(),
                job.getElementId(),
                job.getWorkflowInstanceKey(),
                Instant.ofEpochMilli(job.getDeadline()),
                job.getCustomHeaders(),
                job.getVariables());
    }
}
