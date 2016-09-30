package com.ee.countingOut

import scala.util.Try

object Main {

  def maybeInt(s: String) = Try(s.toInt).toOption

  val defaultError = "[Error] You must provide 2 Ints. eg: \"run 1 1\""

  def main(args: Array[String]) {
    args match {
      case a if args.length != 2 => println(defaultError)
      case Array(n, k) => {
        val size = maybeInt(n)
        val step = maybeInt(k)

        if (size.isEmpty || step.isEmpty) {
          println(defaultError)
        } else {
          Scenario.lastPositionLeft(n.toInt, k.toInt) match {
            case Left(ScenarioException(msg)) => println(s"There was an error: ${msg}")
            case Right(n) => println(n)
          }
        }
      }
    }
  }
}
