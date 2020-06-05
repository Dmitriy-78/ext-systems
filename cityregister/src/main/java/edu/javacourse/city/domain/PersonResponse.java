package edu.javacourse.city.domain;

public class PersonResponse {

    private boolean registered;
    private boolean temparal;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isTemparal() {
        return temparal;
    }

    public void setTemparal(boolean temparal) {
        this.temparal = temparal;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "registered=" + registered +
                ", temparal=" + temparal +
                '}';
    }
}
