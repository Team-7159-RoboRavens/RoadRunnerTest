package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Noam Krish TeleOp")
public class NoamKrishChristopherTeleOp extends LinearOpMode {

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


    double armPower = 0.5;

    double slowPower = 0.25;
    double regPower = 0.5;

    ElapsedTime et;
    double time1;
    double time2;
    double time3;
    final double servoDelay = 100;
    boolean isPressed = false;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
//        while (robot.armMotor.getCurrentPosition() >= robot.armPosBack) {

//            robot.armMotor.setPower(-1);
//        }
//        robot.armMotor.setPower(0);
//        robot.servoArm2.setPosition(robot.servoPosBack);
//        robot.servoClaw.setPosition(robot.servoClawGrab);




        et = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        time1 = 0;
        time2 = 0;
        time3 = -1;

        robot.armMotor.setPower(-0.5);
        sleep(300);
        robot.armMotor.setPower(0);

        waitForStart();


        while (opModeIsActive()) {
            telemetry.addData("Servo Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm Motor pos: ", robot.armMotor.getCurrentPosition());


            // Krish Arm

            //Preset heights
//            if (gamepad2.x) {
//                if(robot.armMotor.getCurrentPosition() < robot.armPosMid) {
//                    while (robot.armMotor.getCurrentPosition() <= robot.armPosMid) {
//                        robot.armMotor.setPower(armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//                else {
//                    while (robot.armMotor.getCurrentPosition() >= robot.armPosMid) {
//                        robot.armMotor.setPower(-armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//
//                robot.servoArm2.setPosition(robot.servoPosMid);
//            }
//            else if (gamepad2.y) {
//                if(robot.armMotor.getCurrentPosition() < robot.armPosHigh) {
//                    while (robot.armMotor.getCurrentPosition() <= robot.armPosHigh) {
//                        robot.armMotor.setPower(armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//                else {
//                    while (robot.armMotor.getCurrentPosition() >= robot.armPosHigh) {
//                        robot.armMotor.setPower(-armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//
//                robot.servoArm2.setPosition(robot.servoPosHigh);
//            }
//            else if (gamepad2.a) {
//                if(robot.armMotor.getCurrentPosition() < robot.armPosGround) {
//                    while (robot.armMotor.getCurrentPosition() <= robot.armPosGround) {
//                        robot.armMotor.setPower(armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//                else {
//                    while (robot.armMotor.getCurrentPosition() >= robot.armPosGround) {
//                        robot.armMotor.setPower(-armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//
//                robot.servoArm2.setPosition(robot.servoPosGround);
//            }
//            else if (gamepad2.b) {
//                if(robot.armMotor.getCurrentPosition() < robot.armPosLow) {
//                    while (robot.armMotor.getCurrentPosition() <= robot.armPosLow) {
//                        robot.armMotor.setPower(armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//                else {
//                    while (robot.armMotor.getCurrentPosition() >= robot.armPosLow) {
//                        robot.armMotor.setPower(-armPower);
//                    }
//                    robot.armMotor.setPower(0);
//                }
//
//                robot.servoArm2.setPosition(robot.servoPosLow);
//            }
////            else {
////                robot.armMotor.setPower(0);
////            }
//
//            //Set servo claw position
//            if(gamepad2.right_bumper) {
//                robot.servoClaw.setPosition(robot.servoClawOpen);
//            }else if(gamepad2.left_bumper){
//                robot.servoClaw.setPosition(robot.servoClawGrab);
//            }

            //BACKUP, Just set the power
//            if(gamepad2.right_trigger > 0.1) {
//                robot.armMotor.setPower(armPower);
//            }
//            else if(gamepad2.left_trigger > 0.1) {
//                robot.armMotor.setPower(-armPower);
//            }
//            else {
//                robot.armMotor.setPower(0);
//            }


            //If any of the buttons are pressed, do not stop robot, otherwise, stop it
            //FIXES JITTER
            isPressed = false;

            if(gamepad2.left_trigger > 0.1) {
                robot.armMotor.setPower(0.5 * gamepad2.left_trigger);
//                telemetry.addData("Arm Motor Position", () -> robot.armMotor.getCurrentPosition());
//                telemetry.update();
            }
            else if(gamepad2.right_trigger > 0.1) {
                robot.armMotor.setPower(-0.5 * gamepad2.right_trigger);
            }
            else{
                robot.armMotor.setPower(0);
            }

//            if (et.time() - time1 > servoDelay) {
//                if (gamepad2.dpad_up) {
//                    robot.servoArm2.setPosition(robot.servoArm2.getPosition() + 0.05);
//                    time1 = et.time();
////                    telemetry.addData("Arm Servo Position", () -> robot.servoArm2.getPosition());
////                    telemetry.update();
//                } else if (gamepad2.dpad_down) {
//                    robot.servoArm2.setPosition(robot.servoArm2.getPosition() - 0.05);
//                    time1 = et.time();
////                    telemetry.addData("Arm Servo Position", () -> robot.servoArm2.getPosition());
////                    telemetry.update();
//                }
//            }

            if (et.time() - time2 > servoDelay) {
                if (gamepad2.a) {
                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() + 0.05);
                    time2 = et.time();
//                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
//                    telemetry.update();
                } else if (gamepad2.b) {
                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() - 0.05);
                    time2 = et.time();
//                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
//                    telemetry.update();
                }
            }

            //Noam Drive

            //If any of the buttons are pressed, do not stop robot, otherwise, stop it
            //FIXES JITTER


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
//            else {
//                robot.armMotor.setPower(0);
//            }

            //Pivot turn
            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);
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