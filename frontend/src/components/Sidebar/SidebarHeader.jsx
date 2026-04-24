import React from "react";

const SidebarHeader = () => {
  return (
    <div className="flex items-center gap-2.5">
      <div className="w-9 h-9 bg-brand rounded-xl flex items-center justify-center shrink-0 shadow-sm">
        <span className="text-white font-extrabold text-lg leading-none">H</span>
      </div>
      <div>
        <p className="text-base font-extrabold text-gray-900 leading-tight">HRDashboard</p>
        <p className="text-xs text-gray-400">HR Management</p>
      </div>
    </div>
  );
};

export default SidebarHeader;
