package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="MecanumTeleOp", group="TeleOp")
public class MecanumV2 extends OpMode {
    // Motor declarations
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private IMU imu;

    // Initialize once OpMode is started
    @Override
    public void init() {
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

        
        // IMU is calibrated
        telemetry.addData("IMU Status", "Calibrated");
        telemetry.update();

        // Initialize motors
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        // Reverse the right side motors to match hardware orientation
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    // Main control loop
    @Override
    public void loop() {
        // Example controls
        double y = -gamepad1.left_stick_y;  // Forward/backward
        double x = gamepad1.left_stick_x;   // Strafe left/right
        double turn = gamepad1.right_stick_x;  // Rotation

        // Calculate motor powers
        double[] powers = calculateMotorPowers(y, x, turn);

        // Set motor powers
        frontLeft.setPower(powers[0]);
        frontRight.setPower(powers[1]);
        backLeft.setPower(powers[2]);
        backRight.setPower(powers[3]);

        // Display IMU telemetry
        displayIMUTelemetry(telemetry);
    }

    // Method to update and display IMU telemetry
    public void displayIMUTelemetry(Telemetry telemetry) {
    }

    // Method to calculate and normalize motor powers for Mecanum drive
    public double[] calculateMotorPowers(double y, double x, double turn) {
        return null;
    }

    public void setDrivePowers(double power, double power1, double power2, double power3) {
    }

    public void init(HardwareMap hardwareMap) {
    }
}
