package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class RobotHardware {
    private MecanumDrivetrain drivetrain;
    private ArmSubsystem arm;

    public RobotHardware() {
        drivetrain = new MecanumDrivetrain();
        arm = new ArmSubsystem();
    }

    public void init(HardwareMap hardwareMap) {

        drivetrain.init(hardwareMap);
        arm.init(hardwareMap);

    }

    public MecanumDrivetrain getDrivetrain() {
        return drivetrain;
    }

    public ArmSubsystem getArm() {
        return arm;
    }

}