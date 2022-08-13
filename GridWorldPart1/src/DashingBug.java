/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * 
 * This version of the bug class makes it so the "bug" keeps moving until it hits an obstacle or edge after it follows regular procedures, appearing that the
 * bug is dashing across the screen.
 * 
 */
public class DashingBug extends Actor
{
    int counter = 0;
    Color prevColor;
    boolean mad;
    /**
     * Constructs a red bug.
     */
    public DashingBug()
    {
        setColor(Color.RED);
        prevColor = Color.RED;
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public DashingBug(Color bugColor)
    {
        setColor(bugColor);
        prevColor = bugColor;
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
	    	if(counter % 2 == 0){
	    		if(mad == false) {
		    		if(getColor() != prevColor) {
		        		prevColor = getColor();
		        	}
	    		}
	    		if (canMove()) {
	    			mad = false;
	    			setColor(prevColor);
	    			prevColor = getColor();
	    			for(int count = 1;canMove() == true;count++) {
	    				move();
	    			}
	    		}
	    		else {
	    			setColor(Color.MAGENTA);
	    			turn();
	    			mad = true;
	    		}
	    	}
	    	else {
	    		//Do nothing
	    	}
    	counter++;
    	
    	
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + 90);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
