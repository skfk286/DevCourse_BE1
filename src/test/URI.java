package test;

import java.net.URISyntaxException;

public class URI {
    public static void main(String[] args) {
        try {
            // URI 생성
            java.net.URI uri = new java.net.URI("http://www.example.com/path?query=123#fragment");

            // URI 출력
            System.out.println("URI: " + uri);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
