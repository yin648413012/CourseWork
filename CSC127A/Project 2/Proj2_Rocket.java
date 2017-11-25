/* Proj2_Rocket
*
* CSc 127A Fall 15, Project 02
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This class calculates the performance of a three-stage rocket, using
* extremely inaccurate equations provided by the instructor.
*/

public class Proj2_Rocket
{
    public static void main(String[] args)
    {
        
  /* payload is the weight of the object that the rocket is lifting
   * stages are the number of engines mounted onto them
   * fuel is the amount of fuel that the stages have 
   * All measurements of units are in kg
   */
        double payload;
        double stage1;
        double fuel1;
        double stage2;
        double fuel2;
        double stage3;
        double fuel3;
        
        payload = Double.parseDouble(args[0]);
        stage1 = Double.parseDouble(args[1]);
        fuel1 = Double.parseDouble(args[2]);
        stage2 = Double.parseDouble(args[3]);
        fuel2 = Double.parseDouble(args[4]);
        stage3 = Double.parseDouble(args[5]);
        fuel3 = Double.parseDouble(args[6]);
        
        //stageWeight is the weight of each stage
        //EVERY ENGINE IS 100kg!
        
        double stage3Weight = payload + fuel3 + (stage3*100);
        double stage2Weight = payload + fuel3 + fuel2 + (stage3*100) + (stage2*100);
        double stage1Weight = payload + fuel3 + fuel2 + fuel1 + (stage3*100) + (stage2*100) + (stage1*100);
            
        //Equations:
        
        //STAGE 1
        double totalThrust1 = stage1 * 1000;
        double acceleration1 = (totalThrust1 - stage1Weight);
        double burnoutTime1 = ((fuel1)/(100*stage1));
        double deltaV1 = acceleration1 * burnoutTime1;
        double speedAfterThisStage1 = 0 + deltaV1;
        double altitudeAfterThisStage1 = 0 + burnoutTime1 * ((2 * 0 + deltaV1)/2);
        
        
        //STAGE 2
        double totalThrust2 = stage2 * 1000;
        double acceleration2 = (totalThrust2 - stage2Weight);
        double burnoutTime2 = ((fuel2)/(100*stage2));
        double deltaV2 = acceleration2 * burnoutTime2;
        double speedAfterThisStage2 = speedAfterThisStage1 + deltaV2;
        double altitudeAfterThisStage2 = altitudeAfterThisStage1 + burnoutTime2 * ((2 * speedAfterThisStage1 + deltaV2)/2);
        
        
        //STAGE 3
        double totalThrust3 = stage3 * 1000;
        double acceleration3 = (totalThrust3 - stage3Weight);
        double burnoutTime3 = ((fuel3)/(100*stage3));
        double deltaV3 = acceleration3 * burnoutTime3;
        double speedAfterThisStage3 = speedAfterThisStage2 + deltaV3;
        double altitudeAfterThisStage3 = altitudeAfterThisStage2 + burnoutTime3 * ((2 * speedAfterThisStage2 + deltaV3)/2);
       
        
        //Apogee Equations
        
        double timeToApogee = (speedAfterThisStage3 / 9.8);
        double apogee = (altitudeAfterThisStage3 + speedAfterThisStage3 * timeToApogee - 4.9 * timeToApogee * timeToApogee);
        
        //Output:
        
        System.out.println("Weight of the first stage stack: " + stage1Weight);
        System.out.println("   First stage thrust: " + totalThrust1);
        System.out.println("Weight of the second stage stack: " + stage2Weight);
        System.out.println("   Second stage thrust: " + totalThrust2);
        System.out.println("Weight of the second stage stack: " + stage3Weight);
        System.out.println("   Third stage thrust: " + totalThrust3);
        System.out.println("   ");
        
        System.out.println("After the first stage: ");
        System.out.println("   Speed: " + speedAfterThisStage1);
        System.out.println("   Altitude: " + altitudeAfterThisStage1);
        System.out.println("   ");    
        
        System.out.println("After the second stage: ");
        System.out.println("   Speed: " + speedAfterThisStage2);
        System.out.println("   Altitude: " + altitudeAfterThisStage2);
        System.out.println("   ");    
        
        System.out.println("After the third stage: ");
        System.out.println("   Speed: " + speedAfterThisStage3);
        System.out.println("   Altitude: " + altitudeAfterThisStage3);
        System.out.println("   ");                       
        
        System.out.println("Apogee: " + apogee);
        
        //In case of errors with the spaceship
        
        if (speedAfterThisStage1 <= 0)
            System.out.println("STALL! The speed after the first stage is <= 0");
        if (altitudeAfterThisStage1 <= 0)
            System.out.println("CRASH! The altitude after the first stage is <= 0");
        
        if (speedAfterThisStage2 <= 0)
            System.out.println("STALL! The speed after the first stage is <= 0");
        if (altitudeAfterThisStage2 <= 0)
            System.out.println("CRASH! The altitude after the first stage is <= 0");
        
        if (speedAfterThisStage3 <= 0)
            System.out.println("STALL! The speed after the first stage is <= 0");
        if (altitudeAfterThisStage3 <= 0)
            System.out.println("CRASH! The altitude after the first stage is <= 0");
        
      }
}
                               