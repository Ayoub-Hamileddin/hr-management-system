import React from "react";
import { CiCircleChevDown } from "react-icons/ci";
import { Label, Pie, PieChart, Sector } from "recharts";
import MetricsOverview from "./MetricsOverview";

const EmployeeDistributionChart = ({ isAnimationActive = true }) => {
  const data = [
    { name: "Group A", value: 400, fill: "#0088FE" },
    { name: "Group B", value: 300, fill: "#00C49F" },
    { name: "Group C", value: 300, fill: "#FFBB28" },
    { name: "Group D", value: 200, fill: "#FF8042" },
  ];

  return (
    <div className="col-span-4 w-full p-8 bg-white rounded-lg">
      <div className="flex items-center justify-between ">
        <h1 className="text-xl font-semibold">Total Employees</h1>
        <span className="text-gray-600 font-semibold flex items-center gap-1">
          All Times <CiCircleChevDown className="size-4 cursor-pointer" />{" "}
        </span>
      </div>
      <div className="flex justify-center mt-5">
        <PieChart
          style={{
            width: "100%",
            maxWidth: "250px",
            maxHeight: "80vh",
            aspectRatio: 1,
          }}
          responsive
        >
          <Pie
            data={data}
            innerRadius="80%"
            outerRadius="100%"
            // Corner radius is the rounded edge of each pie slice
            cornerRadius="50%"
            fill="#8884d8"
            // padding angle is the gap between each pie slice
            paddingAngle={4}
            dataKey="value"
            isAnimationActive={isAnimationActive}
          />

          <Label position={"center"} className="bg-white shadow-lg size-9">
            121
          </Label>
        </PieChart>
      </div>
      <div>
        <MetricsOverview color={"bg-green-600"} label={"Others"} value={71} />
        <MetricsOverview
          color={"bg-yellow-400"}
          label={"Onboarding"}
          value={27}
        />
        <MetricsOverview
          color={"bg-blue-600"}
          label={"Ofboarding"}
          value={23}
        />
      </div>
    </div>
  );
};

export default EmployeeDistributionChart;
