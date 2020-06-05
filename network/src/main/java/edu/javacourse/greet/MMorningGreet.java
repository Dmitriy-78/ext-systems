package edu.javacourse.greet;

import edu.javacourse.net.Greetable;

public class MMorningGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good morning "+userName;
    }
}
