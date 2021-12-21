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
import org.jhotdraw.draw.DrawingView;
import static org.mockito.Mockito.mock;


/**
 *
 * @author Samuel
 */
public class WhenSetScale extends Stage<WhenSetScale>{
    
    @ExpectedScenarioState
    private static DrawingView view;

    
    @BeforeStage
    public void before() {
        view = mock(DrawingView.class);
    }
    
    
    public WhenSetScale getScaleFactor() {
        view.getScaleFactor();
        return this;
    }
    
    public WhenSetScale getComponent() {
        view.getComponent();
        return this;
    }
    
}
