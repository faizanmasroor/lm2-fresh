package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeArm
{
    public Servo servoL, servoR;
    public Position position;
    public final double L_RETRACT_POSITION, R_RETRACT_POSITION;
    public final double L_HOVER_POSITION, R_HOVER_POSITION;
    public final double L_EXTEND_POSITION, R_EXTEND_POSITION;

    public enum Position
    {
        UNINITIALIZED, // Should not be used as an argument for setPosition()
        RETRACT,
        HOVER,
        EXTEND
    }

    public IntakeArm(HardwareMap hardwareMap)
    {
        servoL = hardwareMap.get(Servo.class, "L1");
        servoR = hardwareMap.get(Servo.class, "R1");

        position = Position.UNINITIALIZED;

        L_RETRACT_POSITION = 0.87;
        R_RETRACT_POSITION = 0.13;

        L_HOVER_POSITION = 0.12;
        R_HOVER_POSITION = 0.88;

        L_EXTEND_POSITION = 0.06;
        R_EXTEND_POSITION = 0.94;
    }

    public boolean is(Position position)
    {
        return position == this.position;
    }

    public Position getPosition()
    {
        return position;
    }

    /**
     * Changes servo positions to reach the new state (argument). Passing UNINITIALIZED as an
     * argument does not cause the servos to move nor change the object's {@code position} field.
     * @param newPosition   the new position to achieve
     * @return              the position that was achieved
     */
    public Position setPosition(Position newPosition)
    {
        // Preemptive return statement avoids unnecessary servo setPosition() calls
        if (newPosition == position) return position;

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

        if (newPosition != Position.UNINITIALIZED) position = newPosition;

        return position;
    }
}
