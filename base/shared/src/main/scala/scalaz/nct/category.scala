package scalaz
package nct

import scalaz.types.Is
import scalaz.types.As
import scala.Function1

trait CategoryClass[Obj[_], Arr[_, _]] {
  def id[A: Obj]: A Arr A
  def compose[A: Obj, B: Obj, C: Obj](bc: B Arr C, ab: A Arr B): A Arr C
}

trait CategoryInstances {
  implicit val function1Category: Category[Trivial, Function1] =
    instanceOf(new CategoryClass[Trivial, Function1] {
      def id[A: Trivial]: A => A = a => a

      def compose[A: Trivial, B: Trivial, C: Trivial](bc: B => C, ab: A => B): A => C =
        bc compose ab
    })

  implicit val equalsCategory: Category[Trivial, ===] =
    instanceOf(new CategoryClass[Trivial, ===] {

      override def id[A: Trivial]: scalaz.===[A, A] = Is[A, A]

      override def compose[A: Trivial, B: Trivial, C: Trivial](bc: scalaz.===[B, C],
                                                               ab: scalaz.===[A, B]): scalaz.===[A, C] = bc compose ab
    })

  implicit val subtypingCategory: Category[Trivial, <~<] =
    instanceOf(new CategoryClass[Trivial, <~<] {
      def id[A: Trivial]: A <~< A = As.refl[A]

      def compose[A: Trivial, B: Trivial, C: Trivial](bc: B <~< C, ab: A <~< B): A <~< C =
        bc compose ab
    })

  implicit val isoCategory: Category[Trivial, Iso] =
    instanceOf(new CategoryClass[Trivial, Iso] {
      def id[A: Trivial]: A Iso A = Iso.id[A]

      def compose[A: Trivial, B: Trivial, C: Trivial](bc: B Iso C, ab: A Iso B): A Iso C =
        bc compose ab
    })
}
