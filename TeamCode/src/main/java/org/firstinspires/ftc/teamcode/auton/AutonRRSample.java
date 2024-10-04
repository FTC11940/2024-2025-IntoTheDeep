package org.firstinspires.ftc.teamcode.auton;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@Autonomous(name = "Auton RR Sample", group = "Autonomous")

public abstract class AutonRRSample extends LinearOpMode {

    private MecanumDrive drive;

    @Override
    public void runOpMode() {
        drive = new MecanumDrive(hardwareMap);
        waitForStart();
    }
}
