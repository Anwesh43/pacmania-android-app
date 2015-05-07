package com.example.anwesh.applicat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Anwesh on 07-05-2015.
 */

public class PacmanDrawer {

    public static void draw(Canvas canvas,Paint paint,Pacman pacman) {
        paint.setColor(Color.YELLOW);
        canvas.save();
        canvas.translate(pacman.getX(),pacman.getY());
        canvas.rotate(pacman.getDeg());
        canvas.drawPath(getPacShape(pacman.getA()),paint);
        canvas.restore();
    }
    public static void move(Pacman pacman) {
        pacman.setA(pacman.getA()+(int)pacman.getDir()*10);
        if(pacman.getA()>=30 || pacman.getA()<=0) {
            pacman.setDir(pacman.getDir()*-1);
        }
        pacman.setX(pacman.getSpeedx()+pacman.getX());
    }
    public static Path getPacShape(int a) {
        Path path = new Path();
        path.moveTo(0,0);
        for(int i=a;i<=360-a;i++) {
            path.lineTo((float)(50*Math.cos(i*Math.PI/180)),(float)(50*Math.sin(i*Math.PI/180)));
        }
        path.lineTo(0,0);
        return path;
    }
}
