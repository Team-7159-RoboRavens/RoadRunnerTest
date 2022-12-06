package org.firstinspires.ftc.teamcode;
/*
    Gamepad 1
        X - Strafe left
        B - Strafe Right
        Left Joystick - Power right side
        Right Joystick - Power left side
    Gamepad 2
        Right Joystick - Arm Down(no matter what direction)
        Left Joystick - Arm Up(no matter what direction)
        Right Bumper - Open claw
        Left Bumper - close claw
     */

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Andrew Gautam TeleOp")
public class AndrewD_GautamA extends LinearOpMode {

    private final Christopher robot = new Christopher();

    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        double motorPower;

        double powRX1;
        double powRY1;
        double powLX1;
        double powLY1;


        while (opModeIsActive()) {
            //General Telemetry
            telemetry.addData("Servo Arm 2 pos: ", robot.servoArm2.getPosition());
            telemetry.addData("Servo Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm Motor pos: ", robot.armMotor.getCurrentPosition());

            //Andrew Code
            powRX1 = gamepad1.right_stick_x;
            powRY1 = gamepad1.right_stick_y;
            powLX1= gamepad1.left_stick_x;
            powLY1 = gamepad1.left_stick_y;

            //Use triggers tp determine
            if(powRX1 >= 0.1 || powRX1 <= -0.1) {
                motorPower = (-powRX1) * 0.5;
                robot.RFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);

            } else if(powRY1 >= 0.1 || powRY1 <= -0.1) {
                motorPower = powRY1 * 0.5;
                robot.RFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);

            } else if (powLX1 >= 0.1 || powLX1 <= -0.1) {
                motorPower = (powLX1) * 0.5;
                robot.LFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);

            } else if(powLY1 >= 0.1 || powLY1 <= -0.1) {
                motorPower = -powLY1 * 0.5;
                robot.LFMotor.setPower(motorPower);
                robot.LBMotor.setPower(motorPower);
            }
            else {
                robot.stop();
            }


            // Gautam code

            //arm up
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

            //Servo claw pos
            if(gamepad2.right_bumper) {
                robot.servoClaw.setPosition(robot.servoClawOpen);
            }else if(gamepad2.left_bumper){
                robot.servoClaw.setPosition(robot.servoClawGrab);
            }

            //Strafe
            robot.octoStrafe(1.0, false, false, gamepad1.x, gamepad1.b);

            telemetry.update();
        }


    }
}