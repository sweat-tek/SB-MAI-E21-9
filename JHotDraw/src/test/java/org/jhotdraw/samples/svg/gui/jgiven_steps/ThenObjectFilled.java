package org.jhotdraw.samples.svg.gui.jgiven_steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;

import static org.junit.Assert.assertEquals;

public class ThenObjectFilled extends Stage<ThenObjectFilled> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    public ThenObjectFilled the_object_is_filled_with_a_default_color() {

        // the object was selected and thus filled with a default color (white)
        assertEquals(editor.getActiveView().getSelectionCount(), 1);
        
        // todo: assert that object has color white

        return self();
    }
}
