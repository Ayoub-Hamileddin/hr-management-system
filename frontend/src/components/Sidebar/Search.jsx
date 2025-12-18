import React from "react";
import { FiSearch } from "react-icons/fi";
import { RiSlashCommands2 } from "react-icons/ri";
const Search = () => {
  return (
    <>
      <div
        className="bg-stone-200 mb-4 rounded
       flex items-center px-2 py-1.5 text-sm relative
      "
      >
        <FiSearch className="mr-2 size-5 text-stone-500" />
        <input
          type="text"
          placeholder="Search"
          className="w-full bg-transparent placeholder:text-stone-400
          focus:outline-none
          "
        />
        <span
          className="p-1 text-xs
          flex gap-0.5 items-center rounded
          absolute right-1.5 top-1/2 -translate-y-1/2 
          shadow bg-stone-50"
        >
          <RiSlashCommands2 />
        </span>
      </div>
    </>
  );
};

export default Search;
