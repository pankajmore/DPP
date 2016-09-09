package calculator

class Signal[T](expr: => T) {

  import Signal._

  private var myExpr: () => T = _
  private var myValue: T = _
  private var observers: Set[Signal[_]] = Set()
  private var observed: List[Signal[_]] = Nil
  update(expr)

  def apply() = {
    observers += caller.value
    assert(!caller.value.observers.contains(this), "cyclic signal definition")
    caller.value.observed ::= this
    myValue
  }

  protected def update(expr: => T): Unit = {
    myExpr = () => expr
    computeValue()
  }

  protected def computeValue(): Unit = {
    for (sig <- observed)
      sig.observers -= this
    observed = Nil
    val newValue = caller.withValue(this)(myExpr())
    /* Disable the following "optimization" for the assignment, because we
     * want to be able to track the actual dependency graph in the tests.
     */
    //if (myValue != newValue) {
    myValue = newValue
    val obs = observers
    observers = Set()
    obs.foreach(_.computeValue())
    //}
  }
}

class Var[T](expr: => T) extends Signal[T](expr) {
  override def update(expr: => T): Unit = super.update(expr)
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}

object NoSignal extends Signal[Nothing](???) {
  override def computeValue() = ()
}

object Signal {
  val caller = new DynamicVariable[Signal[_]](NoSignal)

  def apply[T](expr: => T) = new Signal(expr)
}
