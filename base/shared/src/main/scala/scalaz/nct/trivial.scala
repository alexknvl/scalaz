package scalaz
package nct

sealed trait Trivial[A]
object Trivial {
  implicit def instance[A]: Trivial[A] = new Trivial[A] {}
}
