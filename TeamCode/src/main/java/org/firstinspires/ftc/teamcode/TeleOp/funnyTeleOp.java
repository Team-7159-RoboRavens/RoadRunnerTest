package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import Team7159.ComplexRobots.Christopher;

@TeleOp(name = "funnyTeleOp", group="Christopher Tests")

//This teleop is ~~copyrighted by the 7159 Robotics Team~~ for getting magic numbers for the arm, if we still need those
public class funnyTeleOp extends LinearOpMode {
    private Christopher robot;
    ElapsedTime et;
    double time1;
    double time2;
    double time3;
    final double servoDelay = 200;
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Christopher();
        robot.init(hardwareMap);

        //robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("Arm Motor Position", () -> robot.armMotor.getCurrentPosition());
        telemetry.addData("Arm Motor Power", () -> robot.armMotor.getPower());
//        telemetry.addData("Arm Servo Position", () -> robot.servoArm2.getPosition());
        telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
        telemetry.addData("Button: ", () -> gamepad2.y);
        telemetry.addLine("Ready");
        telemetry.update();
        et = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        time1 = 0;
        time2 = 0;
        time3 = -1;

        robot.armMotor.setPower(-0.5);
        sleep(300);
        robot.armMotor.setPower(0);
        waitForStart();
        while (opModeIsActive()) {
//            if (gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y < -0.1) {
            if(gamepad2.y) {
                robot.armMotor.setPower(0.5);
//                telemetry.addData("Arm Motor Position", () -> robot.armMotor.getCurrentPosition());
//                telemetry.update();
            }
            else if(gamepad2.x) {
                robot.armMotor.setPower(-0.5);
            }
            else {
                robot.armMotor.setPower(0);
            }

            if (et.time() - time1 > servoDelay) {
                if (gamepad1.dpad_up) {
//                    robot.servoArm2.setPosition(robot.servoArm2.getPosition() + 0.05);
                    time1 = et.time();
//                    telemetry.addData("Arm Servo Position", () -> robot.servoArm2.getPosition());
//                    telemetry.update();
                } else if (gamepad1.dpad_down) {
//                    robot.servoArm2.setPosition(robot.servoArm2.getPosition() - 0.05);
                    time1 = et.time();
//                    telemetry.addData("Arm Servo Position", () -> robot.servoArm2.getPosition());
//                    telemetry.update();
                }
            }

            if (et.time() - time2 > servoDelay) {
                if (gamepad1.y) {
                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() + 0.05);
                    time2 = et.time();
//                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
//                    telemetry.update();
                } else if (gamepad1.a) {
                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() - 0.05);
                    time2 = et.time();
//                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
//                    telemetry.update();
                }
            }

//            if(gamepad1.start){
//                if(time3 == -1){
//                    time3 = et.seconds();
//                    telemetry.addLine("Hold Start for 3 seconds to reset Arm Motor encoder");
//                }else if(et.seconds()-time3 > 3){
//                    robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//                    telemetry.addLine("Reset Successfully");
//                    sleep(200);
//                    robot.armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//                    time3=-1;
//                }else{
//                    telemetry.addLine("Hold Start for 3 seconds to reset Arm Motor encoder");
//                }
//            }else{
//                time3=-1;
//            }
            telemetry.update();
        }
    }
}