package com.homework.booking.entity;

public class Room {

      private int numberOfPerson;

      private int cost;

      private boolean free;

      public Room(int numberOfPerson, int cost, boolean free) {
          this.numberOfPerson = numberOfPerson;
          this.cost = cost;
          this.free = free;
      }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
