package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import Team7159.ComplexRobots.Christopher;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "org.firstinspires.ftc.teamcode.AutoBlueLeft")
public class AutoBlueLeft extends LinearOpMode {

    private Christopher robot = new Christopher();

    // strafe(Direction direction, double power, double time (seconds))

    SleeveDetection sleeveDetection = new SleeveDetection();
    OpenCvCamera camera;
    String webcamName = "Webcam 1";
    public int location = 1;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        // Signal Sleeve
        // Rotate Left 45 degrees
        // Drop cone on ground junction
        // Rotate Right 45 degrees
        // Strafe right, rotate right 135 degrees
        // Grab cone (ground junction preset height)
        // Rotate 135 degrees left
        // Location 1: Strafe Left, forward to location one
        // Rotate Right 90 Degrees, place cone on mid junction
        // Location 2: Strafe Left, forward to location 2
        // Rotate 45 degrees right, place cone on high junction
        // Location 3: reverse location 2

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, webcamName), cameraMonitorViewId);
        sleeveDetection = new SleeveDetection();
        camera.setPipeline(sleeveDetection);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(320,240, OpenCvCameraRotation.SIDEWAYS_LEFT);
            }

            @Override
            public void onError(int errorCode) {}
        });

        while (!isStarted()) {
            if(sleeveDetection.getPosition() == SleeveDetection.ParkingPosition.LEFT) {
                location = 1;
            }
            else if (sleeveDetection.getPosition() == SleeveDetection.ParkingPosition.CENTER) {
                location = 2;
            }
            else {
                location = 3;
            }
            telemetry.addData("ROTATION: ", sleeveDetection.getPosition());
            telemetry.update();
        }

        waitForStart();

        

    }
}
