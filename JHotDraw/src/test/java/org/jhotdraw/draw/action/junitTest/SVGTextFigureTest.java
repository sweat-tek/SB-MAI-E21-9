package org.jhotdraw.draw.action.junitTest;

import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.jhotdraw.samples.svg.figures.SVGTransformFigure;
import java.awt.geom.AffineTransform;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// @author: sebni19@student.sdu.dk
/*
Test class with jUnit, testing the transform-method from the class SVGTransformFigure from the refactoring.
*/


public class SVGTextFigureTest {

    private SVGTextFigure svgTextFigure;
    private SVGTransformFigure svgTransformFigure;
    private AffineTransform tx;

    @Before
    public void testSetup() {
        svgTextFigure = new SVGTextFigure();
        tx = new AffineTransform();
        svgTransformFigure = new SVGTransformFigure(svgTextFigure, tx);
    }

    @Test
    public void testTransformMethod() {
        AffineTransform key = svgTextFigure.getAttribute(SVGAttributeKeys.TRANSFORM);

        Assert.assertNull(key);
        svgTransformFigure.transform();

        key = svgTextFigure.getAttribute(SVGAttributeKeys.TRANSFORM);
        Assert.assertNotNull(key);
    }
}
