/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.JComponent;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.gui.ViewToolBar;

/**
 *
 * @author Samuel
 */
public class GivenView  extends Stage<GivenView>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private ViewToolBar viewToolBar;
    
    @BeforeStage
    public void before() {
        
    }
    
    public GivenView aView(){
        ViewToolBar viewToolBar = new ViewToolBar();
        DefaultDrawingView view = new DefaultDrawingView();
        return this;
    }
    
    
    
}
