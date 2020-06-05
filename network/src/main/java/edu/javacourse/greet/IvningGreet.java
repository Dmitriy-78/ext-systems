package edu.javacourse.greet;

import edu.javacourse.net.Greetable;

public class IvningGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good ivning "+userName;
    }
}
