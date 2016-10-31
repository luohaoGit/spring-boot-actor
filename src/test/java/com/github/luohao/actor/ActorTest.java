package com.github.luohao.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by luohao on 2016/10/31.
 */
public class ActorTest {

    ActorSystem actorSystem;

    @Before
    public void before(){
        actorSystem = ActorSystem.create();
    }

    @Test
    public void test(){
        ActorRef angryFoal = actorSystem.actorOf(Props.create(AngryFoalActor.class));
        ActorRef lazyFoal = actorSystem.actorOf(Props.create(LazyFoalActor.class));
        angryFoal.tell("hello! I am  LazyFoalActor!", lazyFoal);
    }

    @After
    public void after(){
        actorSystem.shutdown();
    }

}
