package models

import play.api.data.Form
import play.api.data.Forms._


case class KafkaForm(topic: String, message: String)


object KafkaForm {
  val form: Form[KafkaForm] = Form(
    mapping(
      "topic" -> text,
      "message" -> text
    )(KafkaForm.apply)(KafkaForm.unapply)
  )
}