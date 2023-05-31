package org.mikelalvarezgo.observer.shared.domain.model.message

import org.mikelalvarezgo.observer.shared.domain.model.Id

import java.util.UUID

case class MessageId(value: UUID) extends Id(value)
