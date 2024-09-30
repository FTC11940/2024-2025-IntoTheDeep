package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Drive in Square", group = "Autonomous")

public class SquareDrive extends LinearOpMode {

@Override
public void runOpMode() {
    Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(0));
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

    TrajectoryActionBuilder actionOne = drive.actionBuilder(initialPose)
            .lineToXSplineHeading(10.0, 0);
    }

        waitForStart();

        if (isStopRequested) return

                drive.followTrajectory(trajectory);
    }
}