package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OuttakeSlides
{
    public static final double GRAVITY_FEEDFORWARD = 0.001;
    public static final double MAX_POSITION = 3800;
    public static final double SPEED_MULTIPLIER = 0.5;

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

    public void setPower(double input)
    {
        motorL.setPower(input * SPEED_MULTIPLIER + GRAVITY_FEEDFORWARD);
        motorR.setPower(input * SPEED_MULTIPLIER + GRAVITY_FEEDFORWARD);
    }
}
