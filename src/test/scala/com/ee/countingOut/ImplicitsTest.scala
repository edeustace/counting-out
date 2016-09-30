package com.ee.countingOut

import org.specs2.mutable._

import com.ee.countingOut.Implicits._

class ImplicitsTest extends Specification {

  "TraversableRotation" should {

    def assertRotate(l:List[Int], step:Int, expected:List[Int]) = {
      s"rotating $l by $step should == $expected" in {
        l.rotate(step) must_== expected
      }
    }

    "rotate" should {
      assertRotate(List(1), 100, List(1))
      assertRotate(List(1,2), 100, List(1,2))
      assertRotate(List(1,2), 101, List(2,1))
      assertRotate(List(1,2,3), 1, List(2,3,1))
      assertRotate(List(1,2,3), 2, List(3,1,2))
      assertRotate(List(1,2,3), 3, List(1,2,3))
      assertRotate(List(1,2,3), 4, List(2,3,1))
    }
  }
}