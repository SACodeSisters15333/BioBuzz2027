package org.firstinspires.ftc.teamcode.testing_KX;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HWM_Test {
    public DcMotor intake = null;
    private HardwareMap hwMap = null;
    private ElapsedTime timer = new ElapsedTime();

    public void init(HardwareMap test_HWM) {
        hwMap = test_HWM;
        intake = hwMap.get(DcMotor.class, "intake");
        intake.setDirection(DcMotor.Direction.FORWARD);
        intake.setPower(0);
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public Command motorTest(double power, double time) {
        return Command.build()
                .setStart(() -> timer.reset())
                .setExecute(() -> intake.setPower(power))
                .setDone(() -> timer.time() >= time)
                .setEnd(endCondition -> intake.setPower(0))
                .requiring(intake);
    }
    }
