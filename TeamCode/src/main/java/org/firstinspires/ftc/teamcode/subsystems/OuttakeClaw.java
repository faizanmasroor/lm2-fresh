package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeClaw
{
    public static final double OPEN_POSITION = 0.55;
    public static final double CLOSE_POSITION = 0.44;

    public Servo servoClaw;
    public ClawPosition clawPosition;

    public enum ClawPosition
    {
        UNINITIALIZED, // Should not be used as an argument for setPosition()
        OPEN,
        CLOSE
    }

    public OuttakeClaw(HardwareMap hardwareMap)
    {
        servoClaw = hardwareMap.get(Servo.class, "oClaw");
        clawPosition = ClawPosition.UNINITIALIZED;
    }

    public boolean is(ClawPosition clawPosition)
    {
        return clawPosition == this.clawPosition;
    }

    /**
     * Opens the claw if it's closed, closes the claw if it's open, and does nothing if it's
     * uninitialized.
     * @return  the position that was achieved
     */
    public ClawPosition togglePosition()
    {
        switch (clawPosition)
        {
            case OPEN: return setPosition(ClawPosition.CLOSE);
            case CLOSE: return setPosition(ClawPosition.OPEN);
            default: return clawPosition;
        }
    }

    public ClawPosition getPosition()
    {
        return clawPosition;
    }

    /**
     * Changes servo positions to reach the new claw position (argument). Passing UNINITIALIZED as
     * an argument does not cause the servos to move nor change the object's {@code clawPosition}
     * field.
     * @param newClawPosition   the new claw position to achieve
     * @return              the claw position that was achieved
     */
    public ClawPosition setPosition(ClawPosition newClawPosition)
    {
        // Preemptive return statement avoids unnecessary servo setPosition() calls
        if (newClawPosition == clawPosition) return clawPosition;

        switch (newClawPosition)
        {
            case OPEN:
                servoClaw.setPosition(OPEN_POSITION);
                break;
            case CLOSE:
                servoClaw.setPosition(CLOSE_POSITION);
                break;
        }

        if (newClawPosition != ClawPosition.UNINITIALIZED) clawPosition = newClawPosition;

        return clawPosition;
    }
}
