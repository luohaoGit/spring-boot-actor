package com.github.luohao.mailbox;

import akka.actor.ActorSystem;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedPriorityMailbox;
import com.github.luohao.beans.Task;
import com.typesafe.config.Config;

/**
 * Simple priority queue mapping the task priority to the mailbox priority.
 */
public class PriorityMailbox extends UnboundedPriorityMailbox {

    public PriorityMailbox(ActorSystem.Settings settings, Config config) {

        // Create a new PriorityGenerator, lower priority means more important
        super(new PriorityGenerator() {
            @Override
            public int gen(Object message) {
                if (message instanceof Task) {
                    return ((Task) message).getPriority();
                } else {
                    // default
                    return 100;
                }
            }
        });

    }
}