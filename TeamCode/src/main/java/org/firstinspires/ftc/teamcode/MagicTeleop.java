package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Magic Teleop")
public class MagicTeleop extends LinearOpMode {

    private Christopher robot = new Christopher();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();
        double slowPower = 0.25;

//        while(robot.armMotor.getCurrentPosition() <= 60  && opModeIsActive()) {
//            robot.armMotor.setPower(1);
//            telemetry.addData("Motor Arm Pos: ", robot.armMotor.getCurrentPosition());
//            telemetry.update();
//        }
//        robot.armMotor.setPower(0);

        while (opModeIsActive()) {

            telemetry.update();

        }
    }
}