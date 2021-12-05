package org.jhotdraw.draw.action.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;

// @author: sebni19@student.sdu.dk
/*
Test class with jGiven, asserting if the sample text created in WhenCreatingText-class it not null.
*/

public class ThenTextIsCreated extends Stage<ThenTextIsCreated> {
    @ExpectedScenarioState
    protected SVGTextFigure svgTextFigure;

    public ThenTextIsCreated sampleTextShouldHaveBeenCreated() {
        Assert.assertNotNull(svgTextFigure.getText());
        return self();
    }
}
