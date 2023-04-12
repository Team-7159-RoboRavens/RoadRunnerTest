package org.firstinspires.ftc.teamcode.MagicOpmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import Team7159.ComplexRobots.Christwopher;
import Team7159.Enums.Direction;

@Autonomous(name = "TestTheDashMoment", group="ChrisTWOpher")
@Config
public class TestDash extends LinearOpMode {

    private Christwopher robot = new Christwopher(this);
//    private BasicMecanum2 bm2 =  new BasicMecanum2();
    // strafe(Direction direction, double power, double tiles)
    FtcDashboard dash = FtcDashboard.getInstance();
    public static int num = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        int x = 0;
        while(opModeIsActive()){
            TelemetryPacket tp = new TelemetryPacket();
            tp.put("hello", x);
            dash.sendTelemetryPacket(tp);
            telemetry.addData("num", num);
            telemetry.update();
            x++;
            sleep(1000);
        }

    }
}
