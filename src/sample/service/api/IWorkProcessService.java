package sample.service.api;


import sample.model.Couple;
import sample.model.WorkProcess;

import java.util.List;
import java.util.Map;

public interface IWorkProcessService {
    Couple findLongestWorkingCoupleIds(Map<Integer, List<WorkProcess>> data);
}
