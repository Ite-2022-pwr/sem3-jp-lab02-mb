package pl.pwr.ite.bedrylo.data;

import java.util.ArrayList;

public class Generation {
    private ArrayList<MatchList> matchLists = new ArrayList<>();
    
    public Generation(Integer listCount) {
        for (int i = 0; i < listCount; i++) {
            matchLists.add(new MatchList());
        }
    }
    
    public ArrayList<MatchList> getMatchLists() {
        return matchLists;
    }
    
    public void addMatchList(MatchList matchList) {
        matchLists.add(matchList);
    }
    
    public void sortDescendingPoints() {
        matchLists.sort((o1, o2) -> {
            if (o1.getPoints() > o2.getPoints()) {
                return -1;
            } else if (o1.getPoints().equals(o2.getPoints())) {
                return 0;
            } else {
                return 1;
            }
        });
    }
    
    public ArrayList<MatchList> getTopNMatchLists(Integer n) {
        ArrayList<MatchList> topNMatchLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            topNMatchLists.add(matchLists.get(i));
        }
        return topNMatchLists;
    }
    
    public Float getAveragePoints() {
        Float sum = 0f;
        for (MatchList matchList: matchLists) {
            sum += matchList.getPoints();
        }
        return sum / matchLists.size();
    }
    
    public Float getMedianPoints() {
        this.sortDescendingPoints();
        if (matchLists.size() % 2 == 0) {
            return (matchLists.get(matchLists.size() / 2).getPoints() + matchLists.get(matchLists.size() / 2 - 1).getPoints()) / 2;
        } else {
            return matchLists.get(matchLists.size() / 2).getPoints();
        }
    }
    
    public Float getMaxPoints() {
        Float max = matchLists.get(0).getPoints();
        for (MatchList matchList: matchLists) {
            if (matchList.getPoints() > max) {
                max = matchList.getPoints();
            }
        }
        return max;
    }
    
    public Float getMinPoints() {
        Float min = matchLists.get(0).getPoints();
        for (MatchList matchList: matchLists) {
            if (matchList.getPoints() < min) {
                min = matchList.getPoints();
            }
        }
        return min;
    }
    
    @Override
    public String toString() {
        return "Generation{" +
                "matchLists=" + matchLists.size() +
                ", averagePoints=" + getAveragePoints() +
                ", medianPoints=" + getMedianPoints() +
                ", maxPoints=" + getMaxPoints() +
                ", minPoints=" + getMinPoints() +
                '}';
    }
}