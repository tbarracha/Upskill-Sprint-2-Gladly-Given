package pt.gladlyGivenApi.GladlyGiven.Models;

import java.util.Objects;

public class PhoneNumber {

    public long id;
    public long userId;
    public String number;

    public PhoneNumber() {
    }

    public PhoneNumber(long id, long userId, String number) {
        this.id = id;
        this.userId = userId;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return id == that.id;
    }



}
