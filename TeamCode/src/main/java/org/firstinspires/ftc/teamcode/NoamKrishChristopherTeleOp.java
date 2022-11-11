package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="org.firstinspires.ftc.teamcode.NoamKrishChristopherTeleOp")
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

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        double slowPower = 0.25;
        double regPower = 1.0;

        int armPosHigh = 10;
        int armPosMid = 5;
        int armPosLow = 1;
        int armPosGround = 0;

        int servoPosHigh;
        int servoPosMid;
        int servoPosLow;
        int servoPosGround;

        boolean armToggle = false;
        boolean previousRB = false;

        int[] motorArmIntervals = new int[]{};
        int[] servoArmIntervals = new int[]{};

        while (opModeIsActive()) {

            telemetry.addData("Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm velocity: ", robot.armMotor.getCurrentPosition());

            // Noam Drive
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
            else {
                robot.stop();
            }

            if(gamepad1.right_trigger > 0.1) {
                robot.moveStraight(regPower);
            }
            else if(gamepad1.left_trigger > 0.1) {
                robot.moveBackwards(regPower);
            }
            else {
                robot.stop();
            }

            // Krish Arm

            if (gamepad2.x) {
                robot.armMotor.setPower(0.5);
                robot.armMotor.setTargetPosition(armPosMid);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//                robot.servoArm2.setPosition(servoPosMid);
            }
            else if (gamepad2.y) {
                robot.armMotor.setPower(0.5);
                robot.armMotor.setTargetPosition(armPosHigh);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//                robot.servoArm2.setPosition(servoPosMid);
            }
            else if (gamepad2.a) {
                robot.armMotor.setPower(0.5);
                robot.armMotor.setTargetPosition(armPosGround);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//                robot.servoArm2.setPosition(servoPosMid);
            }
            else if (gamepad2.b) {
                robot.armMotor.setPower(0.5);
                robot.armMotor.setTargetPosition(armPosLow);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//                robot.servoArm2.setPosition(servoPosMid);
            }

//            TODO: Add current position thresholds
            if (!armToggle && gamepad2.right_bumper) {
                armToggle = true;
            }
            if (armToggle && gamepad2.right_bumper) {
                armToggle = false;
            }
            if (armToggle) {
                robot.servoClaw.setPosition(1);
            } else {
                robot.servoClaw.setPosition(0);
            }

            if(gamepad2.right_trigger > 0.1) {
                robot.armMotor.setPower(0.5);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
            else if(gamepad2.left_trigger > 0.1) {
                robot.armMotor.setPower(-0.5);
                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }

            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);

            robot.octoStrafe(gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            telemetry.update();

        }
    }
}