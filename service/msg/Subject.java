package com.work.service.msg;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern
 * @author Jiayu Liu
 */
public abstract class Subject {

    private final List<Observer> OBSERVERS = new ArrayList<>();

    public void addObserver(Observer observer){
        OBSERVERS.add(observer);
    }

    public void delObserver(Observer observer){
        OBSERVERS.remove(observer);
    }

    public void notifyObserver(Integer productId){
        //notice
        OBSERVERS.forEach(observer -> observer.update(productId));
    }
}
