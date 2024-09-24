package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class RobotHardware {
    private MecanumV2 drivetrain;
    private ArmSubsystem arm;

    public RobotHardware() {
        drivetrain = new MecanumV2();
        arm = new ArmSubsystem();
    }

    public void init(HardwareMap hardwareMap) {

        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);

    }

    public MecanumV2 getDrivetrain() {
        return drivetrain;
    }

    public ArmSubsystem getArm() {
        return arm;
    }

}