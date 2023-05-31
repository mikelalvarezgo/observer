package org.mikelalvarezgo.observer.shared.domain.model.message

case class Message(
									id: MessageId,
									source: Source,
									content: String
									)
