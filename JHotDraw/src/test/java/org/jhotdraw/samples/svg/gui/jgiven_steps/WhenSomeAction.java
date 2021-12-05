package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.gui.FillToolBar;

import javax.swing.*;

public class WhenSomeAction extends Stage<WhenSomeAction> {

    @ProvidedScenarioState
    private boolean fillColorChosen = false;

    @ProvidedScenarioState
    private FillToolBar bar;

    @ProvidedScenarioState
    private JComponent disclosedComponent;

    @BeforeStage
    private void before() {
        bar = new FillToolBar();
    }

    public WhenSomeAction a_color_is_selected() {
        //disclosedComponent = bar.createDisclosedComponent(2);

        // if the fill palette tool is open then default paint color is white
        if (disclosedComponent.getComponentCount() == 3) {
            fillColorChosen = true;
        }

        return self();
    }
}
