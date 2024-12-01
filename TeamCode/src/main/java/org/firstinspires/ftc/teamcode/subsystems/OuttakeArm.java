package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OuttakeArm
{
    public static final double EXTEND_POSITION = 0.06;
    public static final double RETRACT_POSITION = 0.85;

    public Servo servoArm;
    public ArmPosition armPosition;

    public enum ArmPosition
    {
        UNINITIALIZED,
        EXTEND,
        RETRACT
    }

    public OuttakeArm(HardwareMap hardwareMap)
    {
        servoArm = hardwareMap.get(Servo.class, "oArm");
        armPosition = ArmPosition.UNINITIALIZED;
    }

    public boolean is(ArmPosition armPosition)
    {
        return armPosition == this.armPosition;
    }

    public ArmPosition getPosition()
    {
        return armPosition;
    }

    /**
     * Changes servo positions to reach the new arm position (argument). Passing UNINITIALIZED as an
     * argument does not cause the servos to move nor change the object's {@code armPosition} field.
     * @param newArmPosition   the new arm position to achieve
     * @return              the arm position that was achieved
     */
    public ArmPosition setPosition(ArmPosition newArmPosition)
    {
        // Preemptive return statement avoids unnecessary servo setPosition() calls
        if (newArmPosition == armPosition) return armPosition;

        switch (newArmPosition)
        {
            case EXTEND:
                servoArm.setPosition(EXTEND_POSITION);
                break;
            case RETRACT:
                servoArm.setPosition(RETRACT_POSITION);
                break;
        }

        if (newArmPosition != ArmPosition.UNINITIALIZED) armPosition = newArmPosition;

        return armPosition;
    }
}
