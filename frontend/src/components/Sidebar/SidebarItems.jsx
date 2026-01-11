import React from "react";
import { NavLink } from "react-router-dom";
import { navLinks } from "../../data/menuData";
import { FiChevronDown, FiChevronLeft } from "react-icons/fi";

const SidebarItems = () => {
  return (
    <nav className="flex flex-col gap-3 ">
      {navLinks.map(({ path, Icon, id, label, hasArrow }) => (
        <NavLink
          to={path}
          key={id}
          className={({ isActive }) =>
            ` group flex items-center justify-between p-3 rounded-xl transition-all hover:bg-green-100 hover:text-green-700 hover:shadow-lg hover
            ${
              isActive
                ? "bg-green-100 text-green-700 shadow-lg "
                : "text-gray- hover:text-gary-100"
            }`
          }
        >
          <div className="flex  items-center gap-2  ">
            <Icon
              className="text-gray-400 group-hover:text-green-700  "
              size={22}
            />
            <p className="font-sans font-semibold text-sm">{label}</p>
          </div>
          {hasArrow && <FiChevronLeft size={16} />}
        </NavLink>
      ))}
    </nav>
  );
};

export default SidebarItems;
