import React, { useState } from "react";
import { CgMail } from "react-icons/cg";
import { CiSearch } from "react-icons/ci";
import { MdMessage, MdOutlineMessage } from "react-icons/md";
import { NavLink } from "react-router-dom";
import IconBadge from "./IconBadge";
const Navbar = () => {
  const [inputValue, setinputValue] = useState("");
  const handleInputChange = (e) => {
    setinputValue(e.target.value);
  };
  return (
    <header className="flex justify-between items-center border-b shadow-lg h-[60px] px-12  ">
      <div className="flex items-center space-x-8 font-sans text-sm font-medium">
        <div className="relative ">
          <input
            type="text"
            placeholder="Search for anything"
            className="px-3 py-2 rounded-sm bg-stone-100 border-1 border-stone-200 placeholder:text-gray-500 placeholder:italic pl-10  outline-none"
            value={inputValue}
            onChange={handleInputChange}
          />
          <div className="absolute inset-y-0 left-0 flex items-center pl-3">
            <CiSearch size={20} />
          </div>
        </div>
        <div className=" pl-7 space-x-7 font-medium text-sm">
          <NavLink>Documents</NavLink>
          <NavLink>News</NavLink>
          <NavLink>Payslip</NavLink>
          <NavLink>Report</NavLink>
        </div>
      </div>
      <div className="flex justify-around items-center gap-8">
        <IconBadge>
          <CgMail size={25} />
        </IconBadge>
        <IconBadge>
          <MdOutlineMessage size={22} />
        </IconBadge>
        <div>
          <img
            src="images/avatar.jpg"
            className="size-8 rounded-full object-cover "
            alt="avatar profile"
          />
        </div>
      </div>
    </header>
  );
};

export default Navbar;
