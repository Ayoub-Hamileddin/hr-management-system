import React from "react";
import { FiTrendingDown, FiTrendingUp } from "react-icons/fi";

const StatCard = ({ id, value, title, Icon, percentage, trend, color = "green" }) => {
  const colorMap = {
    green: "bg-brand-50 text-brand",
    yellow: "bg-accent-light text-yellow-600",
    blue: "bg-blue-50 text-blue-600",
    red: "bg-red-50 text-red-500",
  };

  return (
    <div className="card flex flex-col gap-3 hover:shadow-card-lg transition-shadow duration-200">
      {/* Icon */}
      <div className={`w-11 h-11 rounded-xl flex items-center justify-center ${colorMap[color] || colorMap.green}`}>
        <Icon size={20} />
      </div>

      {/* Value + trend */}
      <div className="flex items-end justify-between">
        <p className="text-2xl font-extrabold text-gray-900">{value}</p>
        <span
          className={`flex items-center gap-1 text-xs font-semibold px-2 py-0.5 rounded-full ${
            trend === "up"
              ? "bg-green-100 text-green-700"
              : "bg-red-100 text-red-600"
          }`}
        >
          {trend === "up" ? <FiTrendingUp size={12} /> : <FiTrendingDown size={12} />}
          {percentage}
        </span>
      </div>

      {/* Title */}
      <p className="text-sm font-semibold text-gray-500">{title}</p>
    </div>
  );
};

export default StatCard;
