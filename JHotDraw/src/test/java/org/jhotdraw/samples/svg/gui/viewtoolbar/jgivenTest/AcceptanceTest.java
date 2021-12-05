/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.viewtoolbar.jgivenTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Samuel
 */
public class AcceptanceTest extends ScenarioTest<GivenView, WhenViewIsVisible, ThenViewIsVisible> {
    
    @Test
    public void view_palette_has_a_grid(){
        given().aView();
        when().settingAView();
        then().viewIsVisible();
    }
    
}
