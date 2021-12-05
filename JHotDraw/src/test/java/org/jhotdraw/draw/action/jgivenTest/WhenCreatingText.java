package org.jhotdraw.draw.action.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

// @author: sebni19@student.sdu.dk
/*
Test class with jGiven, creating the text for the test.
*/

public class WhenCreatingText extends Stage<WhenCreatingText> {
    @ExpectedScenarioState
    protected SVGTextFigure svgTextFigure;

    public WhenCreatingText creatingNewText() {
        svgTextFigure.setText("Sample text that will be used for the acceptance test with jGiven");
        return self();
    }
}
