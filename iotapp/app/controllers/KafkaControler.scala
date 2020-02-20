package controllers

import java.util.Properties

import javax.inject.Inject
import javax.inject.Singleton
import models.KafkaForm
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import play.api.mvc._

@Singleton
class KafkaControler @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {
  def forms() = Action {  implicit request: Request[AnyContent] =>
    Ok(views.html.index(KafkaForm.form))
  }
  def simpleForm() = Action { implicit request: Request[AnyContent] =>
    val props = new Properties()
    props.put("bootstrap.servers", "192.168.0.23:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    println(KafkaForm.form.bindFromRequest.get.message)
    val producer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String]("test", "key", KafkaForm.form.bindFromRequest.get.message)
    producer.send(record)
    producer.close()
    Ok(views.html.index(KafkaForm.form))
  }

  def simpleFormPost() = Action { implicit request =>
    val formData: KafkaForm = KafkaForm.form.bindFromRequest.get
    Ok(formData.toString)
  }
}
