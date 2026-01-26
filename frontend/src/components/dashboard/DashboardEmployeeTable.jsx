import React from "react";
import TableFilter from "./TableFilter";
import EmployeeTable from "../employees/EmployeeTable";

const DashboardEmployeeTable = () => {
  return (
    <div className="col-span-8  bg-white rounded-lg p-4 ">
      <TableFilter />
      <EmployeeTable />
    </div>
  );
};

export default DashboardEmployeeTable;
