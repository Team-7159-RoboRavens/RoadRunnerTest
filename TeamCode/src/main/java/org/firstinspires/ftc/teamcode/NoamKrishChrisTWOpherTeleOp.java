package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.ChrisTWOpher;
import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Test TeleOp (drives like Noam's)", group = "ChrisTWOpher Certified OpModes")
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

    private ChrisTWOpher robot = new ChrisTWOpher();

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
        et = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        time1 = 0;
        time2 = 0;
        time3 = -1;
        waitForStart();

        while (opModeIsActive()) {

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