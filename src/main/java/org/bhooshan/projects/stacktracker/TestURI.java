package org.bhooshan.projects.stacktracker;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: bhooshan
 * Date: 10/21/13
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestURI {
    public static void main(String [] args) {
        URI uri = URI.create("file://tmp");
        String msg = uri.getAuthority() == null ? "problem" : "no problem " + uri.getAuthority() + ";" + uri.getPath();
        System.out.println(msg);
    }
}
