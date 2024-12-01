package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeClaw
{
    public Servo servoClaw;
    public Position position;
    public double openPosition, closePosition;

    public enum Position
    {
        UNINITIALIZED, // Should not be used as an argument for setPosition()
        OPEN,
        CLOSE
    }

    public IntakeClaw(HardwareMap hardwareMap)
    {
        servoClaw = hardwareMap.get(Servo.class, "L2");
        position = Position.UNINITIALIZED;
        openPosition = 0.57;
        closePosition = 0.66;
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
            case OPEN:
                servoClaw.setPosition(openPosition);
                break;
            case CLOSE:
                servoClaw.setPosition(closePosition);
                break;
        }

        if (newPosition != Position.UNINITIALIZED) position = newPosition;

        return position;
    }
}
