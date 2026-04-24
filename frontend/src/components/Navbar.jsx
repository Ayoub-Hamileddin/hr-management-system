import React, { useState } from "react";
import { CgMail } from "react-icons/cg";
import { CiSearch } from "react-icons/ci";
import { MdOutlineNotifications } from "react-icons/md";
import { useSelector } from "react-redux";
import { selectcurrentUser } from "../features/auth/authSlice";

const getInitials = (user) => {
  if (!user) return "U";
  const full = `${user.firstName || ""} ${user.lastName || ""}`.trim();
  return full ? full.split(" ").map((n) => n[0]).join("").toUpperCase().slice(0, 2) : "U";
};

const Navbar = () => {
  const [inputValue, setInputValue] = useState("");
  const user = useSelector(selectcurrentUser);

  return (
    <header className="sticky top-0 z-20 flex justify-between items-center bg-white border-b border-gray-100 px-6 h-16 shadow-sm">
      {/* Search */}
      <div className="relative max-w-xs w-full">
        <CiSearch size={18} className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400" />
        <input
          type="text"
          placeholder="Search anything..."
          className="w-full pl-9 pr-4 py-2 text-sm bg-gray-50 border border-gray-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-brand/20 focus:border-brand transition-colors"
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
        />
      </div>

      {/* Right side */}
      <div className="flex items-center gap-3">
        {/* Notification */}
        <button className="relative w-9 h-9 flex items-center justify-center rounded-lg hover:bg-gray-100 transition-colors text-gray-500">
          <MdOutlineNotifications size={22} />
          <span className="absolute top-1.5 right-1.5 w-2 h-2 bg-red-500 rounded-full" />
        </button>

        {/* Mail */}
        <button className="relative w-9 h-9 flex items-center justify-center rounded-lg hover:bg-gray-100 transition-colors text-gray-500">
          <CgMail size={22} />
          <span className="absolute top-1.5 right-1.5 w-2 h-2 bg-brand rounded-full" />
        </button>

        {/* Divider */}
        <div className="h-6 w-px bg-gray-200" />

        {/* Avatar */}
        <div className="flex items-center gap-2.5 cursor-pointer group">
          <div className="w-9 h-9 rounded-full bg-brand flex items-center justify-center text-white text-xs font-bold shrink-0">
            {getInitials(user)}
          </div>
          <div className="hidden md:block">
            <p className="text-sm font-semibold text-gray-900 leading-tight">
              {user ? `${user.firstName} ${user.lastName}` : "Admin"}
            </p>
            <p className="text-xs text-gray-400">{user?.role || "HR Manager"}</p>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
