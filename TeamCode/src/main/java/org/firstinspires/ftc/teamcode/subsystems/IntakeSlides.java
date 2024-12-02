package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSlides
{
    public static final int MAX_POSITION = 1100;
    public static final int POSITION_BUFFER = 30;
    public static final double SPEED_MULTIPLIER = 0.4;

    public DcMotor motorL, motorR;

    public IntakeSlides(HardwareMap hardwareMap)
    {
        motorL = hardwareMap.get(DcMotor.class, "iSlideL");
        motorR = hardwareMap.get(DcMotor.class, "iSlideR");

        motorR.setDirection(DcMotorSimple.Direction.REVERSE);

        motorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorL.setPower(0);
        motorR.setPower(0);
    }

    public boolean isExtended()
    {
        return Math.round((motorL.getCurrentPosition() + motorR.getCurrentPosition()) / 2.0) >= MAX_POSITION - POSITION_BUFFER;
    }

    public boolean isRetracted()
    {
        return Math.round((motorL.getCurrentPosition() + motorR.getCurrentPosition()) / 2.0) <= POSITION_BUFFER;
    }

    public void setPower(double input)
    {
        motorL.setPower(input * SPEED_MULTIPLIER);
        motorR.setPower(input * SPEED_MULTIPLIER);
    }
}
