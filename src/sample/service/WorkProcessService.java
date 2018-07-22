package sample.service;


import sample.exception.SolutionNotFoundException;
import sample.model.Couple;
import sample.model.WorkProcess;
import sample.service.api.IWorkProcessService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static sample.util.Constants.ONE;
import static sample.util.Constants.ZERO;

public class WorkProcessService implements IWorkProcessService {

    private final Comparator<? super WorkProcess> compareByWorkingDays = (Comparator<WorkProcess>) (o1, o2) -> {
        if (o1.getWorkingDays() > o2.getWorkingDays()) return -1;
        else if (o1.getWorkingDays() < o2.getWorkingDays()) return 1;

        return 0;
    };

    @Override
    public Couple findLongestWorkingCoupleIds(Map<Integer, List<WorkProcess>> data) {
        WorkProcess firstEmployee = null;
        WorkProcess secondEmployee = null;

        long bestDays = Integer.MIN_VALUE;
        int projectId = Integer.MIN_VALUE;

        for (Map.Entry<Integer, List<WorkProcess>> current : data.entrySet()) {
            if (current.getValue().size() <= 1) continue;

            List<WorkProcess> processes = current.getValue();
            processes.sort(compareByWorkingDays);

            WorkProcess employee_1 = processes.get(ZERO);
            WorkProcess employee_2 = processes.get(ONE);

            long currentBestDays = employee_1.getWorkingDays() + employee_2.getWorkingDays();

            if (currentBestDays > bestDays) {
                firstEmployee = employee_1;
                secondEmployee = employee_2;
                bestDays = currentBestDays;
                projectId = current.getKey();
            }
        }

        if (firstEmployee == null || projectId == Integer.MIN_VALUE) throw new SolutionNotFoundException();

        return new Couple(firstEmployee.getEmployeeId(), secondEmployee.getEmployeeId(), projectId, bestDays);
    }
}
