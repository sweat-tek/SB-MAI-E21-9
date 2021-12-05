package org.jhotdraw.samples.svg.gui;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.samples.svg.gui.jgiven_steps.GivenSomeState;
import org.jhotdraw.samples.svg.gui.jgiven_steps.ThenSomeOutcome;
import org.jhotdraw.samples.svg.gui.jgiven_steps.WhenSomeAction;
import org.junit.Test;

public class GivenObjectToFill extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    @Test
    public void object_should_be_filled() {
        given().an_object_is_selected();
        when().a_color_is_selected();
        then().the_object_should_be_filled_with_the_color();
    }
}
