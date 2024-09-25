package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class RobotHardware {
    private MecanumDrive_version2 drivetrain;
    private ArmSubsystem arm;

    public RobotHardware() {
        drivetrain = new MecanumDrive_version2();
        arm = new ArmSubsystem();
    }

    public void init(HardwareMap hardwareMap) {

        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);

    }

    public MecanumDrive_version2 getDrivetrain() {
        return drivetrain;
    }

    public ArmSubsystem getArm() {
        return arm;
    }

}