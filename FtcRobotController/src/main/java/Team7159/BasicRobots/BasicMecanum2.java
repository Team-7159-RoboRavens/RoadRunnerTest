//package Team7159.BasicRobots;
//
//import com.arcrobotics.ftclib.hardware.motors.*;
//
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import Team7159.Enums.Direction;
//
//public class BasicMecanum {
//
//    public Motor RFMotor;
//    public Motor RBMotor;
//    public Motor LFMotor;
//    public Motor LBMotor;
//
//    public void init(HardwareMap Map) {
//
//        LFMotor = new Motor(Map, "FLDrive");
//        LBMotor = new Motor(Map, "BLDrive");
//        RFMotor = new Motor(Map, "FRDrive");
//        RBMotor = new Motor(Map, "BRDrive");
//
//        RFMotor.set(0.0);
//        RBMotor.set(0.0);
//        LFMotor.set(0.0);
//        LBMotor.set(0.0);
//
//        //TODO: Figure out which motors need to be reversed, etc. so that the robot actually goes forward lmao
//        LFMotor.setInverted(true);
//        RFMotor.setInverted(true);
//        LBMotor.setInverted(true);
//        RBMotor.setInverted(true);
//
//        //for now, we do this (maybe change later-
//        LFMotor.setRunMode(Motor.RunMode.RawPower);
//        RFMotor.setRunMode(Motor.RunMode.RawPower);
//        LBMotor.setRunMode(Motor.RunMode.RawPower);
//        RBMotor.setRunMode(Motor.RunMode.RawPower);
//
//        LFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        RFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        LBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        RBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
//        //:crab: william is gone :crab:
//    }
//
//    public void moveStraight(double power) {
//        LFMotor.set(power);
//        RFMotor.set(power);
//        LBMotor.set(power);
//        RBMotor.set(power);
//    }
//
//    //public void pivotTurnLeft(boolean on, double accel) {
//    //    if(on) {
//    //        LFMotor.set(10);
//    //        LBMotor.set(10);
//    //    }
//    //}
//
//    //public void pivotTurnRight(boolean on, double accel) {
//    //    if(on) {
//    //        RFMotor.set(10);
//    //        RBMotor.set(10);
//    //    }
//    //}
//
//    public void stop() {
//        LFMotor.set(0);
//        RFMotor.set(0);
//        LBMotor.set(0);
//        RBMotor.set(0);
//    }
//
//    public void strafe(Direction direction, double power, double time) throws InterruptedException{
//        if(direction == Direction.LEFT){
//            LFMotor.set(-power);
//            RFMotor.set(power);
//            LBMotor.set(power);
//            RBMotor.set(-power);
//            wait((int)time * 1000);
//            stop();
//        }else if(direction == Direction.RIGHT){
//            LFMotor.set(power);
//            RFMotor.set(-power);
//            LBMotor.set(-power);
//            RBMotor.set(power);
//            wait((int)time * 1000);
//            stop();
//        }else{
//            //Throw an exception
//        }
//    }
//
//    public void pivotTurn(double power, boolean rightBumper, boolean leftBumper) {
//        power = power*2;
//        if(rightBumper && leftBumper) {
//            RFMotor.set(0);
//            LFMotor.set(0);
//            RBMotor.set(0);
//            LBMotor.set(0);
//        } else if(leftBumper) {
//            RFMotor.set(-power);
//            LFMotor.set(power);
//            RBMotor.set(-power);
//            LBMotor.set(power);
//        } else if(rightBumper) {
//            RFMotor.set(power);
//            LFMotor.set(-power);
//            RBMotor.set(power);
//            LBMotor.set(-power);
//        }
//
//
//    }
//
//    public void octoStrafe(boolean up, boolean down, boolean left, boolean right) {
//        if (up) {
//            if (right) {
//                RFMotor.set(1);
//                LFMotor.set(0);
//                RBMotor.set(0);
//                LBMotor.set(1);
//            } else if (left) {
//                RFMotor.set(0);
//                LFMotor.set(1);
//                RBMotor.set(1);
//                LBMotor.set(0);
//            } else {
//                RFMotor.set(1);
//                LFMotor.set(1);
//                RBMotor.set(1);
//                LBMotor.set(1);
//            }
//        } else if (down) {
//            if (right) {
//                RFMotor.set(0);
//                LFMotor.set(-1);
//                RBMotor.set(-1);
//                LBMotor.set(0);
//            } else if (left) {
//                RFMotor.set(-1);
//                LFMotor.set(0);
//                RBMotor.set(0);
//                LBMotor.set(-1);
//            } else {
//                RFMotor.set(-1);
//                LFMotor.set(-1);
//                RBMotor.set(-1);
//                LBMotor.set(-1);
//            }
//        }
//        else {
//            if (right) {
//                RFMotor.set(1);
//                LFMotor.set(-1);
//                RBMotor.set(-1);
//                LBMotor.set(1);
//            } else if (left) {
//                RFMotor.set(-1);
//                LFMotor.set(1);
//                RBMotor.set(1);
//                LBMotor.set(-1);
//            }
//        }
//    }
//}




