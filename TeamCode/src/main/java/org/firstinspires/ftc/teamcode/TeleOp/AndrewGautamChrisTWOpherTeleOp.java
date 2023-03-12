package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.Christwopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Andrew/Gautam Chris2 TL", group="ChrisTWOpher")
public class AndrewGautamChrisTWOpherTeleOp extends LinearOpMode {

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

    double powRX1;
    double powRY1;
    double powLX1;
    double powLY1;
    double motorPower;

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
                if (gamepad2.a){
                    //OPEN
                    robot.claw.setPosition(robot.servoClawOpen);
                }/*else if (gamepad2.b){
                    //CLOSE
                    robot.claw.setPosition(robot.servoClawGrab);
                }*/ else if (gamepad2.y) {
                    //CLOSE
                    robot.claw.setPosition(robot.claw.getPosition() + 0.05);
                    timeServo = et.time();
                } else if (gamepad2.x) {
                    //OPEN
                    robot.claw.setPosition(robot.claw.getPosition() - 0.05);
                    timeServo = et.time();
                }

            }
            //Linear Slides
            if (gamepad2.left_trigger > 0.1) {
                if (robot.linearSlidesMotor1.getCurrentPosition() < -5 || robot.linearSlidesMotor2.getCurrentPosition() < -5) {
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
                robot.linearSlidesMotor1.setPower(0.8 * gamepad2.right_trigger);
                robot.linearSlidesMotor2.setPower(0.8 * gamepad2.right_trigger);
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


            //DRIVE
            isPressed=false;
            powRX1 = gamepad1.right_stick_x;
            powRY1 = gamepad1.right_stick_y;
            powLX1= gamepad1.left_stick_x;
            powLY1 = gamepad1.left_stick_y;

            //Use triggers tp determine
            if(powRY1 >= 0.1 || powRY1 <= -0.1) {
                isPressed = true;
                motorPower = -powRY1 * 0.5;
                robot.RFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);
            }if(powLY1 >= 0.1 || powLY1 <= -0.1) {
                isPressed=true;
                motorPower = -powLY1 * 0.5;
                robot.LFMotor.setPower(motorPower);
                robot.LBMotor.setPower(motorPower);
            }

            //Directional strafing with x y a b
            if (gamepad1.x) {
                robot.moveLeft(0.4);
                isPressed = true;
            }
            else if (gamepad1.y) {
                robot.moveStraight(0.4);
                isPressed = true;
            }
            else if (gamepad1.a) {
                robot.moveBackwards(0.4);
                isPressed = true;
            }
            else if (gamepad1.b) {
                robot.moveRight(0.4);
                isPressed = true;
            }

            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);
            if(gamepad1.right_bumper || gamepad1.left_bumper) {
                isPressed = true;
            }

            robot.octoStrafe(0.15, gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
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