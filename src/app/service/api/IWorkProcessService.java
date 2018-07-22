package app.service.api;


import app.model.Couple;
import app.model.WorkProcess;

import java.util.List;
import java.util.Map;

public interface IWorkProcessService {
    Couple findLongestWorkingCoupleIds(Map<Integer, List<WorkProcess>> data);
}
