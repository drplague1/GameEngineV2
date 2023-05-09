package com.Vectors;
/**
 * The class responsible for controlling most, if not all velocity based movement
 * @author RamenGOD
 */
public class Vector2 {
    private boolean isClamped = false;
    private int max;
    private int min;
    public int x;
    public int y;
    //
    /**
     *  creates a new Vector at (0, 0) with an accessable values such as x, and y
     */
    public Vector2() {}
    /**
     *  creates a new Vector at the inputed (x, y) with an accessable values such as x, and y
     */
    public Vector2(int x, int y) {
        //
        this.x = x;
        this.y = y;
        //
    }
    //
    public void add(int x, int y) {
        if(isClamped) {
            this.x += x;
            this.y += y;
            if(this.x > max) this.x = max; 
            if(this.y > max) this.y = max;
        } else {
            this.x += x;
            this.y += y;
        }
    }
    //
    public void subtract(int x, int y) {
        if(isClamped) {
            this.x -= x;
            this.y -= y;
            if(this.x < min) this.x = min; 
            if(this.y < min) this.y = min;
        } else {
            this.x += x;
            this.y += y;
        }
    }
    /**
     * set the min and max value of this vector
     * @param min the minimum value this vector can be set to
     * @param max the maximum value this vector can be set to
     */
    public void clamp(int min, int max) {
        this.isClamped = true;
        //
        this.max = max;
        this.min = min;
        //
    }
    //
}