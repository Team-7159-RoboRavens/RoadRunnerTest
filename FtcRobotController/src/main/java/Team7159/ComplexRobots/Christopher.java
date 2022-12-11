
package Team7159.ComplexRobots;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.*;


import Team7159.BasicRobots.BasicMecanum;
import Team7159.Enums.Direction;

public class Christopher extends BasicMecanum {

    public DcMotor armMotor;
    public Servo servoClaw;
    public Servo servoArm2;


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


    public double servoClawOpen = 0.85;
    public double servoClawGrab = 0.6;

    public void init(HardwareMap Map) {

        super.init(Map);

        armMotor = Map.dcMotor.get("armMotor");
        servoClaw = Map.servo.get("servoClaw");
//        servoArm2 = Map.servo.get("servoArm2");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setPower(0);


        servoClaw.setPosition(servoClawGrab);


//        servoArm2.setPosition(servoPosBack);
    }


    // Method for arm pos
    public void armPos(double power, double armPos, double servoArmPos) {
        if(armMotor.getCurrentPosition() < armPosMid) {
            while (armMotor.getCurrentPosition() <= armPosMid) {
                armMotor.setPower(power);
            }
            armMotor.setPower(0);
        }
        else {
            while (armMotor.getCurrentPosition() >= armPosMid) {
                armMotor.setPower(-power);
            }
            armMotor.setPower(0);
        }

        servoArm2.setPosition(servoPosMid);
    }

}
