package com.hydrozagadka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FilterFiles {
    private History historyFiles;
    private LoadFile loadFile;
    private Map<Integer, WaterContainer> allFiles;

    public FilterFiles(Map<Integer, WaterContainer> allFiles) {
        this.allFiles = allFiles;
    }
    public List<Double> minValueOfHistoryFiles() {
        int id = 149180010;
        Double min = Double.MAX_VALUE;
        Double max = Double.MIN_VALUE;
        List<Double> listOfMaxAndMinValues = new ArrayList<>();
        for (History history : allFiles.get(id).getHistory()) {
            if (min > history.getWaterDeep()) {
                min = history.getWaterDeep();
            }
            if (max < history.getWaterDeep()) {
                max = history.getWaterDeep();
            }
        }
        listOfMaxAndMinValues.add(max);
        listOfMaxAndMinValues.add(min);
        return listOfMaxAndMinValues;
    }

    public List<WaterContainer> getWaterContainers(String province) {
        System.out.println(province);
        List<WaterContainer> getWaterContainer = new ArrayList<>();
        for (WaterContainer wt : allFiles.values()) {
            System.out.println(wt.getProvince());
            if (wt.getProvince().equals(province)) {
                getWaterContainer.add(wt);
            }
        }
        return getWaterContainer;
    }

    public WaterContainer readExample(Integer id) {
        WaterContainer wt = allFiles.get(id);
        System.out.println("====================================================================");
        System.out.println("| " + wt.getContainerName() + " |     " + wt.getProvince() + "                |        " + wt.getStationName());
        System.out.println("====================================================================\n");
        System.out.println("| data      | stan wody | przeplyw | temperatura");
        System.out.println("------------------------------------------------");
        wt.getHistory().stream().sorted((o1, o2) -> o2.getDate().compareTo(o1.getDate())).forEach(hs -> {
            System.out.print(hs.getDate() + " |     " + hs.getWaterDeep() + "      |    " + hs.getFlow() + "    |   " + hs.getTemperature() + " |\n");
            System.out.println("------------------------------------------------");
        });
        return wt;
    }
    public void showNewestData(int id) {
        int lastIndexOfHistory = allFiles.get(id).getHistory().size() - 1;
        System.out.println("Nazwa kontenera | Nazwa Stacji | nazwa wojewodztwa | data      | stan wody | przeplyw | temperatura");
        System.out.print(allFiles.get(id).getContainerName() + " | " + allFiles.get(id).getStationName() + "     | " + allFiles.get(id).getProvince());
        System.out.println("        |    " + allFiles.get(id).getHistory().get(lastIndexOfHistory).getDate() + " |   " + allFiles.get(id).getHistory().get(lastIndexOfHistory).getWaterDeep() + " | " +
                allFiles.get(id).getHistory().get(lastIndexOfHistory).getFlow() + "     | " + allFiles.get(id).getHistory().get(lastIndexOfHistory).getTemperature());
    }
}