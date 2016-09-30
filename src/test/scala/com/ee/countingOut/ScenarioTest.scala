package com.ee.countingOut

import org.specs2.mutable.Specification

class ScenarioTest extends Specification {


  "lastPositionLeft" should {

    def assertError(size:Int,step:Int, expected:ScenarioException) = {
      assertScenario(size, step, Left(expected))
    }

    def assertResult(size:Int,step:Int, expected:Int) = {
      assertScenario(size, step, Right(expected))
    }

    def assertScenario(size:Int,step:Int, expected:Either[ScenarioException,Int]) = {

      val label : String = expected match {
        case Left(e) => "error"
        case Right(n) => n.toString
      }

      s"return $label if circle size is: $size and step is: $step" in {
        Scenario.lastPositionLeft(size,step) must_== expected
      }
    }


    assertError(0, 1, Scenario.invalidCircleSize(0))
    assertError(1, 0, Scenario.invalidStepSize(0))
    assertResult(1, 100, 1)
    assertResult(2, 1, 2)
    assertResult(3, 1, 3)
    assertResult(3, 2, 3)
    assertResult(4,2,1)
    assertResult(4,3,1)
    assertResult(4,4,2)
    assertResult(4,5,2)
    assertResult(4,6,3)
    assertResult(10,3,4)
    assertResult(1000,2,977)
    assertResult(10000,2,3617)
    assertResult(100000,400,1924)
    assertError(100001,400,Scenario.invalidCircleSize(100001))
    assertError(1,100001,Scenario.invalidStepSize(100001))
  }
}
