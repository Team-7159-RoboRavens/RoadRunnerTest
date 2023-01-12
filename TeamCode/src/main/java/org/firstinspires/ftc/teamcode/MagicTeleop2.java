package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Team7159.ComplexRobots.Christwopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Chris2 Magic Teleop")
public class MagicTeleop2 extends LinearOpMode {

    private Christwopher robot = new Christwopher();

    ElapsedTime et;
    double timeServo;

    final double servoDelay = 100;

    boolean buttonR = false;
    boolean buttonL = false;
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        telemetry.addData("LS Motor 1 Pos:", () -> robot.linearSlidesMotor1.getCurrentPosition());
        telemetry.addData("LS Motor 2 Pos:", () -> robot.linearSlidesMotor2.getCurrentPosition());
//        telemetry.addData("Servo Claw Pos:", () -> robot.servoClaw.getPosition());

        waitForStart();
        double slowPower = 0.25;

//        while(robot.armMotor.getCurrentPosition() <= 60  && opModeIsActive()) {
//            robot.armMotor.setPower(1);
//            telemetry.addData("Motor Arm Pos: ", robot.armMotor.getCurrentPosition());
//            telemetry.update();
//        }
//        robot.armMotor.setPower(0);

        while (opModeIsActive()) {
            if(gamepad1.left_trigger > 0.1){
                if(robot.linearSlidesMotor1.getCurrentPosition() < -10){
                    telemetry.addData("Direction", "INHIBIT DOWN");
                    robot.linearSlidesMotor1.setPower(0);
                    robot.linearSlidesMotor2.setPower(0);
                }else {
                    telemetry.addData("Direction", "DOWN");
                    robot.linearSlidesMotor1.setPower(-0.15);
                    robot.linearSlidesMotor2.setPower(-0.15);
                }
//                robot.linearSlidesMotor2.setPower(-gamepad1.left_trigger);
            }else if(gamepad1.right_trigger > 0.1) {
                telemetry.addData("Direction", "UP");
                robot.linearSlidesMotor1.setPower(0.5 * gamepad1.right_trigger);
                robot.linearSlidesMotor2.setPower(0.5 * gamepad1.right_trigger);
//                robot.linearSlidesMotor2.setPower(gamepad1.right_trigger);
            }else{
                //TODO: find the power so that the slides don't slide down
                telemetry.addData("Direction", "OFF");
                robot.linearSlidesMotor1.setPower(0.07);
                robot.linearSlidesMotor2.setPower(0.07);
            }
//            }else{
//                robot.linearSlidesMotor1.setPower(-0.1);
//                robot.linearSlidesMotor2.setPower(0.1);
//            }

            if(gamepad1.right_bumper){
                if(buttonR){
                    robot.linearSlidesMotor1.setPower(0);
                    buttonR = false;
                } else if (!buttonR){
                    robot.linearSlidesMotor1.setPower(0.05);
                    buttonR = true;
                }

            } else if(gamepad1.left_bumper){
                if(buttonL){
                    robot.linearSlidesMotor2.setPower(0);
                    buttonR = false;
                } else if (!buttonL){
                    robot.linearSlidesMotor2.setPower(0.05);
                    buttonR = true;
                }
            }

            }

//            if (et.time() - timeServo > servoDelay) {
//                if (gamepad2.a) {
//                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() + 0.05);
//                    timeServo = et.time();
////                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
////                    telemetry.update();
//                } else if (gamepad2.b) {
//                    robot.servoClaw.setPosition(robot.servoClaw.getPosition() - 0.05);
//                    timeServo = et.time();
////                    telemetry.addData("Claw Servo Position", () -> robot.servoClaw.getPosition());
////                    telemetry.update();
//                }
//            }
            telemetry.update();
        }
    }