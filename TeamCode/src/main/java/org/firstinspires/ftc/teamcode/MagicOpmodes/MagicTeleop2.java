package org.firstinspires.ftc.teamcode.MagicOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.Christwopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Chris2 Magic Teleop", group = "ChrisTWOpher")
public class MagicTeleop2 extends LinearOpMode {

    private Christwopher robot = new Christwopher();

    ElapsedTime et;
    double timeServo;

    final double servoDelay = 100;

    boolean slowRev = false;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("LS Motor 1 Pos:", () -> robot.linearSlidesMotor1.getCurrentPosition());
        telemetry.addData("LS Motor 2 Pos:", () -> robot.linearSlidesMotor2.getCurrentPosition());
        telemetry.addData("Servo Claw Pos:", () -> robot.claw.getPosition());
        timeServo = 0;
        et = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        telemetry.addLine("Robot is Ready");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            if (et.time() - timeServo > servoDelay) {
                if (gamepad2.a) {
                    robot.claw.setPosition(robot.claw.getPosition() + 0.05);
                    timeServo = et.time();
                } else if (gamepad2.b) {
                    robot.claw.setPosition(robot.claw.getPosition() - 0.05);
                    timeServo = et.time();
                }
            }
            if (gamepad2.left_trigger > 0.1) {
                if (robot.linearSlidesMotor1.getCurrentPosition() < -10) {
                    telemetry.addData("Direction", "INHIBIT DOWN");
                    robot.linearSlidesMotor1.setPower(0);
                    robot.linearSlidesMotor2.setPower(0);
                } else {
                    telemetry.addData("Direction", "DOWN");
                    robot.linearSlidesMotor1.setPower(-0.25 * gamepad2.left_trigger);
                    robot.linearSlidesMotor2.setPower(-0.25 * gamepad2.left_trigger);
                }
            } else if (gamepad2.right_trigger > 0.1) {
                telemetry.addData("Direction", "UP");
                robot.linearSlidesMotor1.setPower(0.5 * gamepad2.right_trigger);
                robot.linearSlidesMotor2.setPower(0.5 * gamepad2.right_trigger);
            } else {
                telemetry.addData("Direction", "OFF");
                if (slowRev) {
                    robot.linearSlidesMotor1.setPower(0.07);
                    robot.linearSlidesMotor2.setPower(0.07);
                } else {
                    robot.linearSlidesMotor1.setPower(0);
                    robot.linearSlidesMotor2.setPower(0);
                }
            }
            if (gamepad2.right_bumper) {
                slowRev = true;
            } else if (gamepad2.left_bumper) {
                slowRev = false;
            }
            telemetry.addData("Hold Mode", slowRev);
            telemetry.update();
        }
    }
}