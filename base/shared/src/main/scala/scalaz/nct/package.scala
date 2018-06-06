package scalaz
package nct

object `package` {
  type Category[Obj[_], Arr[_, _]] = InstanceOf[CategoryClass[Obj, Arr]]
}