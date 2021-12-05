package org.jhotdraw.draw.action.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

// @author: sebni19@student.sdu.dk
/*
Test class with jGiven, setting up the scenario.
*/

public class GivenTextToCreate extends Stage<GivenTextToCreate> {
    @ProvidedScenarioState
    protected SVGTextFigure svgTextFigure;

    public GivenTextToCreate missingTextfield() {
        svgTextFigure = new SVGTextFigure();
        return self();
    }

}
