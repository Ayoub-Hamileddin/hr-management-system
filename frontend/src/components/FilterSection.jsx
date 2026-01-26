import React from "react";

const FilterSection = ({ id, label, options }) => {
  return (
    <div className="">
      <select
        className="px-5 py-3 border border-stone-300 bg-white rounded-lg  "
        id={id}
        key={id}
        defaultValue={""}
      >
        <option value="" disabled>
          {label}
        </option>
        {options.map((option, index) => (
          <option key={index} value={option}>
            {option}
          </option>
        ))}
      </select>
    </div>
  );
};

export default FilterSection;
