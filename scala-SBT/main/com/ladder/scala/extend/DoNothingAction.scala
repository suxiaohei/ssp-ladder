package scala.extend

object DoNothingAction extends UndoableAction("Do nothing") {

  override def undo() {}

  override def redo() {}

}