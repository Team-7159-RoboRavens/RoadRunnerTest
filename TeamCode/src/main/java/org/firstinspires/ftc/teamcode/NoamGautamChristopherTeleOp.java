package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Noam Gautam TeleOp")
public class NoamGautamChristopherTeleOp extends LinearOpMode {

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
        double regPower = 0.5;

        boolean isPressed;

        while (opModeIsActive()) {

            telemetry.addData("Servo Arm 2 pos: ", robot.servoArm2.getPosition());
            telemetry.addData("Servo Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm Motor pos: ", robot.armMotor.getCurrentPosition());

            //Gautam Teleop

            //Use triggers tp determine
            //arm up
            //TODO: figure out which direction is positive and change the multiplication
            if(gamepad2.left_stick_x > 0.1 || gamepad2.left_stick_x < 0.1 || gamepad2.left_stick_y > 0.1 || gamepad2.left_stick_y < 0.1){
                robot.armMotor.setPower(Math.max(Math.abs(gamepad2.left_stick_x), Math.abs(gamepad2.left_stick_y))*-0.5);
            }else{
                robot.armMotor.setPower(0);
            }
            //arm down
            if(gamepad2.right_stick_x > 0.1 || gamepad2.right_stick_x < 0.1 || gamepad2.right_stick_y > 0.1 || gamepad2.right_stick_y < 0.1) {
                robot.armMotor.setPower(Math.max(Math.abs(gamepad2.right_stick_x), Math.abs(gamepad2.right_stick_y)) * 0.5);
            }else {
                robot.armMotor.setPower(0);
            }

            if(gamepad2.right_bumper) {
                robot.servoClaw.setPosition(robot.servoClawOpen);
            }else if(gamepad2.left_bumper){
                robot.servoClaw.setPosition(robot.servoClawGrab);
            }

            // Noam Drive

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
            robot.pivotTurn(1, gamepad1.right_bumper, gamepad1.left_bumper);
            if(gamepad1.right_bumper || gamepad1.left_bumper) {
                isPressed = true;
            }

            //Directional strafing with d pad
            robot.octoStrafe(1.0, gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
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