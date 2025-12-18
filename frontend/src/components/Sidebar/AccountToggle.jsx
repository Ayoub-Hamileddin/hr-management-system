import React from "react";
import { HiMiniChevronUpDown } from "react-icons/hi2";
const AccountToggle = () => {
  return (
    <div className="border-b pb-4 mt-2 mb-4 border-stone-300 ">
      <button
        className="flex p-0.5 hover:bg-stone-200 rounded 
         transition-colors relative gap-2 w-full  items-center          "
      >
        <img
          src="https://api.dicebear.com/9.x/lorelei/svg?seed=Andrea"
          alt="avatar"
          className="size-8 rounded shrink-0 bg-violet-500"
        />
        <div className="text-start">
          <span className="text-sm font-bold block">Tom is Loading ...</span>
          <span className="text-xs font-medium block text-stone-500 ">
            Tom@gmail.com
          </span>
        </div>
        <HiMiniChevronUpDown className="absolute right-2 top-1/2 translate-y-[-50%] " />
      </button>
    </div>
  );
};

export default AccountToggle;
