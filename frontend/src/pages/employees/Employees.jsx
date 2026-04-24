import React from "react";
import EmployeeTable from "../../components/employees/EmployeeTable";

const Employees = () => {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-2xl font-extrabold text-gray-900">Employees Directory</h1>
        <p className="text-sm text-gray-400 mt-1">
          Manage your team members, their positions, and access.
        </p>
      </div>

      <EmployeeTable />
    </div>
  );
};

export default Employees;
