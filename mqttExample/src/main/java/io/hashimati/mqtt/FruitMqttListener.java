package io.hashimati.mqtt;


import io.hashimati.domains.Fruit;
import io.hashimati.services.FruitService;
import io.micronaut.mqtt.annotation.MqttSubscriber;
import io.micronaut.mqtt.annotation.Topic;
import io.micrometer.core.annotation.Timed;
import jakarta.inject.Inject;

@MqttSubscriber
public class FruitMqttListener {


    @Inject
    private FruitService fruitService;
    @Timed(value = "io.hashimati.mqtt.FruitMqttListener.receive", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all Consumer metric for receive a Fruit object")
    @Topic("fruit")
    public void receive(Fruit message)
    {

        System.out.println("Received " + message);
        fruitService.save(message);
    }
}

