package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeClaw
{
    public Servo servoClaw;
    public Position position;
    public final double OPEN_POSITION, CLOSE_POSITION;

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
        OPEN_POSITION = 0.57;
        CLOSE_POSITION = 0.66;
    }

    public boolean is(Position position)
    {
        return position == this.position;
    }

    /**
     * Opens the claw if it's closed, closes the claw if it's open, and does nothing if it's
     * uninitialized.
     * @return  the position that was achieved
     */
    public Position togglePosition()
    {
        switch (position)
        {
            case OPEN: return setPosition(Position.CLOSE);
            case CLOSE: return setPosition(Position.OPEN);
            default: return Position.UNINITIALIZED;
        }
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
                servoClaw.setPosition(OPEN_POSITION);
                break;
            case CLOSE:
                servoClaw.setPosition(CLOSE_POSITION);
                break;
        }

        if (newPosition != Position.UNINITIALIZED) position = newPosition;

        return position;
    }
}
