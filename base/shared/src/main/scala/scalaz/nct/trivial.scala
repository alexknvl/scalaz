package scalaz
package nct

sealed trait Trivial[A]
object Trivial {
  implicit val instance: Trivial[A] = new Trivial[A] { }
}