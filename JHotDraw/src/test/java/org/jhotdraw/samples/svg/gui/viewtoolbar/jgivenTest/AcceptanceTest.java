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
public class AcceptanceTest extends ScenarioTest<GivenZoomAction, WhenSetScale, ThenZoomIsPossible> {
    
    @Test
    public void viewPaletteHasAButtonScaleFactor() {
        given().givenZoomAction();
        when().getComponent().and().getScaleFactor();
        then().zoomIsPoosible();
    }
    
}
