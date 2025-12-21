import React from "react";
import { FiHome } from "react-icons/fi";
import { FiUsers } from "react-icons/fi";
import { FiPaperclip } from "react-icons/fi";
import { FiLink } from "react-icons/fi";
import { FiDollarSign } from "react-icons/fi";

import { Link } from "react-router-dom";

const RouteSelect = () => {
  return (
    <div className="space-y-1">
      <RouteTemplate Icon={FiHome} selected={true} text={"Dashboard"} />
      <RouteTemplate Icon={FiUsers} selected={false} text={"Users"} />
      <RouteTemplate Icon={FiPaperclip} selected={false} text={"Invoices"} />
      <RouteTemplate Icon={FiLink} selected={false} text={"Integrations"} />
      <RouteTemplate Icon={FiDollarSign} selected={false} text={"Finance"} />
    </div>
  );
};

export default RouteSelect;

const RouteTemplate = ({ Icon, selected, text }) => {
  return (
    <Link
      className={` flex items-center justify-start 
        gap-2 w-full rounded px-2 py-1.5 text-sm
        transition-[box-shadow,_background-color,_color]
        ${selected ? "bg-white text-stone-950 shadow" : "hover:bg-stone-200 "}
        text-stone-500 shadow-none
    `}
    >
      <Icon className={` text-[16px]  ${selected ? "text-violet-600" : ""}`} />
      <span className="font-semibold">{text}</span>
    </Link>
  );
};
