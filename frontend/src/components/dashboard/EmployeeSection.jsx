import React from "react";
import DashboardEmployeeTable from "./DashboardEmployeeTable";
import EmployeeDistributionChart from "./EmployeeDistributionChart";

const EmployeeSection = () => {
  return (
    <div className="grid grid-cols-12 gap-4 mt-6  ">
      <DashboardEmployeeTable />
      <EmployeeDistributionChart />
    </div>
  );
};

export default EmployeeSection;
