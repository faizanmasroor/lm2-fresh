package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.IntakeArm;
import org.firstinspires.ftc.teamcode.subsystems.IntakeClaw;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSlides;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSwivel;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeArm;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeClaw;
import org.firstinspires.ftc.teamcode.subsystems.OuttakeSlides;
import org.firstinspires.ftc.teamcode.subsystems.TeleDrive;

@TeleOp(name = "Everything")
public class Everything extends OpMode
{
    IntakeArm iArm;
    IntakeClaw iClaw;
    IntakeSwivel iSwivel;
    IntakeSlides iSlides;
    OuttakeArm oArm;
    OuttakeClaw oClaw;
    OuttakeSlides oSlides;
    TeleDrive drive;

    @Override
    public void init()
    {
        iArm = new IntakeArm(hardwareMap);
        iClaw = new IntakeClaw(hardwareMap);
        iSwivel = new IntakeSwivel(hardwareMap);
        iSlides = new IntakeSlides(hardwareMap);
        oArm = new OuttakeArm(hardwareMap);
        oClaw = new OuttakeClaw(hardwareMap);
        oSlides = new OuttakeSlides(hardwareMap);
        drive = new TeleDrive(hardwareMap);
    }

    @Override
    public void start()
    {
        /*
        Initial robot pose; initializes a value for each subsystem's state enum (if there is one);
        makes iSwivel find center position
         */
        iArm.hover();
        iClaw.open();
        iSwivel.setPosition(0.5);
        oArm.retract();
        oClaw.open();
    }

    @Override
    public void loop()
    {

    }
}
