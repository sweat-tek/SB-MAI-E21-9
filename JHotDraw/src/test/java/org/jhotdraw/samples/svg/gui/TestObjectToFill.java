package org.jhotdraw.samples.svg.gui;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.samples.svg.gui.jgiven_steps.GivenObjectSelected;
import org.jhotdraw.samples.svg.gui.jgiven_steps.ThenObjectFilled;
import org.jhotdraw.samples.svg.gui.jgiven_steps.WhenObjectSelected;
import org.junit.Test;

public class TestObjectToFill extends ScenarioTest<GivenObjectSelected, WhenObjectSelected, ThenObjectFilled> {

    @Test
    public void object_should_be_filled() {
        given().an_object_is_selected();
        when().an_object_is_selected();
        then().the_object_is_filled_with_a_default_color();
    }
}
