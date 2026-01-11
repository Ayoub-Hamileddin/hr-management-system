import React from "react";
import { AiOutlineAppstore } from "react-icons/ai";

const SidebarSection = () => {
  return (
    <button className="bg-[#0cad5d]  w-full flex items-center justify-between  p-4 rounded-lg  hover:bg-green-700  ">
      <p className="text-white text-base font-semibold">Dashboard</p>
      <AiOutlineAppstore className="text-xl text-white" />
    </button>
  );
};

export default SidebarSection;
