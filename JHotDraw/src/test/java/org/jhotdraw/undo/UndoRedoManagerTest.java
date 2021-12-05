/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Mustafa
 */
public class UndoRedoManagerTest extends ScenarioTest<GivenAnEdit, WhenEdit, ThenEdit> {

    private UndoRedoManager undoRedoManager;

    @BeforeClass
    public static void setupClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        undoRedoManager = new UndoRedoManager();
    }

    @After
    public void tearDown() {
        undoRedoManager.end();
    }

    @Test
    public void significantEdits() {
        EditTest et1 = new EditTest(true, false, false);
        undoRedoManager.addEdit(et1);
        assertTrue(!undoRedoManager.hasSignificantEdits());
        assertTrue(!et1.isSignificant());
        
        EditTest et2 = new EditTest(true, true, true);
        undoRedoManager.addEdit(et2);
        assertTrue(undoRedoManager.hasSignificantEdits());
        assertTrue(et2.isSignificant());
    }

    @Test
    public void undoAction() {
        assertTrue(!undoRedoManager.getUndoAction().isEnabled());
        
        EditTest edit = new EditTest(true, false, true);
        undoRedoManager.addEdit(edit);
        assertTrue(undoRedoManager.getUndoAction().isEnabled());
        assertEquals(edit.getUndoPresentationName(), undoRedoManager.getUndoPresentationName());

    }
    
}
