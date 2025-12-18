import React from "react";
import AccountToggle from "./AccountToggle";
import Search from "./Search";
import RouteSelect from "./RouteSelect";

const Sidebar = () => {
  return (
    <div className="">
      <div className="overflow-y-scroll sticky top-4 h-[calc(100vh-32px-48px)]">
        <AccountToggle />
        <Search /> {/* TODO:  Cmdk package to implemnt cmd search    */}
        <RouteSelect />
      </div>
    </div>
  );
};

export default Sidebar;
