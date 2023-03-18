package ru.itis.examples.anonymous;

public class Sandbox {
    public static void main(String[] args) {
        Post post0 = new PostImpl();

        Post post1 = new Post() {
            @Override
            public String getMessage(String name) {
                return name + " GOOD BYE";
            }
        };

        Post post2 = (name) -> { return name + ", HOW ARE YOU"; };

        Post post3 = (name) -> name + ", THANK YOU";

        System.out.println(post0.getMessage("Ildus"));
        System.out.println(post1.getMessage("Ildus"));
        System.out.println(post2.getMessage("Ildus"));
        System.out.println(post3.getMessage("Ildus"));
    }
}
