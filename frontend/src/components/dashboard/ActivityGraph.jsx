import React from "react";
import {
  ResponsiveContainer,
  CartesianGrid,
  Legend,
  Line,
  LineChart,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";
import { FiCalendar } from "react-icons/fi";

const data = [
  { month: "Jan", productTeam: 65, projectTeam: 45 },
  { month: "Feb", productTeam: 72, projectTeam: 60 },
  { month: "Mar", productTeam: 68, projectTeam: 75 },
  { month: "Apr", productTeam: 80, projectTeam: 70 },
  { month: "May", productTeam: 75, projectTeam: 85 },
  { month: "Jun", productTeam: 90, projectTeam: 80 },
  { month: "Jul", productTeam: 85, projectTeam: 92 },
];

const CustomTooltip = ({ active, payload, label }) => {
  if (active && payload && payload.length) {
    return (
      <div className="bg-white border border-gray-100 rounded-xl shadow-card-lg p-3 text-xs">
        <p className="font-bold text-gray-700 mb-2">{label}</p>
        {payload.map((p) => (
          <div key={p.dataKey} className="flex items-center gap-2 mb-1">
            <span className="w-2 h-2 rounded-full" style={{ background: p.color }} />
            <span className="text-gray-600">{p.name}:</span>
            <span className="font-semibold">{p.value}%</span>
          </div>
        ))}
      </div>
    );
  }
  return null;
};

const ActivityGraph = () => {
  return (
    <div className="card h-full">
      {/* Header */}
      <div className="flex justify-between items-start mb-6">
        <div>
          <h3 className="text-lg font-bold text-gray-900">Team Performance</h3>
          <p className="text-sm text-gray-400 mt-0.5">Monthly performance score (%)</p>
          <div className="flex items-center gap-4 mt-3">
            <span className="flex items-center gap-1.5 text-xs font-semibold text-gray-600">
              <span className="w-3 h-3 rounded-full bg-accent" />
              Product Team
            </span>
            <span className="flex items-center gap-1.5 text-xs font-semibold text-gray-600">
              <span className="w-3 h-3 rounded-full bg-brand" />
              Project Team
            </span>
          </div>
        </div>
        <button className="flex items-center gap-1.5 px-3 py-2 text-xs font-semibold border border-gray-200 rounded-lg hover:bg-gray-50 transition-colors text-gray-600">
          <FiCalendar size={14} />
          Last 7 months
        </button>
      </div>

      {/* Chart */}
      <ResponsiveContainer width="100%" height={200}>
        <LineChart data={data} margin={{ top: 5, right: 10, left: -20, bottom: 5 }}>
          <CartesianGrid strokeDasharray="3 3" stroke="#f0f0f0" vertical={false} />
          <XAxis
            dataKey="month"
            tick={{ fontSize: 11, fill: "#9ca3af" }}
            axisLine={false}
            tickLine={false}
          />
          <YAxis
            tick={{ fontSize: 11, fill: "#9ca3af" }}
            axisLine={false}
            tickLine={false}
            domain={[0, 100]}
          />
          <Tooltip content={<CustomTooltip />} />
          <Line
            type="monotone"
            dataKey="productTeam"
            name="Product Team"
            stroke="#F5C754"
            strokeWidth={2.5}
            dot={{ r: 4, fill: "#F5C754", strokeWidth: 0 }}
            activeDot={{ r: 6, fill: "#F5C754" }}
          />
          <Line
            type="monotone"
            dataKey="projectTeam"
            name="Project Team"
            stroke="#0cad5d"
            strokeWidth={2.5}
            dot={{ r: 4, fill: "#0cad5d", strokeWidth: 0 }}
            activeDot={{ r: 6, fill: "#0cad5d" }}
          />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
};

export default ActivityGraph;
