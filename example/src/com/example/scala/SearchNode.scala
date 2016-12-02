package com.example.scala

import scala.annotation.tailrec


case class Node(name: String, edges: List[Node] = Nil)

/**
  * Created by suxin on 16-12-1.
  */
class SearchNode {

  def search(start: Node, p: Node => Boolean) = {
    @tailrec
    def loop(nodeQueue: List[Node], visited: Set[Node]): Option[Node] =
      nodeQueue match {
        case head :: tail if p(head) => Some(head)
        case head :: tail if !visited.contains(head) =>
          loop(tail ++ head.edges, visited + head)
        case head :: tail =>
          loop(tail, visited)
        case Nil =>
          None
      }
    loop(List(start), Set())
  }

}
