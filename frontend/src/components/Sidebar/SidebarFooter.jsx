import React, { useState } from "react";
import { FaRegQuestionCircle } from "react-icons/fa";
import { IoMdSettings } from "react-icons/io";
import { MdDarkMode, MdOutlineLightMode } from "react-icons/md";
// className="space-y-5 px-2 sticky  top-[calc(100vh-190px)]"
const SidebarFooter = () => {
  const [dark, setDark] = useState(false);
  return (
    <div className="space-y-5 px-2">
      <div className="flex justify-between items-center">
        <div className="flex gap-2 items-center">
          <FaRegQuestionCircle size={20} className="text-gray-400" />
          <p className="font-sans font-semibold text-sm">Help Center</p>
        </div>
        <button className=" size-6 text-sm bg-red-500 rounded-full text-white">
          8
        </button>
      </div>
      <div className="flex items-center gap-2">
        <IoMdSettings size={20} className="text-gray-400" />
        <p className="font-sans font-semibold text-sm">Setting</p>
      </div>
      <div className="mt-[40px]  flex justify-around items-center  space-x-2 px-3 py-2 rounded-3xl bg-stone-100  ">
        <button
          onClick={() => setDark(!dark)}
          className={`flex items-center space-x-1  w-[100%] px-4 py-1.5  rounded-3xl transition-colors duration-300 ${
            !dark ? "bg-white text-black shadow-lg" : "text-stone-300 "
          } `}
        >
          <MdOutlineLightMode size={18} />
          <span className="text-sm font-semibold"> Light</span>
        </button>
        <button
          onClick={() => setDark(!dark)}
          className={`flex items-center space-x-1  w-[100%] px-4 py-1.5  rounded-3xl transition-colors duration-300  ${
            dark ? "bg-white text-black shadow-lg " : "text-stone-300 "
          }  `}
        >
          <MdDarkMode size={18} />
          <span className="text-sm font-semibold"> Dark</span>
        </button>
      </div>
    </div>
  );
};

export default SidebarFooter;
