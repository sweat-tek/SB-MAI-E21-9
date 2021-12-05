package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.action.SelectAllAction;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.gui.FillToolBar;

import javax.swing.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhenObjectSelected extends Stage<WhenObjectSelected> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private Set<Figure> selectedFiguresOnView;

    private SelectAllAction selectAction;

    @ProvidedScenarioState
    private FillToolBar bar;

    @ProvidedScenarioState
    private JComponent disclosedComponent;

    @ProvidedScenarioState
    private Figure f1;

    @BeforeStage
    private void before() {
        selectAction = new SelectAllAction();
        bar = new FillToolBar();

        selectedFiguresOnView = new HashSet<>(editor.getActiveView().getSelectedFigures());
    }

    public WhenObjectSelected an_object_is_selected() {
        // checks that figure was selected
        assertTrue(editor.getActiveView().isFigureSelected(f1));

        // this should now be the case:
        // disclosedComponent = bar.createDisclosedComponent(2);

        // check that the fill palette tool is open
        // if it is open --> then default paint color is white
        assertEquals(3, disclosedComponent.getComponentCount());

        return self();
    }
}
