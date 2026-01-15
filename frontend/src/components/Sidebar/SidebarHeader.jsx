import React from "react";
import { MdKeyboardDoubleArrowLeft } from "react-icons/md";

const SidebarHeader = () => {
  return (
    <div>
      <div className="flex items-center justify-between">
        <div className="flex gap-2  items-center ">
          <span className="font-bold text-3xl text-[#0cad5d]">H</span>
          <p className="text-lg font-semibold">HRDashboard</p>
        </div>

        <MdKeyboardDoubleArrowLeft className="text-2xl text-stone-300  hover:text-stone-700 cursor-pointer " />
      </div>
    </div>
  );
};

export default SidebarHeader;
