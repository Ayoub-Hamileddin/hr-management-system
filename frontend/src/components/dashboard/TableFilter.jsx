import React from "react";
import { CiSearch } from "react-icons/ci";
import { filterOptions } from "../../data/filterOptions";
import FilterSection from "../FilterSection";

const TableFilter = () => {
  return (
    <div>
      <div className="flex justify-between items-center">
        <h1 className="text-xl font-semibold">Employees</h1>
        <div className="relative ">
          <input
            type="text"
            placeholder="Search For employees"
            className="border  outline-none border-stone-300 px-5 py-2 rounded-lg  shadow-md  "
          />
          <div className="absolute inset-y-0 right-0 flex items-center p-3 ">
            <CiSearch size={22} />
          </div>
        </div>
      </div>

      <div className="flex items-center justify-around   gap-4   mt-7  ">
        {filterOptions.map(({ id, label, options }) => (
          <FilterSection key={id} id={id} label={label} options={options} />
        ))}
      </div>
    </div>
  );
};

export default TableFilter;
