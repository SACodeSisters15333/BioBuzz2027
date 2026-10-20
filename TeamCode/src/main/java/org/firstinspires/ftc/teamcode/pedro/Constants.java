package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeft");
        c.frontRightName.set("frontRight");
        c.backLeftName.set("backLeft");
        c.backRightName.set("backRight");
        c.frontLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.REVERSE);
    }
    );

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-3.4254374466543127);
        c.yPodOffset.set(2.1613535543126385);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.23781695210424625);
                Controller secondaryTranslationalForward = Controller.proportional(0.08786700921652467);
                Controller primaryTranslationalLateral = Controller.proportional(0.35066236123136585);
                Controller secondaryTranslationalLateral = Controller.proportional(0.1295603726041302);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.01762846124497585));
                c.brake.set(Controller.proportionalFeedforward(0.014984192058229472));

                c.headingFeedback.set(Controller.proportional(3.248670292842538));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.053502348895815635, 0.012376832221171048));

                c.linearBrakeCoefficients.set(Matrix.diag(0.07497794896496739, 0.03169972045866682));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0022188764386388274, 0.0034459853687378752));

                c.maxAchievableForwardVelocity.set(57.07955260319729);
                c.maxAchievableStrafeVelocity.set(46.28578331455223);
                c.naturalForwardDeceleration.set(35.86457376468446);
                c.naturalStrafeDeceleration.set(72.75269193806544);
            }
    );
    public static Follower create(HardwareMap h) {

        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );// return new Follower(Drivetrain, Localizer, Foresight);

    }
}