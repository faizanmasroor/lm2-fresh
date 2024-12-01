package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeArm
{
    public Servo servoL, servoR;
    public Position position;
    public double leftRetractPosition, rightRetractPosition;
    public double leftHoverPosition, rightHoverPosition;
    public double leftExtendPosition, rightExtendPosition;

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

        leftRetractPosition = 0.87;
        rightRetractPosition = 0.13;

        leftHoverPosition = 0.12;
        rightHoverPosition = 0.88;

        leftExtendPosition = 0.06;
        rightExtendPosition = 0.94;
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
                servoL.setPosition(leftRetractPosition);
                servoR.setPosition(rightRetractPosition);
                break;
            case HOVER:
                servoL.setPosition(leftHoverPosition);
                servoR.setPosition(rightHoverPosition);
                break;
            case EXTEND:
                servoL.setPosition(leftExtendPosition);
                servoR.setPosition(rightExtendPosition);
                break;
        }

        if (newPosition != Position.UNINITIALIZED) position = newPosition;

        return position;
    }
}
