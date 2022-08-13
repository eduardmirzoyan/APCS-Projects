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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChallengeBug extends Bug
{
    private int steps;
    private int sideLength;
    private int turns;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ChallengeBug(int length)
    {
        steps = 0;
        sideLength = length;
        turns = 0;
    }
    
    public boolean wantsToMove() {
    	Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return !(neighbor instanceof Flower);
    }
    
    public boolean hasToMove() {
    	if(!wantsToMove() && turns >= 8 && canMove()) {
    		turns = 0;
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
        	if(hasToMove()) {
        		move();
        		steps++;
        	}
            if(wantsToMove()) {
            	move();
            	turns = 0;
            	steps++;
            }
            else {
            	turn();
            	turns++;
            }
        }
        else
        {
            turn();
            turn();
            steps = 0;
        }
        System.out.println(turns);
    }
}
