import React from "react";
import { AiOutlineAppstore } from "react-icons/ai";
import { NavLink } from "react-router-dom";

const SidebarSection = () => {
  return (
    <NavLink
      to={"/dashboard"}
      className="bg-[#0cad5d]  w-full flex items-center justify-between  p-4 rounded-lg  hover:bg-green-700  "
    >
      <p className="text-white text-base font-semibold">Dashboard</p>
      <AiOutlineAppstore className="text-xl text-white" />
    </NavLink>
  );
};

export default SidebarSection;
