package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompVision.AprilTagDetectionPipeline;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import java.util.ArrayList;

import Team7159.ComplexRobots.Christwopher;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Auto RIGHT (ChrisTWOpher)", group="ChrisTWOpher")
public class AutoRightChris2 extends LinearOpMode {
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
                telemetry.addLine("**Auto RIGHT is ready**");
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

        waitForStart();
        camera.closeCameraDevice();
        telemetry.addData("Executing Parking Position", location);
        telemetry.update();

        //**ONE CONE AUTO**
        // Setup
        robot.claw.setPosition(robot.servoClawGrab);
        robot.setLinearSlidePosition(0.5, 100);
        robot.moveTiles(Direction.BACKWARDS, 0.2, 0.1);
        sleep(150);
        robot.slowStartSlowStop(Direction.RIGHT, 0.4, 1.2);
        sleep(150);
        robot.slowStartSlowStop(Direction.BACKWARDS, 0.55, 2.0);
        sleep(200);
        //Rotate to align
        robot.rotateDegrees(Direction.LEFT, 187, 0.4);

        //Setup for cone placement
        sleep(200);
        robot.setLinearSlidePosition(0.6, robot.highJunction);
        int target = robot.linearSlidesMotor1.getTargetPosition();
        robot.slowStartSlowStop(Direction.RIGHT, 0.35, 0.49);

        //Wait for slides
        while(!(robot.linearSlidesMotor1.getCurrentPosition() > target-10 && robot.linearSlidesMotor1.getCurrentPosition() < target+10) && opModeIsActive()){
            sleep(20);
        }

        sleep(200);
        robot.slowStartSlowStop(Direction.FORWARDS, 0.3, 0.11);
        sleep(300);
        // Cone placement
        robot.claw.setPosition(robot.servoClawOpen);
        sleep(300);

        //Retreat and turn back
        robot.slowStartSlowStop(Direction.BACKWARDS, 0.3, 0.12);
        robot.setLinearSlidePosition(0.3, 3);
        target = robot.linearSlidesMotor1.getTargetPosition();
//        robot.claw.setPosition(robot.servoClawGrab);
        sleep(200);

        //Park
        if(location == 1) {
            robot.slowStartSlowStop(Direction.LEFT, 0.4, 0.5);
            sleep(150);
            robot.moveTiles(Direction.BACKWARDS, 0.2, 0.1);
        }else if(location == 2){
            robot.slowStartSlowStop(Direction.RIGHT, 0.4, 0.5);
            sleep(150);
            robot.moveTiles(Direction.BACKWARDS, 0.2, 0.1);
        }else if(location == 3) {
            robot.slowStartSlowStop(Direction.RIGHT, 0.5, 1.5);
            sleep(150);
            robot.moveTiles(Direction.BACKWARDS, 0.2, 0.1);
        }

        telemetry.addLine("Auto has completed. Thank you for choosing ChrisTWOpher.");
        telemetry.update();
        sleep(2000);
        while(!(robot.linearSlidesMotor1.getCurrentPosition() > target-10 && robot.linearSlidesMotor1.getCurrentPosition() < target+10) && opModeIsActive()){
            sleep(20);
        }
    }


}
