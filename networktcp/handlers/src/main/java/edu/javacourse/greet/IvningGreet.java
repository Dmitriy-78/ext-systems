package edu.javacourse.greet;

import edu.javacourse.net.Greetable;

public class IvningGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "God Ivning "+userName;
    }
}
