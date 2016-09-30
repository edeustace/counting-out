package com.ee.countingOut

import scala.collection.TraversableLike
import scala.collection.generic.CanBuildFrom


private[countingOut] object Implicits {

  implicit class TraversableRotation[A, Repr <: TraversableLike[A, Repr]](xs: TraversableLike[A, Repr]) {

    def rotate(i: Int)(implicit cbf: CanBuildFrom[Repr, A, Repr]): Repr = {
      val size = xs.size
      val (first, last) = xs.splitAt(i % size)
      last ++ first
    }
  }
}

