package fr.cozyhouse.legacyCombat.particules;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

import java.util.Objects;

public class ParticulesUtils {

    public static void spiralParticulesLoc(Location location){
        World world = Objects.requireNonNull(location.getWorld());

        double centerX = location.getX();
        double centerZ = location.getZ();
        double startY = location.getY();

        double radius = 1.0D;                     // distance de la spirale au joueur
        double height = 3.0D;                     // hauteur totale de la spirale
        double heightStep = 0.1D;                 // montée en Y à chaque étape
        double angleStep = Math.toRadians(20D);   // rotation à chaque étape

        double angle = 0;
        double y = startY;

        while (y < startY + height){
            double x = centerX + radius * Math.cos(angle);
            double z = centerZ + radius * Math.sin(angle);

            world.spawnParticle(Particle.WITCH, x, y, z, 1, 0, 0, 0, 0);

            y += heightStep;
            angle += angleStep;
        }
    }
}
