package org.firstinspires.ftc.teamcode.testing_TeaganandJessica;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
public class HardwareMapTest {
public DcMotor shooter = null;
public HardwareMap hwm = null;
public ElapsedTime timer = new ElapsedTime();

    public void init(HardwareMap HardwareMapTest) {
      hwm = HardwareMapTest;
      shooter = hwm.get(DcMotor.class, "shooter");
      shooter.setDirection(DcMotor.Direction.FORWARD);
      shooter.setPower(0);
      shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}
