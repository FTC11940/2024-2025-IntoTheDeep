package org.firstinspires.ftc.teamcode.auton;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;

// Non-RR imports
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "Auton RR Sample", group = "Autonomous")

public class AutonRRSample extends LinearOpMode {

    private MecanumDrive drive;

    private Pose2d pose = new Pose2d(0, 0, 0);

    @Override
    public void runOpMode() {
        drive = new MecanumDrive(hardwareMap pose);
        waitForStart();
    }
}
