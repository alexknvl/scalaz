package scalaz
package nct

trait CategoryClass[Obj[_], Arr[_, _]] {
  def id[A: Obj]: A Arr A
  def compose[A: Obj, B: Obj, C: Obj](bc: B Arr C, ab: A Arr B): A Arr C
}

trait CategoryInstances {

}