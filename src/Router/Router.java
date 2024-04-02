package Router;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Router {

    Map<String, Router> routes;
    String val;
    boolean endOfRoute;

    Router() {
        routes = new HashMap<>();
        endOfRoute = false;
    }

    static Router start = new Router();

    public void addRoute(String url, String val) {

        Router router = start;

        String[] components = url.split("/");
        for (int i = 0; i < components.length; i++) {
            if (!router.routes.containsKey(components[i])) {
                router.routes.put(components[i], new Router());
            }
            router = router.routes.get(components[i]);
        }

        router.val = val;
        router.endOfRoute = true;

    }

    public String findRoute(String url) {
        Router router = start;
        String[] components = url.split("/");

        router = dfs(router, 0, components);

        if (router != null && router.val != null)
            return router.val;

        return "Not Found";
    }

    private Router dfs(Router router, int i, String[] components) {

        if (router == null)
            return null;
        if (components.length == i) {
            if (router.endOfRoute)
                return router;
            return null;
        }

        if (components[i].equals("*") ) {
            for (String s : router.routes.keySet()) {
                Router tempRouter = dfs(router.routes.get(s), i + 1, components);
                if (tempRouter != null)
                    return tempRouter;
            }
            return null;
        }
        else if(components[i].contains("*")){//abc*/ss
            components[i]=components[i].replace("*",".*");
            Pattern pattern=Pattern.compile(components[i]);
            for (String s : router.routes.keySet()) {
                Matcher matcher = pattern.matcher(s);
                if(matcher.matches()){
                    Router tempRouter = dfs(router.routes.get(s), i + 1, components);
                    if (tempRouter != null)
                        return tempRouter;
                }
            }
            return null;
        }
        else if(components[i].matches("[0-9]+") && router.routes.containsKey(":id")){
            Router tempRouter = dfs(router.routes.get(":id"), i + 1, components);
            if (tempRouter != null)
                return tempRouter;
            return null;
        }
        else if (router.routes.containsKey(components[i])) {
            return dfs(router.routes.get(components[i]), i + 1, components);
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Router rm = new Router();
        rm.addRoute("jira.atlassian.com/testRoute/abc/tt", "fooData1");
        rm.addRoute("jira.atlassian.com/testRoute/abcd", "fooData2");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/rr", "fooData4");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/pp", "fooData3");
        rm.addRoute("jira.atlassian.com/testRoute/abcd/kk", "fooData5");
        rm.addRoute("jira.atlassian.com/testRoute/Users/:id", "User profile");
        System.out.println("1 "+rm.findRoute("jira.atlassian.com/testRoute/abc"));
        System.out.println("2 "+rm.findRoute("jira.atlassian.com/testRoute/abcd"));
        System.out.println("3 "+rm.findRoute("jira.atlassian.com/testRoute/abcde"));
        System.out.println("4 "+rm.findRoute("jira.atlassian.com/*/abcd"));
        System.out.println("5 "+rm.findRoute("jira.atlassian.com/testRoute/*"));
        System.out.println("6 "+rm.findRoute("jira.atlassian.com/testRoute/*/*"));
        System.out.println("7 "+rm.findRoute("jira.atlassian.com/*"));
        System.out.println("8 "+rm.findRoute("jira.atlassian.com/testRoute/abc*/*"));
        System.out.println("9 "+rm.findRoute("jira.atlassian.com/testRoute/*/pp"));
        System.out.println("10 "+rm.findRoute("jira.atlassian.com/testRoute/User*/23"));

    }

}
