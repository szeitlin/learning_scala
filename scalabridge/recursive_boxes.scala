import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._

val aBox = Image.rectangle(20, 20).fillColor(Color.royalBlue)

def boxes(count:Int): Image = {
    count match{
        case 0 => Image.empty
        case n => aBox beside boxes(n-1)
    }
}

def stackedBoxes(count:Int): Image = {
    count match{
        case 0 => Image.empty
        case n => aBox above stackedBoxes(n-1)
        }
     }

def cross(count:Int): Image = {
    val unit = Image.circle(10)
    count match{
        case 0 => unit
        case n => unit beside (unit above cross(n-1) above unit) beside unit

        }
    }

def chessboard(count:Int): Image = {
    val blackbox = Image.rectangle(10,10).fillColor(Color.black)
    val redbox = Image.rectangle(10,10).fillColor(Color.red)
    val unit = (blackbox beside redbox) below (redbox beside blackbox)
    count match{
        case 0 => unit
        case n => (chessboard(n-1) beside chessboard(n-1)) below (chessboard(n-1) beside chessboard(n-1))

        }
    }

def growingBoxes(count:Int): Image = {
    count match{
        case 0 => Image.empty
        case n => growingBoxes(n-1) beside Image.rectangle(n*10, n*10)
    }
}

def growingBoxes2(count:Int, size:Int): Image = {
    count match{
        case 0 => Image.empty
        case n => Image.rectangle(size, size) beside growingBoxes2(n-1, size + 10)
    }
}

def gradientBoxes(count:Int, color:Color): Image = {
    count match{
        case 0 => Image.empty
        case n => Image.rectangle(10,10).fillColor(color) beside gradientBoxes(n-1, color.spin(30.degrees))
    }
}
