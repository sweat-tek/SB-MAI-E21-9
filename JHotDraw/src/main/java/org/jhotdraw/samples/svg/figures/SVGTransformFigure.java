package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.samples.svg.Gradient;
import java.awt.geom.AffineTransform;
import static org.jhotdraw.draw.AttributeKeys.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

// @author: sebni19@student.sdu.dk
/*
This class is used to transform a figure. The transform method is used in a couple SVG classes under the figures-
package, also in classes that doesn't have a connection to the text tool. Some of these classes has been refactored too.
*/


public class SVGTransformFigure {

    private AffineTransform tx;
    private SVGAttributedFigure figure;


    public SVGTransformFigure(SVGAttributedFigure figure, AffineTransform tx) {
        this.figure = figure;
        this.tx = tx;
    }

    public void transform() {
        if (TRANSFORM.get(figure) == null) {
            TRANSFORM.basicSet(figure, (AffineTransform) tx.clone());
        } else {
            AffineTransform t = TRANSFORM.getClone(figure);
            t.preConcatenate(tx);
            TRANSFORM.basicSet(figure, t);
        }
    }

    public void fillGradient() {
        if (FILL_GRADIENT.get(figure) != null &&
                !FILL_GRADIENT.get(figure).isRelativeToFigureBounds()) {
            Gradient g = FILL_GRADIENT.getClone(figure);
            g.transform(tx);
            FILL_GRADIENT.basicSet(figure, g);
        }
    }

    public void strokeGradient() {
        if (STROKE_GRADIENT.get(figure) != null &&
                !STROKE_GRADIENT.get(figure).isRelativeToFigureBounds()) {
            Gradient g = STROKE_GRADIENT.getClone(figure);
            g.transform(tx);
            STROKE_GRADIENT.basicSet(figure, g);
        }
    }
}
