/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Mustafa
 */
public class GivenAnEdit extends Stage<GivenAnEdit> {

    @ProvidedScenarioState
    private UndoRedoManager undoRedoManager;

    @ProvidedScenarioState
    private EditTest edit;

    GivenAnEdit an_undoable_edit() {
        undoRedoManager = new UndoRedoManager();
        edit = new EditTest(true, false, true);
        undoRedoManager.addEdit(edit);
        return self();
    }

    GivenAnEdit no_edits() {
        undoRedoManager = new UndoRedoManager();
        assertTrue(!undoRedoManager.canUndo());
        assertTrue(!undoRedoManager.canUndoOrRedo());
        return self();

    }
}
