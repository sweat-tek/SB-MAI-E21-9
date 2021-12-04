/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Mustafa
 */
public class WhenEdit extends Stage<WhenEdit> {
    @ProvidedScenarioState
    @ExpectedScenarioState
    private UndoRedoManager undoRedoManager;
    
    @ProvidedScenarioState
    @ExpectedScenarioState
    private EditTest edit;

    WhenEdit an_undoable_edit_has_been_made() {

        edit = new EditTest(true, false, true);
        undoRedoManager.addEdit(edit);

        assertTrue(undoRedoManager.canUndo());
        assertTrue(undoRedoManager.canUndoOrRedo());

        return this;
    }

    WhenEdit the_insignificant_edit_has_been_made() {
        EditTest edit1 = new EditTest(true, false, false);
        undoRedoManager.addEdit(edit1);

        return this;
    }

    WhenEdit discarding_all_edits() {
        undoRedoManager.discardAllEdits();
        return this;
    }

}