/*TODO: Attempt at fixing BasicMecanum with backwards evolution*/

package Team7159.BasicRobots;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.Enums.Direction;

public class BasicMecanum2 {

    public DcMotor RFMotor;
    public DcMotor RBMotor;
    public DcMotor LFMotor;
    public DcMotor LBMotor;

    public double publicPower = -1;


    public void init(HardwareMap Map) {

        LFMotor = Map.dcMotor.get("LFMotor");
        LBMotor = Map.dcMotor.get("LBMotor");
        RFMotor = Map.dcMotor.get("RFMotor");
        RBMotor = Map.dcMotor.get("RBMotor");

        LFMotor.setPower(0.0);
        LBMotor.setPower(0.0);
        RFMotor.setPower(0.0);
        RBMotor.setPower(0.0);

        //TODO: Figure out which motors need to be reversed, etc. so that the robot actually goes forward lmao
        LFMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.FORWARD);
        LBMotor.setDirection(DcMotor.Direction.REVERSE);
        RBMotor.setDirection(DcMotor.Direction.FORWARD);

        //for now, we do this (maybe change later-
//        LFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        RFMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        LBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        RBMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

//
        LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        LFMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RFMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LBMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RBMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //:crab: william is gone :crab:
    }

    public void moveStraight(double power) {
        LFMotor.setPower(power);
        RFMotor.setPower(power);
        LBMotor.setPower(power);
        RBMotor.setPower(power);
    }

