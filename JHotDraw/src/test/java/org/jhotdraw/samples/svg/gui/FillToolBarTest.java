package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class FillToolBarTest {

    @Test
    public void createDisclosedComponentNull() {
        // Test state = 0
        FillToolBar bar = new FillToolBar();

        JComponent disclosedComponent = bar.createDisclosedComponent(0);
        assertNull(disclosedComponent);
    }

    @Test
    public void createDisclosedComponentClosed() {
        // Test state = 1
        FillToolBar bar = new FillToolBar();
        bar.setEditor(new DefaultDrawingEditor()); // setting up the drawing editor

        JComponent disclosedComponent = bar.createDisclosedComponent(1);

        assertTrue(disclosedComponent instanceof JPanel);
        assertEquals(2, disclosedComponent.getComponentCount());
    }

    @Test
    public void createDisclosedComponentOpened() {
        // Test state = 2
        FillToolBar bar = new FillToolBar();
        bar.setEditor(new DefaultDrawingEditor()); // setting up the drawing editor

        JComponent disclosedComponent = bar.createDisclosedComponent(2);

        assertTrue(disclosedComponent instanceof JPanel);
        assertEquals(3, disclosedComponent.getComponentCount());
    }

}