package canvasy

import org.scalajs.dom
import dom.html

import scala.Array._
import scala.collection.mutable.ListBuffer

import elements.CanvasyElement


class Canvasy(val canvas: html.Canvas) {
  private val elements: ListBuffer[CanvasyElement] = new ListBuffer[CanvasyElement]()
  private val context = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]

  def += (added: Array[_ <: CanvasyElement]) = { elements ++= added; this }

  def draw() {
    context.clearRect(0, 0, canvas.width, canvas.height)
    elements.foreach(_.draw(context))

    dom.window.requestAnimationFrame((x: Double) => draw())
  }
}
