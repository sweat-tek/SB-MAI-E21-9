/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.junitTest;

import javax.swing.*;
import javax.swing.JPanel;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.action.ZoomAction;
import org.jhotdraw.samples.svg.gui.AbstractToolBar;
import org.jhotdraw.samples.svg.gui.ViewToolBar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Samuel
 */

public class viewtoolbarTest { 
    private static double scaleFactor;
    private static DrawingView view;
    private static JComponent jComponent;
    private static DrawingEditor editor;
    private static AbstractButton button;
    private static String label;
    
    public viewtoolbarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        editor = mock(DrawingEditor.class);
        view = mock(DrawingView.class);
        button = mock(AbstractButton.class);
        label =  (int) (scaleFactor * 100)+" %";
        jComponent = mock(JComponent.class);
        
        when(view.getScaleFactor()).thenReturn(1.0);
        when(view.getComponent()).thenReturn(jComponent);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() { 
        scaleFactor = 1.0;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testInit() {
        System.out.println("Init");
        ViewToolBar instance = new ViewToolBar();
        instance.init();
    }
    
    @Test
    public void testGetButton() {
        System.out.println("getButton");
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        AbstractButton expResult = button;
        AbstractButton result = instance.getButton();
        assertEquals(expResult, result);
    }
    
}
