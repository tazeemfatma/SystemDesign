package MiddlewareRouter;

public class Application {
    public static void main(String[] args){
        RouterImpl router=new RouterImpl();
        router.addRoute("/home","Welcome to Home");
        router.addRoute("/about","About Us");
        router.addRoute("/contact","Contact Us");
        router.addRoute("/google/hello /hi","Hi");
        System.out.println(router.callRoute("/home"));
        System.out.println(router.callRoute("/about"));
        System.out.println(router.callRoute("/contact"));
        System.out.println(router.callRoute("/google/hello/*"));
        // www.google.com/*/hi
    }
}
