package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeArm
{
    public static final double L_RETRACT_POSITION = 0.87;
    public static final double R_RETRACT_POSITION = 0.13;

    public static final double L_HOVER_POSITION = 0.12;
    public static final double R_HOVER_POSITION = 0.88;

    public static final double L_EXTEND_POSITION = 0.06;
    public static final double R_EXTEND_POSITION = 0.94;

    public Servo servoL, servoR;
    public Position position;

    public enum Position
    {
        UNINITIALIZED,
        RETRACT,
        HOVER,
        EXTEND
    }

    public IntakeArm(HardwareMap hardwareMap)
    {
        servoL = hardwareMap.get(Servo.class, "L1");
        servoR = hardwareMap.get(Servo.class, "R1");
        position = Position.UNINITIALIZED;
    }

    public Position togglePosition()
    {
        switch (position)
        {
            case RETRACT: return setPosition(Position.HOVER);
            case HOVER: return setPosition(Position.RETRACT);
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
                servoL.setPosition(L_RETRACT_POSITION);
                servoR.setPosition(R_RETRACT_POSITION);
                break;
            case HOVER:
                servoL.setPosition(L_HOVER_POSITION);
                servoR.setPosition(R_HOVER_POSITION);
                break;
            case EXTEND:
                servoL.setPosition(L_EXTEND_POSITION);
                servoR.setPosition(R_EXTEND_POSITION);
                break;
        }
        position = newPosition;

        return position;
    }
}
