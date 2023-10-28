package io.github.pjfanning.fury

sealed trait Point

case class Point2D(x: Double, y: Double) extends Point

case class Point3D(x: Double, y: Double, z: Double) extends Point

case class Line(a: Point, b: Point)
