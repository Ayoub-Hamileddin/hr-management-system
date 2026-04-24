import React, { useState } from "react";
import { FaRegQuestionCircle } from "react-icons/fa";
import { IoMdSettings } from "react-icons/io";
import { MdDarkMode, MdOutlineLightMode } from "react-icons/md";
import { FiLogOut } from "react-icons/fi";
import { useDispatch } from "react-redux";
import { logout } from "../../features/auth/authSlice";
import { useNavigate } from "react-router-dom";
import { toast } from "sonner";

const SidebarFooter = () => {
  const [dark, setDark] = useState(false);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleLogout = () => {
    dispatch(logout());
    toast.success("Logged out successfully");
    navigate("/login");
  };

  return (
    <div className="space-y-1">
      <button className="w-full flex items-center gap-3 px-3 py-2.5 rounded-xl text-sm font-semibold text-gray-500 hover:bg-gray-50 hover:text-gray-900 transition-colors">
        <FaRegQuestionCircle size={18} />
        Help Center
      </button>
      <button className="w-full flex items-center gap-3 px-3 py-2.5 rounded-xl text-sm font-semibold text-gray-500 hover:bg-gray-50 hover:text-gray-900 transition-colors">
        <IoMdSettings size={18} />
        Settings
      </button>
      <button
        onClick={handleLogout}
        className="w-full flex items-center gap-3 px-3 py-2.5 rounded-xl text-sm font-semibold text-red-500 hover:bg-red-50 transition-colors"
      >
        <FiLogOut size={18} />
        Logout
      </button>

      {/* Dark mode toggle */}
      <div className="mt-3 flex items-center gap-1 p-1 rounded-2xl bg-gray-100">
        <button
          onClick={() => setDark(false)}
          className={`flex-1 flex items-center justify-center gap-1.5 py-1.5 rounded-xl text-xs font-semibold transition-all duration-200 ${
            !dark ? "bg-white text-gray-900 shadow-sm" : "text-gray-400"
          }`}
        >
          <MdOutlineLightMode size={15} />
          Light
        </button>
        <button
          onClick={() => setDark(true)}
          className={`flex-1 flex items-center justify-center gap-1.5 py-1.5 rounded-xl text-xs font-semibold transition-all duration-200 ${
            dark ? "bg-white text-gray-900 shadow-sm" : "text-gray-400"
          }`}
        >
          <MdDarkMode size={15} />
          Dark
        </button>
      </div>
    </div>
  );
};

export default SidebarFooter;
