import sbt.{Def, *}
import sbt.Keys.*

object ObserverConfiguration {

	val commonSettings: Seq[Def.Setting[? >: Option[Resolver] & Task[PublishConfiguration] & Task[Seq[String]] & String & Boolean & Task[Seq[File]]]] = Seq(
		organization := "com.mikelalvarezgo",
		version := "1.0.0",
		scalaVersion := "3.1.3",
		Compile / doc / sources := Seq.empty,
		Compile / packageDoc / publishArtifact := false,
		scalacOptions := {
			val default = Seq(
				"-Xfatal-warnings",
				"-Ywarn-unused",
				"-Ywarn-value-discard",
				"-language:higherKinds",
				"-language:implicitConversions",
				"-Wconf:cat=deprecation:w",
				"-Wconf:cat=lint:w,cat=lint-byname-implicit:w",
				"-Wconf:cat=feature:i",
				"-Wconf:cat=unchecked:w",
				"-Wconf:cat=unused:w",
				"-Wconf:cat=w-flag-dead-code:w,cat=w-flag-value-discard:w"
			)
			if (version.value.endsWith("SNAPSHOT")) default :+ "-Xcheckinit" else default
			// check against early initialization
		},
		javaOptions := Seq(
			"-Duser.timezone=UTC",
			"-Xmx2048M",
			"-Xss2M",
			"--add-opens",                               // https://github.com/kamon-io/Kamon/issues/641
			"java.base/java.util.concurrent=ALL-UNNAMED" // https://github.com/kamon-io/Kamon/issues/641
		),
		run / fork := true,
		Test / fork := true,
		Test / parallelExecution := false,
		// Cache
		pushRemoteCacheTo := Some(MavenCache("compile-local-cache", file(sys.env("HOME") + "/.sbt/letgo-cache/"))),
		Compile / pushRemoteCacheConfiguration ~= (_.withOverwrite(true)),
		Test / pushRemoteCacheConfiguration ~= (_.withOverwrite(true))
	)
}
