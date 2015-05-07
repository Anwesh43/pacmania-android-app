package com.example.anwesh.applicat;

/**
 * Created by Anwesh on 07-05-2015.
 */
import android.graphics.*;
public class Pacman{
    private float x,y,deg,dir,speedx;
    private int a;
    private int index;
    public Pacman(float x,float y,float deg,float speedx,int a,float dir,int index) {
        this.x = x;
        this.y = y;
        this.deg = deg;
        this.speedx = speedx;
        this.a = a;
        this.dir = dir;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getX() {
        return this.x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getY() {
        return this.y;
    }
    public void setDeg(float deg) {
        this.deg = deg;
    }
    public float getDeg() {
        return this.deg;
    }
    public void setSpeedx(float speedx){
        this.speedx = speedx;
    }
    public float getSpeedx() {
        return this.speedx;
    }
    public void setDir(float dir) {
        this.dir = dir;
    }
    public float getDir() {
        return this.dir;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getA() {
        return this.a;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
