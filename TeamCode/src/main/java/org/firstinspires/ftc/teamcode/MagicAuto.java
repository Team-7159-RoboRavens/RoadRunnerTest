package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import Team7159.ComplexRobots.Christopher;
import Team7159.Enums.Direction;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "MagicAuto")
public class MagicAuto extends LinearOpMode {

    private Christopher robot = new Christopher();
    // strafe(Direction direction, double power, double tiles)

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        robot.strafeBruh(Direction.FORWARDS, 0.4);
        sleep(2000);
        robot.stop();
        robot.rotateBruh(Direction.LEFT, 0.4);
        sleep(2000);
        robot.stop();

    }
}
