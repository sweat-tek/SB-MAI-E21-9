/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
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
        return this;
    }

    GivenAnEdit no_edits() {
        undoRedoManager = new UndoRedoManager();
        assertTrue(!undoRedoManager.canUndo());
        assertTrue(!undoRedoManager.canUndoOrRedo());
        return this;

    }
}
