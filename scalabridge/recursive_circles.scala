import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._


def recursive_circles(count:Int, size:Int): Image = {
  count match {
    case 0 => Image.empty
    case n => circle(size) on recursive_circles(n - 1, size - 3)
  }
}

def colored_circles(count:Int, size:Int, color:Color): Image = {
  count match {
    case 0 => Image.empty
    case n => circle(size).lineColor(color) on colored_circles(n - 1, size - 3, color.spin(30.degrees))
  }
}