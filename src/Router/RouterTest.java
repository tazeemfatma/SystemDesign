package Router;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouterTest {
    Router rm;
    @Before
    public void setup(){
        rm = new Router();
    }
    @Test
    public void addRouteTest(){
        rm.addRoute("jira.atlassian.com/testRoute/abc/tt", "fooData1");
        rm.addRoute("jira.atlassian.com/testRoute/abcd", "fooData2");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/rr", "fooData4");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/pp", "fooData3");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/kk", "fooData5");
        rm.addRoute("jira.atlassian.com/testRoute/Users/:id", "User profile");
        assertEquals("Not Found",rm.findRoute("jira.atlassian.com/testRoute/abc"));
        assertEquals("fooData2",rm.findRoute("jira.atlassian.com/testRoute/abcd"));
        assertEquals("Not Found",rm.findRoute("jira.atlassian.com/testRoute/abcde"));
        assertEquals("fooData2",rm.findRoute("jira.atlassian.com/*/abcd"));
        assertEquals("fooData2",rm.findRoute("jira.atlassian.com/testRoute/*"));
        assertEquals("fooData1",rm.findRoute("jira.atlassian.com/testRoute/*/*"));
        assertEquals("Not Found",rm.findRoute("jira.atlassian.com/*"));
        assertEquals("fooData1",rm.findRoute("jira.atlassian.com/testRoute/abc*/*"));
        assertEquals("fooData3",rm.findRoute("jira.atlassian.com/testRoute/*/pp"));
        assertEquals("User profile",rm.findRoute("jira.atlassian.com/testRoute/User*/23"));
        assertEquals("Not Found",rm.findRoute("jira.atlassian.com/testRoute/User*/dd"));
        assertEquals("Not Found",rm.findRoute("jira.atlassian.com/*/abcd/tt"));
    }
}
