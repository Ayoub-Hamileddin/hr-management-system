import React from "react";
import AccountToggle from "./AccountToggle";

const Sidebar = () => {
  return (
    <div className="">
      <div className="overflow-y-scroll sticky top-4 h-[calc(100vh-32px-48px)]">
        <AccountToggle />
      </div>
    </div>
  );
};

export default Sidebar;
