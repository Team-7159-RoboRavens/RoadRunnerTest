
package Team7159.ComplexRobots;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import Team7159.BasicRobots.BasicMecanum2;
import Team7159.Enums.Direction;

public class ChrisTWOpher extends BasicMecanum2 {

    public double armPosHigh = 10;
    public double armPosMid = 5;
    public double armPosLow = 1;
    public double armPosGround = 0;
    public double armPosBack = 0;

    public double servoPosHigh = 1.0;
    public double servoPosMid = 0.9;
    public double servoPosLow = 0.7;
    public double servoPosGround = 0.5;
    public double servoPosBack = 1.0;

    public double servoClawOpen = 0.95;
    public double servoClawGrab = 0.35;

    public void init(HardwareMap Map) {
        super.init(Map);
    }

    // For Autos
    public void strafeBruh(Direction direction, double power) throws InterruptedException{
        if(direction == Direction.LEFT){
            LFMotor.setPower(-power * 0.5);
            RFMotor.setPower(power);
            LBMotor.setPower(power * 0.5);
            RBMotor.setPower(-power);
        }else if(direction == Direction.RIGHT){
            LFMotor.setPower(power);
            RFMotor.setPower(-power);
            LBMotor.setPower(-power);
            RBMotor.setPower(power);
        }
        else if(direction == Direction.FORWARDS) {
            LFMotor.setPower(power);
            RFMotor.setPower(power);
            LBMotor.setPower(power);
            RBMotor.setPower(power);
        }
        else if(direction == Direction.BACKWARDS) {
            LFMotor.setPower(-power);
            RFMotor.setPower(-power);
            LBMotor.setPower(-power);
            RBMotor.setPower(-power);
        }
        else{
            //Throw an exception
        }
    }

    // Tile Version
    public void strafe(Direction direction, double power, double tiles) throws InterruptedException{
        int tileTime = 1000;
        if(direction == Direction.LEFT){
            LFMotor.setPower(-power);
            RFMotor.setPower(power);
            LBMotor.setPower(power);
            RBMotor.setPower(-power);
//            Thread.sleep((long)tiles * tileTime);
//            Thread.sleep((long)tiles * tileTime * (1 / (long) power));
//            stop();
        }else if(direction == Direction.RIGHT){
            LFMotor.setPower(power);
            RFMotor.setPower(-power);
            LBMotor.setPower(-power);
            RBMotor.setPower(power);
//            Thread.sleep((long)tiles * tileTime);
//            Thread.sleep((long)tiles * tileTime * (1 / (long) power));
//            stop();
        }
        else if(direction == Direction.FORWARDS) {
            LFMotor.setPower(power);
            RFMotor.setPower(power);
            LBMotor.setPower(power);
            RBMotor.setPower(power);
//            Thread.sleep((long) tiles * tileTime);
//            Thread.sleep((long)tiles * tileTime * (1 / (long) power));
//            stop();
        }
        else if(direction == Direction.BACKWARDS) {
            LFMotor.setPower(-power);
            RFMotor.setPower(-power);
            LBMotor.setPower(-power);
            RBMotor.setPower(-power);
//            Thread.sleep((long) tiles * tileTime);
//            Thread.sleep((long)tiles * tileTime * (1 / (long) power));
//            stop();
        }
        else{
            //Throw an exception
        }
    }

    // Rotate angle method
    public void rotate(Direction direction, double power, double inputAngle) throws InterruptedException {
        double time90 = 1000;
        double angleTime = (inputAngle/90) * time90;

        if(direction == Direction.LEFT) {
            RFMotor.setPower(-power);
            LFMotor.setPower(power);
            RBMotor.setPower(-power);
            LBMotor.setPower(power);
        } else if(direction == Direction.RIGHT) {
            RFMotor.setPower(power);
            LFMotor.setPower(-power);
            RBMotor.setPower(power);
            LBMotor.setPower(-power);
        }
    }
    public void rotateBruh(Direction direction, double power) throws InterruptedException {
        if(direction == Direction.LEFT) {
            RFMotor.setPower(-power);
            LFMotor.setPower(power);
            RBMotor.setPower(-power);
            LBMotor.setPower(power);
        } else if(direction == Direction.RIGHT) {
            RFMotor.setPower(power);
            LFMotor.setPower(-power);
            RBMotor.setPower(power);
            LBMotor.setPower(-power);
        }
    }
}
