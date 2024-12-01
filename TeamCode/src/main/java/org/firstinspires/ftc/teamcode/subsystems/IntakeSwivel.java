package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSwivel
{
    public static final double MIN_POSITION = 0.17;
    public static final double MAX_POSITION = 0.83;
    public static final double POSITION_INCREMENT = 0.25;

    public Servo servoSwivel;
    public double position;
    public boolean isInitialized; // Ensures the position field is not null when rotCCW() or rotCW() is called

    public IntakeSwivel(HardwareMap hardwareMap)
    {
        servoSwivel = hardwareMap.get(Servo.class, "R2");
        servoSwivel.scaleRange(MIN_POSITION, MAX_POSITION);
        isInitialized = false;
    }

    public double rotCCW()
    {
        if (!isInitialized)
        {
            setPosition(0.5);
            isInitialized = true;
        }
        return setPosition(Math.min(position + POSITION_INCREMENT, 1));
    }

    public double rotCW()
    {
        if (!isInitialized)
        {
            setPosition(0.5);
            isInitialized = true;
        }
        return setPosition(Math.max(position - POSITION_INCREMENT, 0));
    }

    public double setPosition(double newPosition)
    {
        servoSwivel.setPosition(newPosition);
        position = newPosition;
        return position;
    }
}
