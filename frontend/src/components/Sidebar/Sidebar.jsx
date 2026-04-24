import React from "react";
import AccountToggle from "./AccountToggle";
import SidebarHeader from "./SidebarHeader";
import SidebarSection from "./SidebarSection";
import SidebarItems from "./SidebarItems";
import SidebarFooter from "./SidebarFooter";

const Sidebar = () => {
  return (
    <div className="flex flex-col h-full py-5">
      {/* Logo */}
      <div className="px-5 mb-6">
        <SidebarHeader />
      </div>

      {/* Navigation */}
      <div className="flex-1 overflow-y-auto">
        <SidebarItems />
      </div>

      {/* Footer */}
      <div className="px-3 pt-4 border-t border-gray-100">
        <SidebarFooter />
      </div>
    </div>
  );
};

export default Sidebar;
