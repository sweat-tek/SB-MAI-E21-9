package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;

public class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private DefaultDrawingView view;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing()); // test
        editor.setActiveView(view);
    }

    public GivenSomeState an_object_is_selected() {
        Figure f1 = new BezierFigure();

        editor.getActiveView().getDrawing().add(f1);

        return self(); // return this;
    }
}
