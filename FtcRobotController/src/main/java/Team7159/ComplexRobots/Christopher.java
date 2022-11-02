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

    public Servo armServo;
    public Servo servoClaw;

    public void init(HardwareMap Map) {

        super.init(Map);

        armServo = Map.servo.get("armServo");
        servoClaw = Map.servo.get("servoClaw");

        armServo.scaleRange(0, 0.7);
        armServo.setPosition(0);

        servoClaw.scaleRange(0, 0.7);
        servoClaw.setPosition(0);

    }
}
