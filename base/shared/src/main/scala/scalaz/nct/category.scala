package scalaz
package nct

trait CategoryClass[Obj[_], Arr[_, _]] {
  def id[A: Obj]: A Arr A
  def compose[A: Obj, B: Obj, C: Obj](bc: B Arr C, ab: A Arr B): A Arr C
}

trait CategoryInstances {
  implicit val function1Category: Category[Trivial, Function1] =
    instanceof(new CategoryClass[Trivial, Function1] {
      def id[A: Trivial]: A => A = a => a

      def compose[A: Trivial, B: Trivial, C: Trivial]
      (bc: B => C, ab: A => B): A => C =
        bc compose ab
    })
}