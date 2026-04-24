import React from "react";
import StatCard from "./StatCard";
import ActivityGraph from "./ActivityGraph";
import TopBar from "./TopBar";
import DashboardTable from "./DashboardTable";
import EmployeeDistributionChart from "./EmployeeDistributionChart";
import { statsData } from "../../data/statsData";
import { useGetDashboardStatsQuery } from "../../features/dashboard/dashboardApi";

const Grid = () => {
  const { data: stats, isLoading } = useGetDashboardStatsQuery();

  // Merge the static data (titles, icons, colors) with real backend values
  const dynamicStats = statsData.map((stat) => {
    let value = "0";
    if (stats) {
      if (stat.id === 1) value = stats.totalEmployees.toString();
      if (stat.id === 2) value = stats.jobApplicants.toString();
      if (stat.id === 3) value = stats.newEmployees.toString();
      if (stat.id === 4) value = stats.resignedEmployees.toString();
    }
    return { ...stat, value };
  });

  return (
    <div>
      <TopBar />

      {/* Stat Cards */}
      <div className="grid grid-cols-2 lg:grid-cols-4 gap-4 mb-6">
        {dynamicStats.map((stat) => (
          <StatCard
            key={stat.id}
            id={stat.id}
            title={stat.title}
            value={isLoading ? "..." : stat.value}
            percentage={stat.percentage}
            trend={stat.trend}
            Icon={stat.icon}
            color={stat.color}
          />
        ))}
      </div>

      {/* Charts Row */}
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-4 mb-6">
        <div className="lg:col-span-2">
          <ActivityGraph />
        </div>
        <div>
          <EmployeeDistributionChart />
        </div>
      </div>

      {/* Recent Employees Table */}
      <DashboardTable />
    </div>
  );
};

export default Grid;
