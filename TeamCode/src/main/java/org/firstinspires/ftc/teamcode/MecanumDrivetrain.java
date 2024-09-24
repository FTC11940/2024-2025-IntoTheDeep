package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class MecanumDrivetrain {
    // Motor declarations
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private IMU imu;

    // Constructor
    public MecanumDrivetrain() {
        // Constructor should remain simple
    }

    // Initialize motors and IMU
    public void init(HardwareMap hardwareMap) {
        // Initialize IMU
        imu = hardwareMap.get(IMU.class, "imu");

        // Initialize IMU parameters with orientation information
        IMU.Parameters parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
                )
        );

        // Initialize IMU with these parameters
        imu.initialize(parameters);

        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        // Reverse the right side motors to match hardware orientation
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    // Method to set motor powers
    public void setDrivePowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    // Method to calculate and normalize motor powers for Mecanum drive
    public double[] calculateMotorPowers(double y, double x, double turn) {
        double frontLeftPower = y + x + turn;
        double frontRightPower = y - x - turn;
        double backLeftPower = y - x + turn;
        double backRightPower = y + x - turn;

        // Normalize powers so no values exceed 1.0
        double max = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(frontRightPower),
                Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));
        if (max > 1.0) {
            frontLeftPower /= max;
            frontRightPower /= max;
            backLeftPower /= max;
            backRightPower /= max;
        }

        return new double[]{frontLeftPower, frontRightPower, backLeftPower, backRightPower};
    }
}
