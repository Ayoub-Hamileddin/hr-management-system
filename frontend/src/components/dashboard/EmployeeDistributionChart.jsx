import React from "react";
import { PieChart, Pie, Cell, Tooltip, ResponsiveContainer, Legend } from "recharts";

const data = [
  { name: "Engineering", value: 35, color: "#0cad5d" },
  { name: "Design", value: 20, color: "#F5C754" },
  { name: "Marketing", value: 15, color: "#6366f1" },
  { name: "HR", value: 12, color: "#f97316" },
  { name: "Finance", value: 10, color: "#ec4899" },
  { name: "Others", value: 8, color: "#94a3b8" },
];

const CustomTooltip = ({ active, payload }) => {
  if (active && payload && payload.length) {
    return (
      <div className="bg-white border border-gray-100 rounded-xl shadow-card-lg p-3 text-xs">
        <p className="font-bold" style={{ color: payload[0].payload.color }}>
          {payload[0].name}
        </p>
        <p className="text-gray-600 mt-1">{payload[0].value}% of workforce</p>
      </div>
    );
  }
  return null;
};

const EmployeeDistributionChart = () => {
  return (
    <div className="card h-full">
      <h3 className="text-lg font-bold text-gray-900 mb-1">Employee Distribution</h3>
      <p className="text-sm text-gray-400 mb-4">By department</p>

      <ResponsiveContainer width="100%" height={200}>
        <PieChart>
          <Pie
            data={data}
            cx="50%"
            cy="50%"
            innerRadius={55}
            outerRadius={85}
            paddingAngle={3}
            dataKey="value"
          >
            {data.map((entry, index) => (
              <Cell key={`cell-${index}`} fill={entry.color} stroke="none" />
            ))}
          </Pie>
          <Tooltip content={<CustomTooltip />} />
        </PieChart>
      </ResponsiveContainer>

      {/* Legend */}
      <div className="grid grid-cols-2 gap-x-4 gap-y-2 mt-2">
        {data.map((item) => (
          <div key={item.name} className="flex items-center gap-2">
            <span className="w-2.5 h-2.5 rounded-full shrink-0" style={{ background: item.color }} />
            <span className="text-xs text-gray-600 truncate">{item.name}</span>
            <span className="text-xs font-semibold text-gray-900 ml-auto">{item.value}%</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmployeeDistributionChart;
