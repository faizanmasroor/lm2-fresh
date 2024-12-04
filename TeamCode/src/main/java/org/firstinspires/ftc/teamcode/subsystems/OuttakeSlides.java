package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeSlides
{
    public static final double MAX_POSITION = 3750;
    public static final double POSITION_BUFFER = 50;
    public static final double SPEED_MULTIPLIER = 0.5;
    public static final double GRAVITY_FEEDFORWARD = 0.0006;

    public DcMotor motorL, motorR;

    public OuttakeSlides(HardwareMap hardwareMap)
    {
        motorL = hardwareMap.get(DcMotor.class, "oSlideL");
        motorR = hardwareMap.get(DcMotor.class, "oSlideR");

        motorL.setDirection(DcMotorSimple.Direction.REVERSE);

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

    public boolean isDangerousInput(double input)
    {
        return (isExtended() && input > 0) || (isRetracted() && input < 0);
    }

    public void setPower(double input)
    {
        motorL.setPower(input * SPEED_MULTIPLIER + GRAVITY_FEEDFORWARD);
        motorR.setPower(input * SPEED_MULTIPLIER + GRAVITY_FEEDFORWARD);
    }
}
