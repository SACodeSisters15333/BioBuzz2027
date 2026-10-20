package org.firstinspires.ftc.teamcode.pedro.autotest;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
public class TestAuto extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    private final Pose startPose = p.of(24, 24, 0);
    private final Pose park = p.of(48, 48, 90);
    //the follower
    //what is below is pathsssss...

    // The first and last Poses are the start and end of the curve.
    // Any Poses between them are control points that change the shape of the curve.
    private final Pose controlPose = p.of(36, 60, 45);
    private Path park() {
        return curve(startPose, controlPose, park).linear(startPose, park);
    }
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }
    @Override
    public void start() {
    }
    @Override
    public void loop() {
    }
}
