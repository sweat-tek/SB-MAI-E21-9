/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.jgivenTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import javax.swing.AbstractButton;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.ZoomAction;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Samuel
 */
public abstract class ThenZoomIsPossible extends Stage<ThenZoomIsPossible>{
    
    @ExpectedScenarioState
    private ZoomAction instance;

    
    public ThenZoomIsPossible zoomingIsEnable(){
        instance = new ZoomAction(mock(DrawingView.class), 1 , mock(AbstractButton.class));
        assertTrue(instance.isEnabled());
       
        return self();
    }
    
}
