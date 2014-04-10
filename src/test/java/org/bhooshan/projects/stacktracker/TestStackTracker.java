package org.bhooshan.projects.stacktracker;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: bhooshan
 * Date: 10/8/13
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStackTracker {

    @Test
    public void testSetup() throws NotFoundException, CannotCompileException {
        StackTracker st = new StackTracker();
        st.go("java.lang.Object", "hashCode");
    }
}
