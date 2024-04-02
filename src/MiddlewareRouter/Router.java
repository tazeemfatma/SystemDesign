package MiddlewareRouter;

public interface Router {

    void addRoute(String path, String result);
    String findRoute(String path);
}
