/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Mustafa
 */
public class ThenEdit extends Stage<ThenEdit> {

    @ExpectedScenarioState
    private UndoRedoManager undoRedoManager;

    @ExpectedScenarioState
    private EditTest edit;

    ThenEdit the_edit_is_undoable() {
        assertTrue((undoRedoManager.getUndoPresentationName().equals(edit.getUndoPresentationName())));
        return self();
    }

    ThenEdit there_should_be_no_edits() {
        assertTrue(!undoRedoManager.hasSignificantEdits());
        return self();
    }
}
