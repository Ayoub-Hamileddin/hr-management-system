import React from "react";
import AccountToggle from "./AccountToggle";
import RouteSelect from "./SidebarItems";
import Plan from "./SidebarFooter";
import SidebarHeader from "./SidebarHeader";
import SidebarSection from "./SidebarSection";
import SidebarItems from "./SidebarItems";
import SidebarFooter from "./SidebarFooter";

const Sidebar = () => {
  return (
    <div className="sticky  ">
      <div className="overflow-y-scroll  top-4 h-[calc(100vh-100px-100px)]">
        {/* Header */}
        <div className="space-y-7 ">
          <SidebarHeader />
          <SidebarSection />
        </div>

        {/* links items */}
        <div className="mt-[34px]">
          <SidebarItems />
        </div>
        {/* footer */}
      </div>
      <SidebarFooter />
    </div>
  );
};

export default Sidebar;
