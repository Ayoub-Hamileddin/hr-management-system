import React from "react";
import { FiCalendar } from "react-icons/fi";

const TopBar = () => {
  const date = new Date();
  return (
    <div className=" border-b pb-4 mt-2 mb-4 border-stone-300 px-4">
      <div className="flex items-center justify-between p-[1px]">
        <div>
          <span className="text-xs font-bold block ">Welcome AYOUB ! </span>
          <span
            className="text-xs font-bold
             text-stone-500 block   "
          >{` ${date.getDate()}/${
            date.getMonth() + 1
          }/${date.getFullYear()}  `}</span>
        </div>
        <button
          className="flex items-center gap-2 bg-stone-100  px-4 py-2 rounded-lg
            transition-colors   hover:bg-violet-100  hover:text-violet-700
            text-sm font-semibold text-stone-900
        "
        >
          <span>Prev 6 month</span>
          <FiCalendar />
        </button>
      </div>
    </div>
  );
};

export default TopBar;
