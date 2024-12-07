package org.firstinspires.ftc.teamcode.teleops;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSlides;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSlides;

@TeleOp(name = "SlideTesting")
public class SlideTesting extends OpMode
{
    IntakeSlides iSlides;
    OuttakeSlides oSlides;

    @Override
    public void init()
    {
        iSlides = new IntakeSlides(hardwareMap);
        iSlides.motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        iSlides.motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        iSlides.motorL.setPower(0);
        iSlides.motorR.setPower(0);


        oSlides = new OuttakeSlides(hardwareMap);
        oSlides.motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        oSlides.motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        oSlides.motorL.setPower(0);
        oSlides.motorR.setPower(0);

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
    }

    @Override
    public void loop()
    {
        telemetry.addData("Intake Left Position", iSlides.motorL.getCurrentPosition());
        telemetry.addData("Intake Right Position", iSlides.motorR.getCurrentPosition());
        telemetry.addData("Outtake Left Position", oSlides.motorL.getCurrentPosition());
        telemetry.addData("Outtake Right Position", oSlides.motorR.getCurrentPosition());

        telemetry.update();
    }
}
