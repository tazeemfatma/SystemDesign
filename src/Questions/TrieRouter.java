package Questions;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    String content;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        content = "";
        isWord = false;
    }
}

class Router {
    private TrieNode root;

    public Router() {
        root = new TrieNode();
    }

    // Insert a route into the Trie
    public void addRoute(String path, String result) {
        TrieNode current = root;
        for (char c : path.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isWord = true;
        current.content = result;
    }

    // Call the route based on the input URL
    public String callRoute(String url) {
        return searchWildcard(root, url, 0);
    }

    private String searchWildcard(TrieNode node, String url, int index) {
        if (index == url.length()) {
            return node.isWord ? node.content : "Route not found";
        }

        char c = url.charAt(index);
        TrieNode nextNode = node.children.get(c);

        if (nextNode != null) {
            return searchWildcard(nextNode, url, index + 1);
        } else if (c == '*') {
            // Handle wildcard
            for (TrieNode child : node.children.values()) {
                String result = searchWildcard(child, url, index);
                if (!result.equals("Route not found")) {
                    return result;
                }
            }
        }

        return "Route not found";
    }

    public static void main(String[] args) {
        Router router = new Router();
        router.addRoute("/foo/bar", "Result for /foo/bar");
        router.addRoute("/foo/*", "Result for /foo/*");
        router.addRoute("/user/profile", "Result for /user/profile");

        System.out.println(router.callRoute("/foo/bar*")); // Returns "Result for /foo/bar"
        System.out.println(router.callRoute("/foo/baz")); // Returns "Result for /foo/*"
        System.out.println(router.callRoute("/user/profile")); // Returns "Result for /user/profile"
        System.out.println(router.callRoute("/unknown/path")); // Returns "Route not found"
        System.out.println(router.callRoute("*")); // Returns "Route not found"

    }
}
