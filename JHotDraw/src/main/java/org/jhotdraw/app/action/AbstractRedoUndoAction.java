/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.beans.*;
import java.util.*;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;

/**
 *
 * @author Mustafa
 */
public abstract class  AbstractRedoUndoAction extends AbstractViewAction {
    public static String ID;
    
    
    private PropertyChangeListener redoActionPropertyListener = new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name == AbstractAction.NAME) {
                putValue(AbstractAction.NAME, evt.getNewValue());
            } else if (name == "enabled") {
                updateEnabledState();
            }
        }
    };
    
    /** Creates a new instance. */
    public AbstractRedoUndoAction(Application app) {
        super(app);   
    }
    
    protected void updateEnabledState() {
        boolean isEnabled = false;
        Action realAction = getRealAction();
        if (realAction != null) {
            isEnabled = realAction.isEnabled();
        }
        setEnabled(isEnabled);
    }
    
    @Override protected void updateView(View oldValue, View newValue) {
        super.updateView(oldValue, newValue);
        if (newValue != null && newValue.getAction(ID) !=  null) {
            putValue(AbstractAction.NAME, newValue.getAction(ID).
                    getValue(AbstractAction.NAME));
            updateEnabledState();
        }
    }
    /**
     * Installs listeners on the view object.
     */
    @Override protected void installViewListeners(View p) {
        super.installViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).addPropertyChangeListener(redoActionPropertyListener);
        }
    }
    /**
     * Installs listeners on the view object.
     */
    @Override protected void uninstallViewListeners(View p) {
        super.uninstallViewListeners(p);
        if (p.getAction(ID) != null) {
        p.getAction(ID).removePropertyChangeListener(redoActionPropertyListener);
        }
    }

    @FeatureEntryPoint(JHotDrawFeatures.UNDO_REDO)
    public void actionPerformed(ActionEvent e) {
        Action realAction = getRealAction();
        if (realAction != null) {
            realAction.actionPerformed(e);
        }
    }
    
    public abstract Action getRealAction();
    
    
}
        
