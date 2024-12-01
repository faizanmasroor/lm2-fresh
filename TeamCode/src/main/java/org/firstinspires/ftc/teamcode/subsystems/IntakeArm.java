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
    public ArmPosition armPosition;

    public enum ArmPosition
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

        if (newArmPosition != ArmPosition.UNINITIALIZED) armPosition = newArmPosition;

        return armPosition;
    }
}
