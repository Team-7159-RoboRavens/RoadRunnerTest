package Team7159.BasicRobots;

import com.arcrobotics.ftclib.hardware.motors.*;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BasicHolonomic {

    public Motor RFMotor;
    public Motor RBMotor;
    public Motor LFMotor;
    public Motor LBMotor;


    public void init(HardwareMap Map){

`   //  LFMotor = new Motor(Map, "FLDrive");
    //  LBMotor = new Motor(Map, "BLDrive");
        // RFMotor = new Motor(Map, "FRDrive");
   //   RBMotor = new Motor(Map, "BRDrive");
        LFMotor = Map.Motor.get("FLDrive");
        LBMotor = Map.Motor.get("BLDrive");
        RFMotor = Map.Motor.get("FRDrive");
        RBMotor = Map.Motor.get("BRDrive");

       //RFMotor.set(0.0);
        //RBMotor.set(0.0);
        //LFMotor.set(0.0);
        //LBMotor.set(0.0);
        LFMotor.setPower(0.0);
        LBMotor.setPower(0.0);  
        RFMotor.setPower(0.0);
        RBMotor.setPower(0.0);

        LFMotor.setRunMode(Motor.RunMode.RawPower);
        RFMotor.setRunMode(Motor.RunMode.RawPower);
        LBMotor.setRunMode(Motor.RunMode.RawPower);
        RBMotor.setRunMode(Motor.RunMode.RawPower);

        RFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        RBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        LFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        LBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }

}
