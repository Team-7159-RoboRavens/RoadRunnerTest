package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.Christwopher;
import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="ChrisTWOpher Driving TL", group="ChrisTWOpher")
public class NoamKrishChrisTWOpherTeleOp extends LinearOpMode {

    //y - Slow strafe left
    //x - Slow forward
    //a - Slow backward
    //b  - Slow right
    //D-Pad - Directional Strafing
    //RB - Rotate Right
    //LB - Rotate Left
    //RT - Move Forward
    //LT - Move back

    private Christwopher robot = new Christwopher();

    double linearSlidesPower = 1.0;

    double slowPower = 0.25;
    double regPower = 0.5;

    ElapsedTime et;
    double timeServo;

    final double servoDelay = 100;
    boolean isPressed = false;
    boolean slowRev = false;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        et = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        timeServo = 0;
        telemetry.addLine("Robot is Ready");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            //Claw
            if (et.time() - timeServo > servoDelay) {
                //TODO: find magic numbers for pos
                if (gamepad2.a) {
                    robot.claw.setPosition(robot.claw.getPosition() + 0.05);
                    timeServo = et.time();
                } else if (gamepad2.b) {
                    robot.claw.setPosition(robot.claw.getPosition() - 0.05);
                    timeServo = et.time();
                }
            }
            //Linear Slides
            if (gamepad2.left_trigger > 0.1) {
                if (robot.linearSlidesMotor1.getCurrentPosition() < -10) {
                    telemetry.addData("LS Direction", "INHIBIT DOWN");
                    robot.linearSlidesMotor1.setPower(0);
                    robot.linearSlidesMotor2.setPower(0);
                } else {
                    telemetry.addData("LS Direction", "DOWN");
                    robot.linearSlidesMotor1.setPower(-0.25 * gamepad2.left_trigger);
                    robot.linearSlidesMotor2.setPower(-0.25 * gamepad2.left_trigger);
                }
            } else if (gamepad2.right_trigger > 0.1) {
                telemetry.addData("LS Direction", "UP");
                robot.linearSlidesMotor1.setPower(0.5 * gamepad2.right_trigger);
                robot.linearSlidesMotor2.setPower(0.5 * gamepad2.right_trigger);
            } else {
                telemetry.addData("LS Direction", "OFF");
                if (slowRev) {
                    robot.linearSlidesMotor1.setPower(0.07);
                    robot.linearSlidesMotor2.setPower(0.07);
                } else {
                    robot.linearSlidesMotor1.setPower(0);
                    robot.linearSlidesMotor2.setPower(0);
                }
            }
            //Hold Mode
            if (gamepad2.right_bumper) {
                slowRev = true;
            } else if (gamepad2.left_bumper) {
                slowRev = false;
            }
            telemetry.addData("LS Hold Mode", slowRev);
            telemetry.update();

            //Noam Drive

            //If any of the buttons are pressed, do not stop robot, otherwise, stop it
            //FIXES JITTER
            isPressed = false;

            //Trigger, move straight faster
            if(gamepad1.right_trigger > 0.1) {
                robot.moveStraight(regPower);
                isPressed = true;
            }
            else if(gamepad1.left_trigger > 0.1) {
                robot.moveBackwards(regPower);
                isPressed = true;
            }

            //Strafe slow with buttons
            if (gamepad1.x) {
                robot.moveLeft(slowPower);
                isPressed = true;
            }
            else if (gamepad1.y) {
                robot.moveStraight(slowPower);
                isPressed = true;
            }
            else if (gamepad1.a) {
                robot.moveBackwards(slowPower);
                isPressed = true;
            }
            else if (gamepad1.b) {
                robot.moveRight(slowPower);
                isPressed = true;
            }

            //Pivot turn
            robot.pivotTurn(0.9, gamepad1.right_bumper, gamepad1.left_bumper);
            if(gamepad1.right_bumper || gamepad1.left_bumper) {
                isPressed = true;
            }

            //Directional strafing with d pad
            robot.octoStrafe(0.8, gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            if(gamepad1.dpad_up || gamepad1.dpad_down || gamepad1.dpad_left || gamepad1.dpad_right){
                isPressed = true;
            }

            telemetry.update();
            if(!isPressed){
                robot.stop();
            }
        }
    }
}