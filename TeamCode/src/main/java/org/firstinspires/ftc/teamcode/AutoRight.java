package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvInternalCamera;

import Team7159.ComplexRobots.Christopher;
import Team7159.Enums.Direction;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "AutoRight")
public class AutoRight extends LinearOpMode {

    private Christopher robot = new Christopher();

    SleeveDetection sleeveDetection = new SleeveDetection();
    OpenCvCamera phoneCam;
    String webcamName = "Webcam 1";
    public int location = 1;

    double power = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);
        sleeveDetection = new SleeveDetection();
        phoneCam.setPipeline(sleeveDetection);

        phoneCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                phoneCam.startStreaming(320,240);
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
        robot.servoClaw.setPosition(robot.servoClawGrab);

        waitForStart();

        rotate(Direction.RIGHT, power, 180);
        rotate(Direction.RIGHT, power, 45);
        robot.armPos(power, robot.armPosGround, robot.servoPosGround);
        robot.servoClaw.setPosition(robot.servoClawOpen);
        rotate(Direction.LEFT, power, 45);
        strafe(Direction.LEFT, power, 1.0);
        rotate(Direction.LEFT, power, 135);
        robot.servoClaw.setPosition(robot.servoClawGrab);
        rotate(Direction.RIGHT, power, 135);

        if(location == 1) {
            strafe(Direction.RIGHT, power, 2);
            strafe(Direction.FORWARDS, power, 1.5);
            rotate(Direction.LEFT, power, 90);
            robot.armPos(power, robot.armPosMid, robot.servoPosMid);
            robot.servoClaw.setPosition(robot.servoClawOpen);
        }
        else if(location == 2) {
            strafe(Direction.RIGHT, power, 1);
            strafe(Direction.FORWARDS, power, 2);
            rotate(Direction.LEFT, power, 45);
            robot.armPos(power, robot.armPosHigh, robot.servoPosHigh);
            robot.servoClaw.setPosition(robot.servoClawOpen);
        }
        else if(location == 3) {
            strafe(Direction.RIGHT, power, 2);
            strafe(Direction.FORWARDS, power, 1.5);
            rotate(Direction.LEFT, power, 90);
            robot.armPos(power, robot.armPosMid, robot.servoPosMid);
            robot.servoClaw.setPosition(robot.servoClawOpen);
        }
    }

    // Tile Version
    public void strafe(Direction direction, double power, double tiles) throws InterruptedException{
        double tileTimeTest = 2000.0;
        double inchesMoved = 50.0;

        double tileTime = ((24 * tiles) * (tileTimeTest / inchesMoved));
        if(direction == Direction.LEFT){
            robot.LFMotor.setPower(-power);
            robot.RFMotor.setPower(power);
            robot.LBMotor.setPower(power);
            robot.RBMotor.setPower(-power -  robot.motorOffset);
            sleep((long) tileTime);
//            sleep((long)tiles * tileTime * (1 / (long) power));
            robot.stop();
        }else if(direction == Direction.RIGHT){
            robot.LFMotor.setPower(power);
            robot.RFMotor.setPower(-power);
            robot.LBMotor.setPower(-power);
            robot. RBMotor.setPower(power +  robot.motorOffset);
            sleep((long) tileTime);
//            sleep((long)tiles * tileTime * (1 / (long) power));
            robot.stop();
        }
        else if(direction == Direction.FORWARDS) {
            robot.LFMotor.setPower(power);
            robot.RFMotor.setPower(power);
            robot.LBMotor.setPower(power);
            robot.RBMotor.setPower(power +  robot.motorOffset);
            sleep((long) tileTime);
//            sleep((long)tiles * tileTime * (1 / (long) power));
            robot.stop();
        }
        else if(direction == Direction.BACKWARDS) {
            robot.LFMotor.setPower(-power);
            robot.RFMotor.setPower(-power);
            robot.LBMotor.setPower(-power);
            robot.RBMotor.setPower(-power -  robot.motorOffset);
            sleep((long) tileTime);
//            sleep((long)tiles * tileTime * (1 / (long) power));
            robot.stop();
        }
        else{
            //Throw an exception
        }
    }

    // Rotate angle method
    public void rotate(Direction direction, double power, double inputAngle) throws InterruptedException {
        double timeTest = 5000;
        double angleMoved = 510;
        double angleTime = (timeTest/angleMoved) * inputAngle;

        if(direction == Direction.LEFT) {
            robot.RFMotor.setPower(-power);
            robot.LFMotor.setPower(power);
            robot.RBMotor.setPower(-power - robot.motorOffset);
            robot.LBMotor.setPower(power);
            sleep((long) angleTime);
            robot.stop();
        } else if(direction == Direction.RIGHT) {
            robot.RFMotor.setPower(power);
            robot.LFMotor.setPower(-power);
            robot.RBMotor.setPower(power + robot.motorOffset);
            robot.LBMotor.setPower(-power);
            sleep((long) angleTime);
            robot.stop();
        }
    }
}
