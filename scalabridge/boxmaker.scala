import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DCanvas._
import doodle.backend.StandardInterpreter._

def boxes(color: Color): Image = {
    val box =
    Image.rectangle(40,40).
        lineWidth(5.0).
        lineColor(color.spin(30.degrees)).
        fillColor(color)

    box beside box beside box beside box beside box
}

boxes(Color.paleGoldenrod).draw
boxes(Color.lightSteelBlue).draw
boxes(Color.mistyRose).draw

