package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeArm
{
    public static final double EXTEND_POSITION = 0.06;
    public static final double RETRACT_POSITION = 0.85;

    public Servo servoArm;
    public boolean isExtended;

    public OuttakeArm(HardwareMap hardwareMap)
    {
        servoArm = hardwareMap.get(Servo.class, "oArm");
    }

    public void extend()
    {
        servoArm.setPosition(EXTEND_POSITION);
        isExtended = true;
    }

    public void retract()
    {
        servoArm.setPosition(RETRACT_POSITION);
        isExtended = false;
    }

    public void extendIfPossible()
    {
        if (!isExtended) extend();
    }

    public void retractIfPossible()
    {
        if (isExtended) retract();
    }

    public void switchStates()
    {
        if (isExtended) retract();
        else extend();
    }

}
