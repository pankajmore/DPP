import java.util.List;

/** https://leetcode.com/problems/employee-importance/description/ */
class EmployeeImportance {
  int getImportance(List<Employee> employees, int id) {
    Employee emp = find(employees, id);
    if (emp == null) {
      return 0;
    } else {
      int sum = emp.importance;
      ;
      for (int idx : emp.subordinates) {
        sum += getImportance(employees, idx);
      }
      return sum;
    }
  }

  private Employee find(List<Employee> employees, int id) {
    for (Employee emp : employees) {
      if (emp.id == id) {
        return emp;
      }
    }
    return null;
  }

  class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    int id;
    // the importance value of this employee
    int importance;
    // the id of direct subordinates
    List<Integer> subordinates;
  }
}
