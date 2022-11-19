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
            telemetry.addData("Motor Arm Pos: ", robot.armMotor.getCurrentPosition());
//            telemetry.addData("Claw Servo Pos: ", robot.servoClaw.getPosition());

//            addData("Servo Arm 2 Pos: ", robot.servoArm2.getPosition());


//            robot.moveStraight(0.5);
//            sleep(1000);
//            robot.stop();
//

//            if(gamepad1.right_trigger > 0.1) {
//                robot.armMotor.setPower(0.2);
//            }
//            else {
//                robot.armMotor.setPower(0);
//            }

//            telemetry.addData("Motor Arm Pos: ", robot.armMotor.getCurrentPosition());
//
//            sleep(2000);
//
//            sleep(2000);
            robot.servoArm2.setPosition(0.5);
            telemetry.addData("Servo Arm Pos: ", robot.servoArm2.getPosition());
            sleep(2000);





//            sleep(2000);
//
//            robot.armMotor.setPower(1);
//            sleep(2000);
//            robot.armMotor.setPower(0);

            //robot.armMotor.setPower(0.2);

//
//            sleep(2000);
//
//            robot.armMotor.setPower(0.2);
//            robot.armMotor.setTargetPosition(370);
//            robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            sleep(2000);
//
//            robot.armMotor.setPower(0.2);
//            robot.armMotor.setTargetPosition(528);
//            robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            sleep(2000);
//
//            robot.armMotor.setPower(0.2);
//            robot.armMotor.setTargetPosition(723);
//            robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            sleep(2000);
//
//            robot.armMotor.setPower(0.2);
//            robot.armMotor.setTargetPosition(0);
//            robot.armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//            if (gamepad1.x) {
//                robot.moveLeft(slowPower);
//            }
//            else if (gamepad1.y) {
//                robot.moveStraight(slowPower);
//            }
//            else if (gamepad1.a) {
//                robot.moveBackwards(slowPower);
//            }
//            else if (gamepad1.b) {
//                robot.moveRight(slowPower);
//            }
//            else {
//                robot.stop();
//            }

            telemetry.update();

        }
    }
}