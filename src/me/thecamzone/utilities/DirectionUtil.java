package me.thecamzone.utilities;

import org.bukkit.Axis;
import org.bukkit.block.BlockFace;

public class DirectionUtil {

    private static final BlockFace[] axis = { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };

    // Someone else's complete jank to find cardinal direction
    public static BlockFace yawToFacing(float yaw) {
        return axis[Math.round(yaw / 90f) & 0x3].getOppositeFace();
    }

    public static Axis yawToAxis(float yaw) {
        BlockFace direction = yawToFacing(yaw);

        if(direction == BlockFace.NORTH || direction == BlockFace.SOUTH) {
            return Axis.X;
        } else {
            return Axis.Z;
        }
    }

    public static Axis oppositeAxis(Axis axis) {
        if(axis == Axis.X) return Axis.Z;
        if(axis == Axis.Z) return Axis.X;
        return null;
    }

}
