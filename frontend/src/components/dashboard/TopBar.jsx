import React from "react";
import { FiCalendar, FiDownload } from "react-icons/fi";

const TopBar = () => {
  const today = new Date().toLocaleDateString("en-US", {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "numeric",
  });

  return (
    <div className="flex items-center justify-between mb-6">
      <div>
        <h1 className="text-2xl font-extrabold text-gray-900">Dashboard Overview</h1>
        <p className="text-sm text-gray-400 mt-1 flex items-center gap-1.5">
          <FiCalendar size={14} />
          {today}
        </p>
      </div>
      <button className="btn-secondary flex items-center gap-2 text-sm">
        <FiDownload size={16} />
        Export Report
      </button>
    </div>
  );
};

export default TopBar;
