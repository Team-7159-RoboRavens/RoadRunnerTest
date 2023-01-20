package org.firstinspires.ftc.teamcode.MagicOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import Team7159.BasicRobots.BasicMecanum2;
import Team7159.ComplexRobots.Christopher;
import Team7159.ComplexRobots.Christwopher;
import Team7159.Enums.Direction;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "MagicAuto", group="ChrisTWOpher")
public class MagicAuto extends LinearOpMode {

    private Christwopher robot = new Christwopher(this);
//    private BasicMecanum2 bm2 =  new BasicMecanum2();
    // strafe(Direction direction, double power, double tiles)

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();



//        robot.LBMotor.setTargetPosition(1000);
//        robot.RBMotor.setTargetPosition(1000);
//        robot.LFMotor.setTargetPosition(1000);
//        robot.RFMotor.setTargetPosition(1000);
//
//        robot.LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//        robot.LBMotor.setPower(0.5);
//        robot.RBMotor.setPower(0.5);
//        robot.LFMotor.setPower(0.5);
//        robot.RFMotor.setPower(0.5);

        robot.moveTiles(Direction.FORWARDS, 0.5, 3);
        sleep(20);
        while(robot.LBMotor.isBusy() && opModeIsActive()){
            sleep(50);
            telemetry.update();
        }
        while(opModeIsActive()){
            telemetry.update();

            telemetry.addData("LBMotor Start Pos: ", () -> robot.LBMotor.getCurrentPosition());
            telemetry.addData("RBMotor Start Pos: ", () -> robot.RBMotor.getCurrentPosition());
            telemetry.addData("LFMotor Start Pos: ", () -> robot.LFMotor.getCurrentPosition());
            telemetry.addData("RFMotor Start Pos: ", () -> robot.RFMotor.getCurrentPosition());
//            telemetry.addData("Power: ", () -> bm2.publicPower);
            telemetry.update();

        }
//        robot.moveTiles(Direction.LEFT, 0.5, 1);
//
//        sleep(10);
//        while(opModeIsActive()){
//            sleep(50);
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
