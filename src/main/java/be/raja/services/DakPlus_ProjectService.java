package be.raja.services;

import be.raja.data.DakPlus_ProjectDAO;
import be.raja.model.DakPlus_Project;
import be.raja.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class DakPlus_ProjectService {
    private DakPlus_ProjectDAO dakplusDAO = new DakPlus_ProjectDAO();

    public List<DakPlus_Project> incompleteProject() throws SQLException, ClassNotFoundException {
    return dakplusDAO.incompleteProject();
    }
}