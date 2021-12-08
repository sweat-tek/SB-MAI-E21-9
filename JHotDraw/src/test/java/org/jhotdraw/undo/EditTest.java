/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

/**
 *
 * @author Mustafa
 */
public class EditTest implements UndoableEdit {
    
    private boolean canUndo;
    private boolean canRedo;
    private boolean isSignificant;
    
    
    public EditTest( boolean canUndo, boolean canRedo, boolean isSignificant) {
        super();
        this.canUndo = canUndo;
        this.canRedo = canRedo;
        this.isSignificant = isSignificant;
    }
    
    @Override
    public void undo() throws CannotUndoException {}

    @Override
    public boolean canUndo() {
        return this.canUndo;
    }

    @Override
    public void redo() throws CannotRedoException {}

    @Override
    public boolean canRedo() {
        return this.canRedo;
    }

    @Override
    public void die() {}

    @Override
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    @Override
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }

    @Override
    public boolean isSignificant() {
        return this.isSignificant;
    }

    @Override
    public String getPresentationName() {
        return "presentation name";
    }

    @Override
    public String getUndoPresentationName() {
        return "undo presentation name";
    }

    @Override
    public String getRedoPresentationName() {
        return "redo presentation name";
    }   
}