//    Adding this for now

    public void moveLeft(double power) {
        LFMotor.setPower(-power);
        RFMotor.setPower(power);
        LBMotor.setPower(power);
        RBMotor.setPower(-power);
    }

    public void moveRight(double power) {
        LFMotor.setPower(power);
        RFMotor.setPower(-power);
        LBMotor.setPower(-power);
        RBMotor.setPower(power);
    }

    public void moveBackwards(double power) {
        LFMotor.setPower(-power);
        RFMotor.setPower(-power);
        LBMotor.setPower(-power);
        RBMotor.setPower(-power);
    }

    public void stop() {
        LFMotor.setPower(0);
        RFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
    }

    public void pivotTurn(double power, boolean rightBumper, boolean leftBumper) {
        power = power*0.5;
        if(rightBumper && leftBumper) {
            RFMotor.setPower(0);
            LFMotor.setPower(0);
            RBMotor.setPower(0);
            LBMotor.setPower(0);
        } else if(leftBumper) {
            RFMotor.setPower(power);
            LFMotor.setPower(-power);
            RBMotor.setPower(power);
            LBMotor.setPower(-power);
        } else if(rightBumper) {
            RFMotor.setPower(-power);
            LFMotor.setPower(power);
            RBMotor.setPower(-power);
            LBMotor.setPower(power);
        }
    }

    public void moveTiles(Direction direction, double power, double tiles) {
        int ticksExperimental = 1015;
        int ticksStrafe = 1060;


        if(direction == Direction.LEFT){
            int ticks = (int) (ticksStrafe * tiles);
            LFMotor.setTargetPosition(LFMotor.getCurrentPosition() - ticksStrafe);
            RFMotor.setTargetPosition(RFMotor.getCurrentPosition() + ticksStrafe);
            LBMotor.setTargetPosition(LBMotor.getCurrentPosition() + ticksStrafe);
            RBMotor.setTargetPosition(RBMotor.getCurrentPosition() - ticksStrafe);

            LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LFMotor.setPower(-power);

            RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RFMotor.setPower(power);

            LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LBMotor.setPower(power);

            RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RBMotor.setPower(-power);

        }else if(direction == Direction.RIGHT){
            int ticks = (int) (ticksStrafe * tiles);
            LFMotor.setTargetPosition(LFMotor.getCurrentPosition() + ticksStrafe);
            RFMotor.setTargetPosition(RFMotor.getCurrentPosition() - ticksStrafe);
            LBMotor.setTargetPosition(LBMotor.getCurrentPosition() - ticksStrafe);
            RBMotor.setTargetPosition(RBMotor.getCurrentPosition() + ticksStrafe);

            LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LFMotor.setPower(power);

            RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RFMotor.setPower(-power);

            LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LBMotor.setPower(-power);

            RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RBMotor.setPower(power);

        }
        else if(direction == Direction.FORWARDS) {
            int ticks = (int) (ticksExperimental * tiles);
            LFMotor.setTargetPosition(LFMotor.getCurrentPosition() + ticks);
            RFMotor.setTargetPosition(RFMotor.getCurrentPosition() + ticks);
            LBMotor.setTargetPosition(LBMotor.getCurrentPosition() + ticks);
            RBMotor.setTargetPosition(RBMotor.getCurrentPosition() + ticks);

            LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LFMotor.setPower(power);

            RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RFMotor.setPower(power);

            LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LBMotor.setPower(power);

            RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RBMotor.setPower(power);

            int lfOrigin = LFMotor.getCurrentPosition();
            int rfOrigin = RFMotor.getCurrentPosition();
            int lbOrigin = LBMotor.getCurrentPosition();
            int rbOrigin = RBMotor.getCurrentPosition();

            int lfEnd = LFMotor.getCurrentPosition() + ticks;
            int rfEnd = RFMotor.getCurrentPosition() + ticks;
            int lbEnd = LBMotor.getCurrentPosition() + ticks;
            int rbEnd = RBMotor.getCurrentPosition() + ticks;

//            TODO: Test slow stop
//            int minusTicks = 100;
//            while(power >= .1 && LFMotor.getCurrentPosition() < lfOrigin) {
//                if (LFMotor.getCurrentPosition() >= (lfOrigin - minusTicks) && RFMotor.getCurrentPosition() >= (rfOrigin - minusTicks) && LBMotor.getCurrentPosition() >= (lbOrigin - minusTicks) && RBMotor.getCurrentPosition() >= (rbOrigin - minusTicks)) {
//                    power = power * 0.5;
//
//                    LFMotor.setPower(power);
//                    RFMotor.setPower(power);
//                    LBMotor.setPower(power);
//                    RBMotor.setPower(power);
//
//                    minusTicks -= 20;
//                }
//                else {
//                    LFMotor.setPower(power);
//                    RFMotor.setPower(power);
//                    LBMotor.setPower(power);
//                    RBMotor.setPower(power);
//                }
//            }
//            LFMotor.setPower(0);
//            RFMotor.setPower(0);
//            LBMotor.setPower(0);
//            RBMotor.setPower(0);

            double slope = (0-power)/((ticksExperimental)-0);
            double b = power;
            double stupidMe = lfEnd - ticksExperimental;

            while(power >= 0.01 && ((LFMotor.getCurrentPosition() > lfEnd + 20) || (LFMotor.getCurrentPosition() < lfEnd - 20))){

                int avgCurr = (int) ((LFMotor.getCurrentPosition()+RFMotor.getCurrentPosition()+LBMotor.getCurrentPosition()+RBMotor.getCurrentPosition())/4);
                if(avgCurr >= stupidMe){


                    // double z = (9928 - ((Math.floor(avgCurr / w)) * 1010));
                    power = Math.sin(Math.PI * ((avgCurr-stupidMe)/(lfEnd-stupidMe)));

                    if(power > b) power = b;
                    if(power < 0.1) {
                        if(power < 0.01) {
                            power=0;
                            publicPower = power;
                            return;
                        }
                        else power = 0.1;
                    }
                    publicPower = power;
                    LFMotor.setPower(power);
                    RFMotor.setPower(power);
                    LBMotor.setPower(power);
                    RBMotor.setPower(power);
                }else{
                    power = b;
                }
                System.out.println("Power: " + power);
                System.out.println();
            }
            LFMotor.setPower(0);
            RFMotor.setPower(0);
            LBMotor.setPower(0);
            RBMotor.setPower(0);

        }
        else if(direction == Direction.BACKWARDS) {
            int ticks = (int) (ticksExperimental * tiles);
            LFMotor.setTargetPosition(LFMotor.getCurrentPosition() - ticks);
            RFMotor.setTargetPosition(RFMotor.getCurrentPosition() - ticks);
            LBMotor.setTargetPosition(LBMotor.getCurrentPosition() - ticks);
            RBMotor.setTargetPosition(RBMotor.getCurrentPosition() - ticks);

            LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LFMotor.setPower(-power);

            RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RFMotor.setPower(-power);

            LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LBMotor.setPower(-power);

            RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RBMotor.setPower(-power);
        }
        else{
            //Throw an exception
        }

    }

    public void octoStrafe(double power, boolean up, boolean down, boolean left, boolean right) {
        if (up) {
            if (right) {
                RFMotor.setPower(power);
                LFMotor.setPower(0);
                RBMotor.setPower(0);
                LBMotor.setPower(power);
            } else if (left) {
                RFMotor.setPower(0);
                LFMotor.setPower(power);
                RBMotor.setPower(power);
                LBMotor.setPower(0);
            } else {
                RFMotor.setPower(power);
                LFMotor.setPower(power);
                RBMotor.setPower(power);
                LBMotor.setPower(power);
            }
        } else if (down) {
            if (right) {
                RFMotor.setPower(0);
                LFMotor.setPower(-power);
                RBMotor.setPower(-power);
                LBMotor.setPower(0);
            } else if (left) {
                RFMotor.setPower(-power);
                LFMotor.setPower(0);
                RBMotor.setPower(0);
                LBMotor.setPower(-power);
            } else {
                RFMotor.setPower(-1);
                LFMotor.setPower(-power);
                RBMotor.setPower(-1);
                LBMotor.setPower(-power);
            }
        }
        else {
            if (right) {
                RFMotor.setPower(-power);
                LFMotor.setPower(power);
                RBMotor.setPower(power);
                LBMotor.setPower(-power);
            } else if (left) {
                RFMotor.setPower(power);
                LFMotor.setPower(-power);
                RBMotor.setPower(-power);
                LBMotor.setPower(power);
            }
        }
    }

    private void slowStop() {

    }
}

