package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class LeftPark
{
    public static double inRad(double degrees)
    {
        return Math.toRadians(degrees);
    }

    public static void main(String[] args)
    {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, trackWidth
                .setConstraints(60, 20, inRad(180), inRad(180), 15)
                .build();

        Pose2d initPose = new Pose2d(-32, -62, inRad(90));

        myBot.runAction(myBot.getDrive().actionBuilder(initPose)
                .splineToConstantHeading(new Vector2d(-36, -12), inRad(90))
                .turnTo(inRad(180))
                .strafeTo(new Vector2d(-25, -12))
                .build()
        );

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .addEntity(myBot)
                .start();
    }
}