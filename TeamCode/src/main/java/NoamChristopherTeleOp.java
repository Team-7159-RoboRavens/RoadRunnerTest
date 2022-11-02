import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Power Play TeleOp")
public class NoamChristopherTeleOp extends LinearOpMode {

    //y - Slow strafe left
    //x - Slow forward
    //a - Slow backward
    //b  - Slow right
    //D-Pad - Directional Strafing
    //RB - Rotate Right
    //LB - Rotate Left
    //RT - Move Forward
    //LT - Move back

    private Christopher robot = new Christopher();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        double slowPower = 0.25;

        if(gamepad1.x) {
            robot.moveLeft(slowPower);
        }
        if(gamepad1.y) {
            robot.moveStraight(slowPower);
        }
        if(gamepad1.a) {
            robot.moveBackwards(slowPower);
        }
        if(gamepad1.b) {
            robot.moveRight(slowPower);
        }

        if(gamepad1.right_bumper) {

        }
        if(gamepad1.left_bumper) {

        }

//        Determines ratio of motor powers (by sides) using the right stick
        double rightRatio;
        double leftRatio;
        //Declares the maximum power any side can have
        double maxRatio = 1;

        //If we're turning left, the right motor should be at maximum power, so it decides the maxRatio. If we're turning right, vice versa.
//        if (rotate < 0) {
//            maxRatio = 1 / rightRatio;
//        } else {
//            maxRatio = 1 / leftRatio;
//        }

//        robot.pivotTurn(1, gamepad1.left_bumper, gamepad1.right_bumper);

        robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
        telemetry.update();
    }
}