import React from "react";
import { NavLink } from "react-router-dom";
import { navLinks } from "../../data/menuData";

const SidebarItems = () => {
  return (
    <nav className="flex flex-col gap-1 px-3">
      {navLinks.map(({ path, Icon, id, label, end }) => (
        <NavLink
          to={path}
          key={id}
          end={end}
          className={({ isActive }) =>
            `group flex items-center gap-3 px-3 py-2.5 rounded-xl text-sm font-semibold transition-all duration-150 ${
              isActive
                ? "bg-brand-50 text-brand"
                : "text-gray-500 hover:bg-gray-50 hover:text-gray-900"
            }`
          }
        >
          <Icon
            size={19}
            className="shrink-0 transition-colors duration-150"
          />
          <span>{label}</span>
        </NavLink>
      ))}
    </nav>
  );
};

export default SidebarItems;
