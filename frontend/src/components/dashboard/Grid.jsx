import React from "react";
import StatCard from "./StatCard";

import ActivityGraph from "./ActivityGraph";
import TopBar from "./TopBar";
import EmployeeSection from "./EmployeeSection";
import { statsData } from "../../data/statsData";

const Grid = () => {
  return (
    <div className="p-8 bg-slate-50 h-[100%]">
      <TopBar />

      {/* section 1 */}
      <div className="grid grid-cols-12  mt-5">
        <div className="col-span-5 grid grid-cols-2 gap-0.5">
          {statsData.map((stat) => (
            <StatCard
              id={stat.id}
              key={stat.id}
              title={stat.title}
              value={stat.value}
              percentage={stat.percentage}
              trend={stat.trend}
              Icon={stat.icon}
            />
          ))}
        </div>
        <div className="col-span-7 bg-white">
          <ActivityGraph />
        </div>

        {/* section 2  */}
      </div>
      <EmployeeSection />
    </div>
  );
};

export default Grid;
