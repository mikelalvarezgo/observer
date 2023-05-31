package org.mikelalvarezgo.observer.shared.domain.model.message

enum Source(val name: String):
	case Twitter extends Source("twitter")
	case Telegram extends Source("telegram")