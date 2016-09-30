package com.ee.countingOut

case class ScenarioException(msg:String) extends RuntimeException(msg)

import Implicits._

object Scenario {

  val MAX_SIZE = 100000

  def invalidCircleSize(s:Int) =
    ScenarioException(s"Invalid circle size ($s) must be 1 or more.")


  def invalidStepSize(s:Int) =
    ScenarioException(s"Invalid step size ($s) must be 1 or more")


  def lastPositionLeft(size: Int, step: Int): Either[ScenarioException, Int] = {

    @scala.annotation.tailrec
    def rotateAndPrune(l:Seq[Int]) : Either[ScenarioException,Int] = {
      l match {
        case Nil => Left(ScenarioException("Empty list - this should never happen"))
        case Seq(n) => Right(n)
        case _ => {
          val updated = l.rotate(step -1).drop(1)
          rotateAndPrune(updated)
        }
      }
    }

    (size,step) match {
      case (size, _) if size <= 0 || size > MAX_SIZE => Left(invalidCircleSize(size))
      case (_, step) if step <= 0 || step > MAX_SIZE => Left(invalidStepSize(step))
      case (1, _) => Right(1)
      case (size, step) => {
        val circle = (1 to size)
        rotateAndPrune(circle)
      }
    }
  }
}
