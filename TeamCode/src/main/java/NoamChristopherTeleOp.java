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
        double regPower = 1.0;

        double accel;
        double rotate;
        double powR;
        double powL;

        while (opModeIsActive()) {

            telemetry.addData("Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm velocity: ", robot.armMotor.getCurrentPosition());

            if (gamepad1.x) {
                robot.moveLeft(slowPower);
            }
            else if (gamepad1.y) {
                robot.moveStraight(slowPower);
            }
            else if (gamepad1.a) {
                robot.moveBackwards(slowPower);
            }
            else if (gamepad1.b) {
                robot.moveRight(slowPower);
            }

            if(gamepad1.right_trigger > 0.1) {
                robot.moveStraight(regPower);
            }
            else if(gamepad1.left_trigger > 0.1) {
                robot.moveBackwards(regPower);
            }

            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);

            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            telemetry.update();

        }
    }
}