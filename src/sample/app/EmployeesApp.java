package sample.app;

import sample.factory.WorkProcessFactory;
import sample.model.Couple;
import sample.model.WorkProcess;
import sample.service.api.IWorkProcessService;
import sample.util.Constants;
import sample.util.Reader;

import java.util.*;
import java.util.stream.Collectors;

import static sample.util.Constants.COMMA_SPACE_SEPARATOR;
import static sample.util.Constants.VERTICAL_BAR_SEPARATOR;


public class EmployeesApp {

    private Map<Integer, List<WorkProcess>> data;

    private final IWorkProcessService service;

    public EmployeesApp(IWorkProcessService service) {
        this.data = new HashMap<>();
        this.service = service;
    }

    public Couple findLongestWorkingCouple() {
        this.readInput();

        return this.service.findLongestWorkingCoupleIds(this.data);
    }

    private void readInput() {
        String[] lines = Reader.readFile(Constants.SEED_FILE_PATH).split(VERTICAL_BAR_SEPARATOR);

        for (String line : Arrays.stream(lines).filter(e -> !e.isEmpty()).collect(Collectors.toSet())) {
            String[] inputData = line.split(COMMA_SPACE_SEPARATOR);

            WorkProcess workProcess = WorkProcessFactory.generate(inputData);

            if (workProcess == null) continue;

            this.data.putIfAbsent(workProcess.getProjectId(), new ArrayList<>());

            List<WorkProcess> tmp = this.data.get(workProcess.getProjectId());
            tmp.add(workProcess);

            this.data.put(workProcess.getProjectId(), tmp);
        }
    }
}
