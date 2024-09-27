package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Drive in Square", group = "Autonomous")

public class SquareDrive extends LinearOpMode {

@Override
public void runOpMode() {
    Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(0));
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

    TrajectoryActionBuilder actionOne = drive.actionBuilder(initialPose)
            .lineToXSplineHeading(0.0, 0)
            .lineToYSplineHeading(0.0, 0)
            .lineToXSplineHeading(0.0, 0)
            .lineToYSplineHeading(0.0, 0);
    }

//        waitForStart();

//        if (isStopRequested) return

//                drive.followTrajectory(trajectory);
//    }
}