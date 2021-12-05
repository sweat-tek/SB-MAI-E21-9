/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Mustafa
 */
public class AcceptanceTest extends ScenarioTest<GivenAnEdit, WhenEdit, ThenEdit > {
      
    @Test
    public void an_undoable_edit_can_be_undone(){
        given().no_edits();
        when().an_undoable_edit_has_been_made();
        then().the_edit_is_undoable();
    }
  
    @Test
    public void discarding_all_edits_should_remove_all_edits(){
        given().an_undoable_edit();
        when().discarding_all_edits();
        then().there_should_be_no_edits();
    }
    
    @Test
    public void an_insignificant_edit_should_not_count_as_an_undoable_edit(){
        given().no_edits();
        when().the_insignificant_edit_has_been_made();
        then().there_should_be_no_edits();
    }
}
