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
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.draw.action.ZoomAction;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Samuel
 */
public class GivenZoomAction extends Stage<GivenZoomAction>{
    
    @ProvidedScenarioState
    private double scaleFactor;
    private DrawingView view;
    private JComponent jComponent;
    private DrawingEditor editor;
    private AbstractButton button;
    private String label;
    private ZoomAction instance;
       
    
    @BeforeStage
    public void before() {
        editor = mock(DrawingEditor.class);
        view = mock(DrawingView.class);
        button = mock(AbstractButton.class);
        label =  (int) (scaleFactor * 100)+" %";
        jComponent = mock(JComponent.class);
        scaleFactor = 1.0;
    }
    
    GivenZoomAction zoomAction(){
        instance = new ZoomAction(view, scaleFactor, button);
        
        return self();
    }
  
}
