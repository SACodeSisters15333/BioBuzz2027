package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autotest.test_path_class_for_linear;

public class linear_opMode_test extends LinearOpMode {
    test_path_class_for_linear robot = new test_path_class_for_linear();
    @Override
    public void runOpMode() {
        waitForStart();

        if (opModeIsActive()){
            robot.path1();
            robot.path2();
            robot.path3();
        }
    }
}
