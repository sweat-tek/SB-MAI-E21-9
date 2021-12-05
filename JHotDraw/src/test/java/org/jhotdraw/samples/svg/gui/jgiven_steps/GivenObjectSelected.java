package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

public class GivenObjectSelected extends Stage<GivenObjectSelected> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private DefaultDrawingView view;

    @BeforeStage
    void before() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing()); // test
        editor.setActiveView(view);
    }

    public GivenObjectSelected an_object_is_selected() {
        Figure f1 = new BezierFigure();

        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);

        return self();
    }
}
