package org.jhotdraw.draw.action.jgivenTest;

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;

// @author: sebni19@student.sdu.dk
/*
Test class with jGiven, performing the actual acceptance test to see if the object was created.
*/

public class TextCreationTest extends ScenarioTest<GivenTextToCreate, WhenCreatingText, ThenTextIsCreated> {
    @Test
    public void sampleTextExistsTest() {
        given().missingTextfield();
        when().creatingNewText();
        then().sampleTextShouldHaveBeenCreated();
    }
}
