/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.ArrayList;
import java.util.Collection;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yonus
 */
public class GroupActionTest extends Stage<GivenFiguresToGroup>{
    
    @ProvidedScenarioState
    private DrawingEditor editor;
   
    GroupAction groupAction;
    DrawingView view;
    
    ArrayList<Figure> collection = new ArrayList<>();
    
    Figure f1 = new BezierFigure();
    Figure f2 = new BezierFigure();
    Figure f3 = new BezierFigure();
    
    public GroupActionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
   
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
        
        this.groupAction = new GroupAction(editor, new SVGGroupFigure());
        
        this.collection.add(f1);
        this.collection.add(f2);
        this.collection.add(f3);
        
        editor.getActiveView().getDrawing().addAll(collection);
    }
    
    @After
    public void tearDown() {
        collection = null;
        editor.remove(view);
    }

    /**
     * Test of groupFigures method, of class GroupAction.
     */
    @Test
    public void testGroupFigures() {
        
        assert !collection.isEmpty() : "No figures to select and group";
        // Selects the 3 drawn figures
        editor.getActiveView().addToSelection(collection);
        
        // Triggers the groupFigures on the selected figures
        CompositeFigure group = this.groupAction.groupFigures(this.view, this.view.getSelectedFigures());
        
        // Checks wether the 3 figures appear in the generated group
        assertTrue("The elements expected grouped, are not grouped",group.getChildren().equals(collection));
        
        // Checks wether the 3 figures appear in the generated group
        assertTrue("The group made, is not present in the drawing", this.view.getDrawing().getChildren().contains(group));
    }
    
}
