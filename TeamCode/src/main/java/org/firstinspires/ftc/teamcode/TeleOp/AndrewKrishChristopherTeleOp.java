package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import Team7159.ComplexRobots.Christopher;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Andrew Krish TeleOp (Legacy)", group="Christopher")
public class AndrewKrishChristopherTeleOp extends LinearOpMode {
    private Christopher robot = new Christopher();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        double armPower = 0.5;

        double motorPower;

        double powRX1;
        double powRY1;
        double powLX1;
        double powLY1;

        while (opModeIsActive()) {
            //General Telemetry
//            telemetry.addData("Servo Arm 2 pos: ", robot.servoArm2.getPosition());
            telemetry.addData("Servo Claw pos: ", robot.servoClaw.getPosition());
            telemetry.addData("Arm Motor pos: ", robot.armMotor.getCurrentPosition());

            //Andrew Code
            powRX1 = gamepad1.right_stick_x;
            powRY1 = gamepad1.right_stick_y;
            powLX1= gamepad1.left_stick_x;
            powLY1 = gamepad1.left_stick_y;

            //Use triggers tp determine
            if(powRX1 >= 0.1 || powRX1 <= -0.1) {
                motorPower = (-powRX1) * 0.5;
                robot.RFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);
            } else if(powRY1 >= 0.1 || powRY1 <= -0.1) {
                motorPower = powRY1 * 0.5;
                robot.RFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);
            } else if (powLX1 >= 0.1 || powLX1 <= -0.1) {
                motorPower = (powLX1) * 0.5;
                robot.LFMotor.setPower(motorPower);
                robot.RBMotor.setPower(motorPower);
            } else if(powLY1 >= 0.1 || powLY1 <= -0.1) {
                motorPower = -powLY1 * 0.5;
                robot.LFMotor.setPower(motorPower);
                robot.LBMotor.setPower(motorPower);
            }

            // Krish
            // Krish Arm

            //Preset heights
            if (gamepad2.x) {
                if(robot.armMotor.getCurrentPosition() < robot.armPosMid) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosMid) {
                        robot.armMotor.setPower(armPower);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosMid) {
                        robot.armMotor.setPower(-armPower);
                    }
                    robot.armMotor.setPower(0);
                }

//                robotk.servoArm2.setPosition(robot.servoPosMid);
            }
            else if (gamepad2.y) {
                if(robot.armMotor.getCurrentPosition() < robot.armPosHigh) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosHigh) {
                        robot.armMotor.setPower(armPower);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosHigh) {
                        robot.armMotor.setPower(-armPower);
                    }
                    robot.armMotor.setPower(0);
                }

//                robot.servoArm2.setPosition(robot.servoPosHigh);
            }
            else if (gamepad2.a) {
                if(robot.armMotor.getCurrentPosition() < robot.armPosGround) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosGround) {
                        robot.armMotor.setPower(armPower);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosGround) {
                        robot.armMotor.setPower(-armPower);
                    }
                    robot.armMotor.setPower(0);
                }

//                robot.servoArm2.setPosition(robot.servoPosGround);
            }
            else if (gamepad2.b) {
                if(robot.armMotor.getCurrentPosition() < robot.armPosLow) {
                    while (robot.armMotor.getCurrentPosition() <= robot.armPosLow) {
                        robot.armMotor.setPower(armPower);
                    }
                    robot.armMotor.setPower(0);
                }
                else {
                    while (robot.armMotor.getCurrentPosition() >= robot.armPosLow) {
                        robot.armMotor.setPower(-armPower);
                    }
                    robot.armMotor.setPower(0);
                }

//                robot.servoArm2.setPosition(robot.servoPosLow);
            }
//            else {
//                robot.armMotor.setPower(0);
//            }

            //Set servo claw position
            if(gamepad2.right_bumper) {
                robot.servoClaw.setPosition(robot.servoClawOpen);
            }else if(gamepad2.left_bumper){
                robot.servoClaw.setPosition(robot.servoClawGrab);
            }

            //BACKUP, Just set the power
//            if(gamepad2.right_trigger > 0.1) {
//                robot.armMotor.setPower(0.5);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            }
//            else if(gamepad2.left_trigger > 0.1) {
//                robot.armMotor.setPower(-0.5);
//                robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            }
//            else {
//                robot.armMotor.setPower(0);
//            }

            robot.octoStrafe(1.0, false, false, gamepad1.x, gamepad1.b);
            telemetry.update();
        }
    }
}
