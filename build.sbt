
val scala3Version = "3.1.3"

lazy val root = project
	.in(file("."))
	.settings(
		ObserverConfiguration.commonSettings,
	) aggregate(fetcher, analyzer, shared)

lazy val fetcher = project
	.in(file("fetcher"))
	.settings(
		name := "fetcher",
		ObserverConfiguration.commonSettings,
		libraryDependencies ++= Dependencies.common
	)

lazy val analyzer = project
	.in(file("analyzer"))
	.settings(
		name := "analyzer",
		ObserverConfiguration.commonSettings,
		libraryDependencies ++= Dependencies.common
	)

lazy val shared = project
	.in(file("shared"))
	.settings(
		name := "shared",
		ObserverConfiguration.commonSettings,
		libraryDependencies ++= Dependencies.common
	)
