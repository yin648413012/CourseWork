public class Proj1Car extends BaseCar
{
    /* This method is called over and over by main().  The job of this method
     * is to decide whether the car should speed up (return 1), slow down
     * (return -1), or coast (return 0).
     *
     * There are two basic requirements:
     *   - Don't exceed the speed limit of 35 (THERE IS NO SPEED LIMIT IN CAR CHASE)
     *   - Don't crash into another car
     *
     * To decide what to do, you have several methods you can call to query
     * the state of your car:
     *   getSpeed()       - gives the speed of your own car
     *   distToNextCar()  - gives the dist to the car in front of you
     *   speedOfNextCar() - gives the speed of the car in front of you
     */
    public int getPedal()
    {
        // you must implement this method from scratch.  For a first pass,
        // how about using the rule "speed up if we are too far behind,
        // and slow down if we are too close".  This will work poorly - and
        // often result in crashes - but it's a good starting point.
        
        //You want to stay at distance=100 from the car and maintain a constant
        //speed with he baddies after that
        //Goal: Mimic speed of Baddies at the distance of 100
        //---------------------  
        
        //If the distance between the cars is near 100, and the speeds are near each other, the car will
        //mimic the next car
        if ((distToNextCar() < 110)&&(distToNextCar() > 90)&&(speedOfNextCar() > getSpeed()))
            return 1;
        
        if ((distToNextCar() < 110)&&(distToNextCar() > 90)&&(speedOfNextCar() < getSpeed()))
            return -1;
             
        //if you get too close, the priority is to slow down
        if ((distToNextCar() < 80))
            return -1;
        
        //-------
        
        //If the cars get too far apart, the preceding car will speed up
        if (distToNextCar() > 100)
            return 1;
        
        //If the next car slows down, the car will slow down too
        if (getSpeed() > speedOfNextCar())
            return -1;
        
        //If the next car speeds up, the car will speed up to
        if (getSpeed() < speedOfNextCar())
            return 1;
        
        //If the cars are too close, the car will slow down
        if (distToNextCar() < 90)
            return -1;
        
        //If the car is moving too fast, slow down
        if (getSpeed() + 10 > speedOfNextCar())
            return -1;

        return -1;
        
    }
}
