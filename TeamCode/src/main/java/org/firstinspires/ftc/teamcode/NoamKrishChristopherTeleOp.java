package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

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
    boolean isPressed = false;
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
//        while (robot.armMotor.getCurrentPosition() >= robot.armPosBack) {
//            robot.armMotor.setPower(1);
//        }
//        robot.armMotor.setPower(0);
//        robot.servoArm2.setPosition(robot.seroPosBack);
//        robot.servoClaw.setPosition(robot.servoClawClose);

        waitForStart();

        double slowPower = 1.0;
        double regPower = 1.0;

        while (opModeIsActive()) {
            telemetry.addData("Servo Arm 2 pos: ", robot.servoArm2.getPosition());
            telemetry.addData("Servo Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm Motor pos: ", robot.armMotor.getCurrentPosition());



            // Noam Drive
//            if (gamepad1.x) {
//                robot.moveLeft(slowPower);
//            }
//            else if (gamepad1.y) {
//                robot.moveStraight(slowPower);
//            }
//            else if (gamepad1.a) {
//                robot.moveBackwards(slowPower);
//            }
//            else if (gamepad1.b) {
//                robot.moveRight(slowPower);
//            }
//            else {
//                robot.stop();
//            }


            // Krish Arm

            if (gamepad2.x) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setTargetPosition(robot.armPosMid);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if(robot.armMotor.getCurrentPosition() < robot.armPosMid) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosMid) {
                        robot.armMotor.setPower(1);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosMid) {
                        robot.armMotor.setPower(-1);
                    }
                    robot.armMotor.setPower(0);
                }

                robot.servoArm2.setPosition(robot.servoPosMid);
            }
            else if (gamepad2.y) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setTargetPosition(robot.armPosHigh);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if(robot.armMotor.getCurrentPosition() < robot.armPosHigh) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosHigh) {
                        robot.armMotor.setPower(1);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosHigh) {
                        robot.armMotor.setPower(-1);
                    }
                    robot.armMotor.setPower(0);
                }

                robot.servoArm2.setPosition(robot.servoPosHigh);
            }
            else if (gamepad2.a) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setTargetPosition(robot.armPosGround);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if(robot.armMotor.getCurrentPosition() < robot.armPosGround) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosGround) {
                        robot.armMotor.setPower(1);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosGround) {
                        robot.armMotor.setPower(-1);
                    }
                    robot.armMotor.setPower(0);
                }

                robot.servoArm2.setPosition(robot.servoPosGround);
            }
            else if (gamepad2.b) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setTargetPosition(robot.armPosLow);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if(robot.armMotor.getCurrentPosition() < robot.armPosLow) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosLow) {
                        robot.armMotor.setPower(1);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosLow) {
                        robot.armMotor.setPower(-1);
                    }
                    robot.armMotor.setPower(0);
                }

                robot.servoArm2.setPosition(robot.servoPosLow);
            }
//            else {
//                robot.armMotor.setPower(0);
//            }

            if(gamepad2.right_bumper) {
                robot.servoClaw.setPosition(robot.servoClawOpen);
            }else if(gamepad2.left_bumper){
                robot.servoClaw.setPosition(robot.servoClawGrab);
            }

//            if(gamepad2.right_trigger > 0.1) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            }
//            else if(gamepad2.left_trigger > 0.1) {
//                robot.armMotor.setPower(-0.5);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            }
//            else {
//                robot.armMotor.setPower(0);
//            }
            isPressed=false;
            if(gamepad1.right_trigger > 0.1) {
                robot.moveStraight(regPower);
                isPressed = true;
            }
            else if(gamepad1.left_trigger > 0.1) {
                robot.moveBackwards(regPower);
                isPressed = true;
            }


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


            //robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);
            telemetry.addData("Motor RF Power: ", robot.RFMotor.getPower());
            telemetry.addData("Motor RB Power: ", robot.RBMotor.getPower());
            telemetry.addData("Motor LF Power: ", robot.LFMotor.getPower());
            telemetry.addData("Motor LB Power: ", robot.LBMotor.getPower());

            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            if(gamepad1.dpad_up || gamepad1.dpad_down || gamepad1.dpad_left || gamepad1.dpad_right){
                isPressed=true;
            }
            telemetry.update();
            if(!isPressed){
                robot.stop();
            }
        }
    }
}