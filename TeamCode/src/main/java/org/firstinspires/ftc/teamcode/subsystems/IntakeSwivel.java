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
    public boolean isInitialized; // Used to ensure position is NonNull to avoid errors in rotCCW() and rotCW()

    public IntakeSwivel(HardwareMap hardwareMap)
    {
        servoSwivel = hardwareMap.get(Servo.class, "R2");
        servoSwivel.scaleRange(MIN_POSITION, MAX_POSITION);
        isInitialized = false;
    }

    public void rotCCW()
    {
        if (!isInitialized)
        {
            setPosition(0.5);
            isInitialized = true;
        }
        position = Math.min(position + POSITION_INCREMENT, 1);
        servoSwivel.setPosition(position);
    }

    public void rotCW()
    {
        if (!isInitialized)
        {
            setPosition(0.5);
            isInitialized = true;
        }
        position = Math.max(position - POSITION_INCREMENT, 0);
        servoSwivel.setPosition(position);
    }

    public void setPosition(double newPosition)
    {
        servoSwivel.setPosition(newPosition);
        position = newPosition;
    }
}
