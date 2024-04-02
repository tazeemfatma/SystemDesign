package MiddlewareRouter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RouterImpl {
    HashMap<Pattern,String> routes;
    RouterImpl(){
        routes=new HashMap<>();
    }
    void addRoute(String path, String result){
        routes.put(Pattern.compile(path),result);
    }
    String callRoute(String path){
        for (Map.Entry<Pattern, String> entry : routes.entrySet()) {
            if (entry.getKey().matcher(path).matches()) {
                return entry.getValue();
            }
        }
       return "Route Not Found";
    }
}
