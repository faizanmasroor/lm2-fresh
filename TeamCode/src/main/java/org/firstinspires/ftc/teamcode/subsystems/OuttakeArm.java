package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeArm
{
    public static final double RETRACT_POSITION = 0.85;
    public static final double EXTEND_POSITION = 0.06;

    public Servo servoArm;
    public Position position;

    public enum Position
    {
        UNINITIALIZED,
        RETRACT,
        EXTEND
    }

    public OuttakeArm(HardwareMap hardwareMap)
    {
        servoArm = hardwareMap.get(Servo.class, "oArm");
        position = Position.UNINITIALIZED;
    }

    public Position retract()
    {
        return setPosition(Position.RETRACT);
    }

    public Position extend()
    {
        return setPosition(Position.EXTEND);
    }

    public Position togglePosition()
    {
        switch (position)
        {
            case RETRACT: return setPosition(Position.EXTEND);
            case EXTEND: return setPosition(Position.RETRACT);
            default: return position;
        }
    }

    public Position getPosition()
    {
        return position;
    }

    public Position setPosition(Position newPosition)
    {
        // Preemptive return statement avoids unnecessary servo setPosition() calls
        if (newPosition == position || newPosition == Position.UNINITIALIZED) return position;

        switch (newPosition)
        {
            case RETRACT:
                servoArm.setPosition(RETRACT_POSITION);
                break;
            case EXTEND:
                servoArm.setPosition(EXTEND_POSITION);
                break;
        }
        position = newPosition;

        return position;
    }
}
