package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.IMU;


public class RobotHardware {
    private MecanumDrivetrain drivetrain;
    private ArmSubsystem arm;
    public IMU imu;

    public RobotHardware() {
        drivetrain = new MecanumDrivetrain();
        arm = new ArmSubsystem();
    }

    public void init(HardwareMap hardwareMap) {
        // initialize the IMU
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);

        // Set up IMU parameters
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;

        // This is where you set the IMU orientation
        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.loggingEnabled = false;

        // Initialize the IMU with these parameters
        imu.initialize(parameters);
    }

    public MecanumDrivetrain getDrivetrain() {
        return drivetrain;
    }

    public ArmSubsystem getArm() {
        return arm;
    }

    // Get the current orientation, setting the axes reference and order based on your IMU mounting
    public void updateOrientation() {
        imuAngles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, BNO055IMU.AngleUnit.DEGREES);
    }


}