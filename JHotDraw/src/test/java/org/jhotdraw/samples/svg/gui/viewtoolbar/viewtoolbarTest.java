/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.junitTest;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.JPanel;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.samples.svg.gui.AbstractToolBar;
import org.jhotdraw.samples.svg.gui.ViewToolBar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samuel
 */

public class viewtoolbarTest {
    JPanel resultParent;
    JPanel expResParent;
    JFrame rootPane;
    BufferedImage image; 
    Graphics2D graphics2d; 
    AbstractToolBar abstractToolBar;
    
    public viewtoolbarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.abstractToolBar = new AbstractToolBar();
        this.rootPane = new JFrame();
        this.resultParent = new JPanel(new GridBagLayout());
        this.expResParent = new JPanel(new GridBagLayout());
        this.image = new BufferedImage(100,100, BufferedImage.TYPE_INT_ARGB);
        this.graphics2d= image.createGraphics();

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
    public void testJPanel() {
        System.out.println("Test JPanel components");
        
        int resultInt = resultParent.getComponentCount();
        int expResult = expResParent.getComponentCount();;
        int result = resultInt;
        
        System.out.println("Expected: " + resultInt);
        assertEquals(expResult, result);
    }

    @Test
    public void testViewPalette() {
        System.out.println("Test View Palette states as components");
        
        rootPane.add(resultParent);
        rootPane.add(expResParent);
        
        JComponent result = abstractToolBar.getDisclosedComponent(1);
        resultParent.add(result);
        result.paint(graphics2d);
        int resultInt = resultParent.getComponentCount();
        System.out.println("result:" + resultInt);
        
        JComponent expResult = new JPanel();
        expResParent.add(expResult);
        expResult.paint(graphics2d);
        int expResultInt = expResParent.getComponentCount();
        
        System.out.println("expresult:" + expResultInt);
        assertEquals("expects parent to have one component", 1, resultInt);
        assertEquals(expResultInt, resultInt);
    }
    
}
