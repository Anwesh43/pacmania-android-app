package com.example.anwesh.applicat;

/**
 * Created by Anwesh on 07-05-2015.
 */
import android.view.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
public class MyView extends View{
    GestureDetector gestureDetector;
    int index = 0;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    ArrayList<Pacman> pacmans = new ArrayList<Pacman>();
    public MyView(Context context) {
        super(context);
        gestureDetector = new GestureDetector(context,new GestureListener());
    }
    public void onDraw(Canvas canvas) {
        for(int i=0;i<pacmans.size();i++) {
            Pacman pacman = pacmans.get(i);
            PacmanDrawer.draw(canvas,paint,pacman);
            PacmanDrawer.move(pacman);
            if(pacman.getX()>=canvas.getWidth() || pacman.getX() <= 0) {
                pacmans.remove(i);
            }
        }
        try {
            Thread.sleep(100);
            invalidate();
        }
        catch (Exception exception) {

        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent event) {
            return true;
        }
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
        public boolean onFling(MotionEvent e1,MotionEvent e2,float velx,float vely) {
            if(e1.getX()<=e2.getX()) {
                Pacman pacman = new Pacman(e1.getX(),e2.getY(),0,30,0,1,index);
                pacmans.add(pacman);
            }
            if(e1.getX()>=e2.getX()) {
                Pacman pacman = new Pacman(e1.getX(),e2.getY(),180,-30,0,1,index);
                pacmans.add(pacman);
            }
            index++;
            try {
                if (pacmans.size() != 0) {
                    PackInsertor packInsertor = new PackInsertor();
                    packInsertor.execute(pacmans.get(pacmans.size()-1));
                }
            }
            catch(Exception exception) {

            }
            return true;
        }
    }
}
