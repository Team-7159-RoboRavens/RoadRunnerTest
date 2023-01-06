
package Team7159.ComplexRobots;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.*;


import Team7159.BasicRobots.BasicMecanum;
import Team7159.BasicRobots.BasicMecanum2;
import Team7159.Enums.Direction;

public class Christwopher extends BasicMecanum2 {

    public DcMotor linearSlidesMotor1;
    public DcMotor linearSlidesMotor2;
    public Servo servoClaw;

    public double servoClawOpen = 0.85;
    public double servoClawGrab = 0.6;

    public void init(HardwareMap Map) {

        super.init(Map);

        linearSlidesMotor1 = Map.dcMotor.get("linearSlidesMotor1");
//        linearSlidesMotor2 = Map.dcMotor.get("linearSlidesMotor2");
//
//        servoClaw = Map.servo.get("servoClaw");

        linearSlidesMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        linearSlidesMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        linearSlidesMotor1.setTargetPosition(0);
//        linearSlidesMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        linearSlidesMotor1.setPower(0);
//
//        linearSlidesMotor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        linearSlidesMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        linearSlidesMotor2.setTargetPosition(0);
//        linearSlidesMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        linearSlidesMotor2.setPower(0);

//        servoClaw.setPosition(servoClawGrab);
    }

    public void setLinearSlidePosition(double power, int position){

        linearSlidesMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        linearSlidesMotor1.setTargetPosition(position);
        linearSlidesMotor1.setPower(power);
//
//        linearSlidesMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        linearSlidesMotor2.setTargetPosition(position);
//        linearSlidesMotor2.setPower(power);
    }

}
