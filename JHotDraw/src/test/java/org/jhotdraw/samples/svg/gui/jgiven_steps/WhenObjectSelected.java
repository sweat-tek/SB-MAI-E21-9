package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.gui.FillToolBar;

import javax.swing.*;

import static org.junit.Assert.assertNotEquals;

public class WhenObjectSelected extends Stage<WhenObjectSelected> {

    @ExpectedScenarioState
    private DefaultDrawingView view;

    /* // Disabled for now - IDE error
    @ProvidedScenarioState
    private FillToolBar bar;

    @ProvidedScenarioState
    private JComponent disclosedComponent;

    @BeforeStage
    private void before() {
        bar = new FillToolBar();
    }
    */

    public WhenObjectSelected an_object_is_selected() {
        // select all objects
        view.selectAll();
        
        // checks that objects were selected
        assertNotEquals(0, view.getSelectionCount());

        // this should now be the case:
        //disclosedComponent = bar.createDisclosedComponent(2);

        // check that the fill palette tool is open
        // if it is open --> then default paint color is white
        //assertEquals(3, disclosedComponent.getComponentCount());

        return self();
    }
}
