//package Team7159.ComplexRobots;
//
//import com.arcrobotics.ftclib.hardware.ServoEx;
//import com.arcrobotics.ftclib.hardware.SimpleServo;
//import com.arcrobotics.ftclib.hardware.motors.Motor;
//import com.arcrobotics.ftclib.hardware.motors.MotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import Team7159.BasicRobots.BasicMecanum;
//
//public class Christopher extends BasicMecanum {
//
//}


package Team7159.ComplexRobots;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.hardware.motors.*;



import Team7159.BasicRobots.BasicMecanum;

public class Christopher extends BasicMecanum {

    public DcMotor armMotor;
    public Servo servoClaw;

    public void init(HardwareMap Map) {

        super.init(Map);

        armMotor = Map.dcMotor.get("armMotor");
        servoClaw = Map.servo.get("servoClaw");

        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setPower(0);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        servoClaw.scaleRange(0, 0.7);
        servoClaw.setPosition(0);

    }
}
