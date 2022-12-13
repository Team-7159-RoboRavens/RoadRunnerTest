package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import Team7159.ComplexRobots.Christopher;
import Team7159.Enums.Direction;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "MagicAuto")
public class MagicAuto extends LinearOpMode {

    private Christopher robot = new Christopher();
    // strafe(Direction direction, double power, double tiles)

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        telemetry.addData("LBMotor Start Pos: ", robot.LBMotor.getCurrentPosition());
        telemetry.addData("RBMotor Start Pos: ", robot.RBMotor.getCurrentPosition());
        telemetry.addData("LFMotor Start Pos: ", robot.LFMotor.getCurrentPosition());
        telemetry.addData("RFMotor Start Pos: ", robot.RFMotor.getCurrentPosition());

        robot.LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.LBMotor.setTargetPosition(3000);
        robot.RBMotor.setTargetPosition(3000);
        robot.LFMotor.setTargetPosition(3000);
        robot.RFMotor.setTargetPosition(3000);

        robot.LBMotor.setPower(1);
        robot.RBMotor.setPower(1);
        robot.LFMotor.setPower(1);
        robot.RFMotor.setPower(1);

//        sleep(10);
//        while(robot.LBMotor.isBusy()){
//            sleep(20);
//            telemetry.addData("LBMotor  Pos: ", robot.LBMotor.getCurrentPosition());
//            telemetry.addData("RBMotor  Pos: ", robot.RBMotor.getCurrentPosition());
//            telemetry.addData("LFMotor  Pos: ", robot.LFMotor.getCurrentPosition());
//            telemetry.addData("RFMotor  Pos: ", robot.RFMotor.getCurrentPosition());
//            telemetry.update();
//        }
//        telemetry.update();
//        sleep(30000);
//        telemetry.addData("LBMotor End Pos: ", robot.LBMotor.getCurrentPosition());
//        telemetry.addData("RBMotor End Pos: ", robot.RBMotor.getCurrentPosition());
//        telemetry.addData("LFMotor End Pos: ", robot.LFMotor.getCurrentPosition());
//        telemetry.addData("RFMotor End Pos: ", robot.RFMotor.getCurrentPosition());
//        telemetry.update();
//        //test sideways strafing to see if there is a difference.
//        robot.LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        robot.LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        robot.LBMotor.setTargetPosition(2000);
//        robot.RBMotor.setTargetPosition(2000);
//        robot.LFMotor.setTargetPosition(2000);
//        robot.RFMotor.setTargetPosition(2000);
//
//        robot.LFMotor.setPower(-1 * robot.mult);
//        robot.RFMotor.setPower(1);
//        robot.LBMotor.setPower(1 * robot.mult);
//        robot.RBMotor.setPower(-1);
//        while(robot.LBMotor.isBusy()){
//            sleep(10);
//            telemetry.addData("LBMotor  Pos: ", robot.LBMotor.getCurrentPosition());
//            telemetry.addData("RBMotor  Pos: ", robot.RBMotor.getCurrentPosition());
//            telemetry.addData("LFMotor  Pos: ", robot.LFMotor.getCurrentPosition());
//            telemetry.addData("RFMotor  Pos: ", robot.RFMotor.getCurrentPosition());
//            telemetry.update();
//        }
//        telemetry.addData("LBMotor End Pos: ", robot.LBMotor.getCurrentPosition());
//        telemetry.addData("RBMotor End Pos: ", robot.RBMotor.getCurrentPosition());
//        telemetry.addData("LFMotor End Pos: ", robot.LFMotor.getCurrentPosition());
//        telemetry.addData("RFMotor End Pos: ", robot.RFMotor.getCurrentPosition());
//        telemetry.update();
    }
}
