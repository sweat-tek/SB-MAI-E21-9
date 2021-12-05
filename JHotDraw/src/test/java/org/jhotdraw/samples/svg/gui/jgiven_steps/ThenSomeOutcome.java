package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import static org.junit.Assert.assertEquals;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    public ThenSomeOutcome the_object_should_be_filled_with_the_color() {

        // the object was selected and thus filled with a default color (white)
        assertEquals(editor.getActiveView().getSelectionCount(), 1);

        return self();
    }
}
