package io.hashimati.mqtt;



import io.hashimati.domains.Fruit;
import io.micronaut.mqtt.annotation.Topic;
import io.micronaut.mqtt.v5.annotation.MqttPublisher;
import io.micrometer.core.annotation.Timed;
import io.micronaut.messaging.annotation.MessageBody;
import io.micronaut.scheduling.annotation.Async;

@MqttPublisher
public interface FruitMqttClient {

    @Timed(value = "io.hashimati.mqtt.FruitMqttClient.send", percentiles = { 0.5, 0.95, 0.99 }, description = "Observing all Client metric for send a Fruit object")
    @Topic("fruit")
    @Async
    void sendOrder(Fruit message);
}

