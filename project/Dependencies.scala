import sbt.*

object Dependencies {

  object Version {

    val cats             = "2.9.0"
    val kamon            = "2.6.0"
    val kanela           = "1.0.17"
    val scalatest        = "3.3.0-SNAP4"
    val circe            = "0.14.5"
  }

  object Production {
    val cats                = "org.typelevel"              %% "cats-core"               % Version.cats
    val circeCore           = "io.circe"                   %% "circe-core"              % Version.circe
    val circeGeneric        = "io.circe"                   %% "circe-generic"           % Version.circe
    val circeParser         = "io.circe"                   %% "circe-parser"            % Version.circe
	}

  object Testing {
    val scalatest       = "org.scalatest"       %% "scalatest"              % Version.scalatest % Test
  }

  val common: Seq[ModuleID] = Seq(
    Production.cats,
    Production.circeCore,
    Production.circeGeneric,
    Production.circeParser,
    Testing.scalatest,
  )
}
