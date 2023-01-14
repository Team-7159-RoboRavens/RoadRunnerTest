package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompVision.AprilTagDetectionPipeline;
import org.firstinspires.ftc.teamcode.CompVision.SleeveDetection;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import java.util.ArrayList;

import Team7159.ComplexRobots.Christopher;
import Team7159.ComplexRobots.Christwopher;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "AutoLeft (ChrisTWOpher)", group="ChrisTWOpher")
public class AutoLeftChris2 extends LinearOpMode {
    private Christwopher robot = new Christwopher(this);

    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    final double fx = 578.272;
    final double fy = 578.272;
    final double cx = 402.145;
    final double cy = 221.506;
    double tagsize = 0.0254;

    public int lastTag = -1;
    public int location = 1;

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Status", "Initializing...");
        telemetry.update();
        robot.init(hardwareMap);
        telemetry.addData("Status", "Ready");
        telemetry.update();

        // Signal Sleeve
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);
        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(640,480, OpenCvCameraRotation.SIDEWAYS_RIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });
        aprilTagDetectionPipeline.setDecimation(2);
        while (!isStarted()) {
            ArrayList<AprilTagDetection> detections = aprilTagDetectionPipeline.getDetectionsUpdate();
            if(detections != null)
            {
                // If we don't see any tags
                if(detections.size() == 0)
                {
                   telemetry.addLine("No Tags Detected. Using last known tag.");
                }
                // We do see tags!
                else
                {
                    if(detections.size() > 1){
                        //warning, it will take the highest detected tag number
                        telemetry.addLine("--Multiple Tags Detected--");
                    }
                    for(AprilTagDetection detection : detections)
                    {
                        int id = detection.id;
                        //ignore if the tag isn't one on our sleev
                        if(id != 17 && id != 18 && id != 19) {
                            telemetry.addData("INVALID Tag Detected", id);
                            continue;
                        }else{
                            //it is one on our sleeve, set last tag if we lose it
                            lastTag = detection.id;
                            telemetry.addData("Tag Detected", id);
                        }
                    }
                }
                telemetry.addData("Last Tag ID", lastTag);
                //setting parking pos for compatibility
                if(lastTag == 18){
                    location = 2;
                    telemetry.addData("Parking Position", "CENTER");
                }else if(lastTag == 19) {
                    location = 3;
                    telemetry.addData("Parking Position", "RIGHT");
                }else if(lastTag == 17 || lastTag == -1){
                    location = 1;
                    telemetry.addData("Parking Position", "LEFT");
                }
                telemetry.update();
            }
            sleep(20);
        }

        //Actual Auto

        waitForStart();

        telemetry.addData("LBMotor Pos: ", robot.LBMotor.getCurrentPosition());
        telemetry.addData("RBMotor Pos: ", robot.RBMotor.getCurrentPosition());
        telemetry.addData("LFMotor Pos: ", robot.LFMotor.getCurrentPosition());
        telemetry.addData("RFMotor Pos: ", robot.RFMotor.getCurrentPosition());

        telemetry.update();
        //NOTE: DIRECTIONS INVERTED
        robot.turnDegrees(Direction.CLOCKWISE, 90, 0.5);
//        if(location == 1) {
//            robot.moveTiles(Direction.RIGHT, 0.5, 1);
//            while(robot.LBMotor.isBusy()) sleep(20);
//            robot.moveTiles(Direction.BACKWARDS, 0.5, 1.2);
//        }
//        else if(location == 2) {
//            robot.moveTiles(Direction.BACKWARDS, 0.5, 1.2);
//        }
//        else if(location == 3) {
//            robot.moveTiles(Direction.LEFT, 0.5, 1);
//            while(robot.LBMotor.isBusy()) sleep(20);
//            robot.moveTiles(Direction.BACKWARDS, 0.5, 1.2);
//        }

    }


//    // Rotate angle method
//    public void rotate(Direction direction, double power, double inputAngle) throws InterruptedException {
////        double timeTest = 5000;
////        double angleMoved = 510;
//        //time for 90:
//        double angleTime = 750.0;
//        double time = inputAngle * (angleTime / 90.0);
//
//        if(direction == Direction.LEFT) {
//
//            robot.RFMotor.setPower(power);
//            robot.LFMotor.setPower(-power * mult2);
//            robot.RBMotor.setPower(power);
//            robot.LBMotor.setPower(-power * mult2);
//            sleep((long) time);
//            robot.stop();
//        } else if(direction == Direction.RIGHT) {
//            robot.RFMotor.setPower(-power);
//            robot.LFMotor.setPower(power * mult2);
//            robot.RBMotor.setPower(-power);
//            robot.LBMotor.setPower(power * mult2);
//            sleep((long) time);
//            robot.stop();
//        }
//    }
}
