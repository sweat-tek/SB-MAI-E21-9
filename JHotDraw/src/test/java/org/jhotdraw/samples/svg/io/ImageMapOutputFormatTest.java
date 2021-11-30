/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.io;

import java.awt.Dimension;
import java.awt.datatransfer.Transferable;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.OutputStream;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.filechooser.FileFilter;
import net.n3.nanoxml.IXMLElement;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ammar
 */
public class ImageMapOutputFormatTest {
    
    public ImageMapOutputFormatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFileFilter method, of class ImageMapOutputFormat.
     */
    @Test
    public void testGetFileFilter() {
        System.out.println("getFileFilter");
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        FileFilter expResult = null;
        FileFilter result = instance.getFileFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileExtension method, of class ImageMapOutputFormat.
     */
    @Test
    public void testGetFileExtension() {
        System.out.println("getFileExtension");
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        String expResult = "";
        String result = instance.getFileExtension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutputFormatAccessory method, of class ImageMapOutputFormat.
     */
    @Test
    public void testGetOutputFormatAccessory() {
        System.out.println("getOutputFormatAccessory");
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        JComponent expResult = null;
        JComponent result = instance.getOutputFormatAccessory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWrite_File_Drawing() throws Exception {
        System.out.println("write");
        File file = null;
        Drawing drawing = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.write(file, drawing);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWrite_OutputStream_Drawing() throws Exception {
        System.out.println("write");
        OutputStream out = null;
        Drawing drawing = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.write(out, drawing);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWrite_4args_1() throws Exception {
        System.out.println("write");
        OutputStream out = null;
        Drawing drawing = null;
        AffineTransform drawingTransform = null;
        Dimension imageSize = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.write(out, drawing, drawingTransform, imageSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWrite_4args_2() throws Exception {
        System.out.println("write");
        OutputStream out = null;
        List<Figure> figures = null;
        AffineTransform drawingTransform = null;
        Dimension imageSize = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.write(out, figures, drawingTransform, imageSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWrite_OutputStream_List() throws Exception {
        System.out.println("write");
        OutputStream out = null;
        List<Figure> figures = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.write(out, figures);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTransferable method, of class ImageMapOutputFormat.
     */
    @Test
    public void testCreateTransferable() throws Exception {
        System.out.println("createTransferable");
        Drawing drawing = null;
        List<Figure> figures = null;
        double scaleFactor = 0.0;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        Transferable expResult = null;
        Transferable result = instance.createTransferable(drawing, figures, scaleFactor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeElement method, of class ImageMapOutputFormat.
     */
    @Test
    public void testWriteElement() throws Exception {
        System.out.println("writeElement");
        IXMLElement parent = null;
        Figure f = null;
        ImageMapOutputFormat instance = new ImageMapOutputFormat();
        instance.writeElement(parent, f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
