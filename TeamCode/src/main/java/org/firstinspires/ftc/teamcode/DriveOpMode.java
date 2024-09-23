package org.firstinspires.ftc.teamcode;

/*
 * TEAM: 11940
 * SEASON: 2024-2025 Into the Deep
 * Partially generated with GPT 4
 *
 * */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

// Mecanum Drive
@TeleOp(name = "MecanumDrive", group = "TeleOp")
//@Disabled
public class DriveOpMode extends OpMode {
    private RobotHardware robot;

    @Override
    public void init() {
        robot = new RobotHardware();
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y; // Forward/backward
        double x = gamepad1.left_stick_x * 1.1; // Strafe left/right
        double turn = gamepad1.right_stick_x; // Rotation

        // Calculate motor powers using the MecanumDrivetrain from RobotHardware
        double[] powers = robot.getDrivetrain().calculateMotorPowers(y, x, turn);
        robot.getDrivetrain().setDrivePowers(powers[0], powers[1], powers[2], powers[3]);

        // Telemetry for motor powers
        telemetry.addData("Motors", "FL (%.2f), FR (%.2f), BL (%.2f), BR (%.2f)",
                powers[0], powers[1], powers[2], powers[3]);
        telemetry.update();
    }
}