package kafka.producer

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaProducer {
  def sendMessage(properties: Properties): Boolean = {
    val producer = new KafkaProducer[String, String](properties)
    val record = new ProducerRecord[String, String]("test", "key", "somemessage")
    producer.send(record)
    producer.close()
    true
  }
}
