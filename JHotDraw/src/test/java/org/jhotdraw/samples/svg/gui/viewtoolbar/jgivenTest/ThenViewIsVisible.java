/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JComponent;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.gui.ViewToolBar;
import org.junit.Assert;

/**
 *
 * @author Samuel
 */
public abstract class ThenViewIsVisible extends Stage<ThenViewIsVisible>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private ViewToolBar viewToolBar;
    
    abstract boolean hasView(JComponent disclosedComponent);
    
    public ThenViewIsVisible viewIsVisible(){
        
        ViewToolBar viewToolBar = new ViewToolBar();
        DefaultDrawingView view = new DefaultDrawingView();
        viewToolBar.setView(view);
        
        boolean hasView = true;
        Assert.assertTrue(hasView);
       
        return this;
    }
    
}
