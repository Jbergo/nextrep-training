package service;

import dao.PlanDAO;
import model.Plan;

import java.util.List;

public class PlanService {
    private final PlanDAO planDao;

    public PlanService(PlanDAO planDao) {
        this.planDao = planDao;
    }

    public List<Plan> listarPlanes() {
        return planDao.findAll();
    }

    public List<Plan> buscarPorNivel(String nivel) {
        return planDao.findByLevel(nivel);
    }
}
