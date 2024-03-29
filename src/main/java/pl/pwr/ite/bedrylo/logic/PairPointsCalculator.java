package pl.pwr.ite.bedrylo.logic;

import org.jetbrains.annotations.NotNull;
import pl.pwr.ite.bedrylo.data.PersonalPreference;
import pl.pwr.ite.bedrylo.data.Ski;

public abstract class PairPointsCalculator {
    public static Float calculatePairPoints(@NotNull PersonalPreference preference, Ski ski){
        if (ski == null) {
            return (100f - preference.getDiscount().floatValue())*(-5f);
        }
        Float points = null;
        for (Ski preferenceSki : preference.getPreferredSkis()) {
            float tempPoints = 0f;
            if (ski.getType().equals(preferenceSki.getType())) {
                tempPoints += 100f;
            } else {
                tempPoints -= 100f;
            }
            if (ski.getLength().equals(preferenceSki.getLength())) {
                tempPoints += 100f;
            } else {
                tempPoints -= 3f*(Math.abs(ski.getLength() - preferenceSki.getLength()));
            }
            tempPoints *= (((100 - preference.getDiscount()))/100f);
            if (points == null) {
                points = tempPoints;
            } else if (tempPoints >= points) {
                points = tempPoints;
            }
        }
        return points;
    }
}
